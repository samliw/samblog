package com.sam.blog.component.service;

import com.sam.blog.component.entity.SLink;
import com.sam.blog.component.vo.PageCommonVo;
import org.springframework.data.domain.Page;

public interface SlinkService {

    SLink save(SLink sLink);
    SLink update(SLink sLink);
    SLink getLinkById(Integer id);
    Page<SLink> getLinkPage(PageCommonVo pageCommonVo);

}
