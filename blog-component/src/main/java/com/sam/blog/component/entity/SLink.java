package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="s_link")
public class SLink implements Serializable,Cloneable{
    /** id */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LINK_ID")
    private Integer linkId ;
    /** 链接名称 */
    @Column(name = "LINK_NAME" , length = 150)
    private String linkName ;
    /** 友链描述 */
    @Column(name = "LINK_DESCRIPTION" , length = 600)
    private String linkDescription ;
    /** 友链图标地址 */
    @Column(name = "HEAD_IMG" , length = 150)
    private String  headImg ;
    /** 友链的地址 */
    @Column(name = "LINK_ADDRESS" , length = 300)
    private String linkAddress ;
    /** 联系邮箱 */
    @Column(name = "LINK_EMAIL" , length = 50)
    private String linkEmail ;
    /** 友链点击数 */
    @Column(name = "LINK_CLICK")
    private Integer linkClick ;
    /** 友链权重 */
    @Column(name = "LINK_WEIGHT")
    private Integer linkWeight ;
    /** 友链是否能访问;友链是否能访问，1表示能，0表示不能 */
    @Column(name = "LINK_VISIBLE")
    private Integer linkVisible ;
    /** 友链是否已经处理;友链是否已经处理，1表示已经处理，0表示没有处理 */
    @Column(name = "LINK_DEAL")
    private Integer linkDeal ;
    /** 友链是否显示;友链是否显示，1表示显示，0表示不显示 */
    @Column(name = "LINK_SHOW")
    private Integer linkShow ;
    /** 创建人 */
    @Column(name = "created_user" , length = 50)
    private String createdUser ;
    /** 创建时间 */
    @Column(name = "created_time")
    private Date createdTime ;
    /** 更新人 */
    @Column(name = "updated_user" , length = 50)
    private String updatedUser ;
    /** 更新时间 */
    @Column(name = "updated_time")
    private Date updatedTime ;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
    }

    public Integer getLinkClick() {
        return linkClick;
    }

    public void setLinkClick(Integer linkClick) {
        this.linkClick = linkClick;
    }

    public Integer getLinkWeight() {
        return linkWeight;
    }

    public void setLinkWeight(Integer linkWeight) {
        this.linkWeight = linkWeight;
    }

    public Integer getLinkVisible() {
        return linkVisible;
    }

    public void setLinkVisible(Integer linkVisible) {
        this.linkVisible = linkVisible;
    }

    public Integer getLinkDeal() {
        return linkDeal;
    }

    public void setLinkDeal(Integer linkDeal) {
        this.linkDeal = linkDeal;
    }

    public Integer getLinkShow() {
        return linkShow;
    }

    public void setLinkShow(Integer linkShow) {
        this.linkShow = linkShow;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
