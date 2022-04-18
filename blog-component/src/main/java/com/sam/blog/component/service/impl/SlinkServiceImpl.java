package com.sam.blog.component.service.impl;

import com.sam.blog.common.exception.BusinessException;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.common.util.SystemContextUtils;
import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.entity.SLink;
import com.sam.blog.component.mapper.SLinkMapper;
import com.sam.blog.component.service.SlinkService;
import com.sam.blog.component.vo.PageCommonVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class SlinkServiceImpl implements SlinkService {
    @Resource
    private SLinkMapper linkMapper;

    @Override
    public SLink save(SLink sLink) {
        return linkMapper.save(sLink);
    }

    @Override
    public SLink update(SLink sLink) {
        SLink link = linkMapper.getOne(sLink.getLinkId());
        if (link == null){
            throw new BusinessException(ResultCode.INCOMPLETE_PARAM);
        }
        SystemContextUtils.copyBean(sLink,  link);
        return linkMapper.save(link);
    }

    @Override
    public SLink getLinkById(Integer id) {
        return linkMapper.getOne(id);
    }

    @Override
    public Page<SLink> getLinkPage(PageCommonVo pageCommonVo) {
        Pageable pageable = PageRequest.of(pageCommonVo.getPageNumber(),pageCommonVo.getPageSize(), Sort.by(Sort.Direction.DESC, "createdTime"));
        Specification<SLink> specification = new Specification<SLink>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> listp = new ArrayList<>();
                if(StringUtils.isNotEmpty(pageCommonVo.getSearchName())){
                    listp.add(cb.like(root.get("articleName").as(String.class),"%"+pageCommonVo.getSearchName()+"%"));
                }
                Predicate[] predicates = new Predicate[listp.size()];
                return query.where(listp.toArray(predicates)).getRestriction();
            }
        };
        return linkMapper.findAll(specification,pageable);
    }
}
