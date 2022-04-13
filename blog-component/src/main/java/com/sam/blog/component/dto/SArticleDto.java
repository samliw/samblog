package com.sam.blog.component.dto;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class SArticleDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer articleId ;
    private String articleName ;
    private String articleSummary ;
    private Integer articleTypeId ;
    private Integer articleStatus ;
    private Integer support ;
    private String articleContent ;
    private String articleHeadImg ;
    private Integer click ;
    private Integer deleteTag ;
    private String createUser ;
    private Date createTime ;
    private Date updateTime ;
    private String updateUser ;
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleHeadImg() {
        return articleHeadImg;
    }

    public void setArticleHeadImg(String articleHeadImg) {
        this.articleHeadImg = articleHeadImg;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getClick() {
        if(click == null){
            click = 0;
        }
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getDeleteTag() {
        return deleteTag;
    }

    public void setDeleteTag(Integer deleteTag) {
        this.deleteTag = deleteTag;
    }
}
