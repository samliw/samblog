package com.sam.blog.component.service.impl;


import com.sam.blog.common.exception.BusinessException;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.common.util.SystemContextUtils;
import com.sam.blog.component.dto.SArticleDto;
import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.entity.SUserRole;
import com.sam.blog.component.mapper.SArticleMapper;
import com.sam.blog.component.mapper.SUserRoleMapper;
import com.sam.blog.component.service.SArticleService;
import com.sam.blog.component.vo.PageCommonVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class SArticleServiceImpl implements SArticleService {

    @Resource
    private SArticleMapper sArticleMapper;
    @Resource
    private SUserRoleMapper sUserRoleMapper;
    @Override
    public SArticle getFindOne() {
        return sArticleMapper.getOne(1);
    }

    @Override
    public Page<SArticle> getUserRoleFindOne() {
        String aname = "erw";
        String key = "";
        Sort sort = Sort.by(Sort.Direction.DESC, "createdTime");
        Pageable pageable = PageRequest.of(0,10,sort);
        Specification<SArticle> specification = new Specification<SArticle>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> listp = new ArrayList<>();
                if(StringUtils.isNotEmpty(aname)){
                    listp.add(cb.like(root.get("articleName").as(String.class),aname));
                }
                Predicate[] predicates = new Predicate[listp.size()];
                return query.where(listp.toArray(predicates)).getRestriction();
            }
        };
        return sArticleMapper.findAll(specification,pageable);
    }

    @Transactional
    @Override
    public void insertArticle(SArticleDto sArticleDto) {
        if(StringUtils.isEmpty(sArticleDto.getArticleName())){
            throw new BusinessException(ResultCode.INCOMPLETE_PARAM);
        }
        System.out.println("cs");
        SArticle sArticle = new SArticle();
        SystemContextUtils.copyBean(sArticleDto,  sArticle);
        sArticleMapper.save(sArticle);
    }

    @Transactional
    @Override
    public void updateArticle(SArticleDto sArticleDto) {
        if(StringUtils.isEmpty(sArticleDto.getArticleName())){
            throw new BusinessException(ResultCode.INCOMPLETE_PARAM);
        }
        SArticle sArticle = sArticleMapper.getOne(sArticleDto.getArticleId());
        if(sArticle == null){
            throw new BusinessException(ResultCode.INCOMPLETE_PARAM);
        }
        SystemContextUtils.copyBean(sArticleDto,  sArticle);
        sArticleMapper.save(sArticle);
    }

    @Override
    public SArticleDto getArticleById(Integer articleId) {
        SArticleDto sArticleDto = new SArticleDto();
        SArticle sArticle = sArticleMapper.getOne(articleId);
        System.out.println(sArticle.toString());
        SystemContextUtils.copyBean(sArticle,  sArticleDto);
        return sArticleDto;
    }

    @Override
    public Page<SArticle> getPageArticle(PageCommonVo vo) {
        Pageable pageable = PageRequest.of(vo.getPageNumber(),vo.getPageSize(),Sort.by(Sort.Direction.DESC, "createdTime"));
        Specification<SArticle> specification = new Specification<SArticle>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> listp = new ArrayList<>();
                if(StringUtils.isNotEmpty(vo.getSearchName())){
                    listp.add(cb.like(root.get("articleName").as(String.class),"%"+vo.getSearchName()+"%"));
                }
                Predicate[] predicates = new Predicate[listp.size()];
                return query.where(listp.toArray(predicates)).getRestriction();
            }
        };
        return sArticleMapper.findAll(specification,pageable);
    }


}
