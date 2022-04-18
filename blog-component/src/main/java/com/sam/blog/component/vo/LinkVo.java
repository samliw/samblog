package com.sam.blog.component.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "友情链接")
public class LinkVo {
    @ApiModelProperty(value = "主键  ，保存时候不需要")
    private Integer linkId ;
    @ApiModelProperty(value = "链接名称")
    private String linkName ;
    @ApiModelProperty(value = "友链描述")
    private String linkDescription ;
    @ApiModelProperty(value = "友链图标地址")
    private String  headImg ;
    @ApiModelProperty(value = "友链的地址")
    private String linkAddress ;
    @ApiModelProperty(value = "联系邮箱")
    private String linkEmail ;
    @ApiModelProperty(value = "友链权重")
    private Integer linkWeight ;
    @ApiModelProperty(value = "友链是否能访问;友链是否能访问，1表示能，0表示不能")
    private Integer linkVisible ;
    @ApiModelProperty(value = "友链是否已经处理;友链是否已经处理，1表示已经处理，0表示没有处理")
    private Integer linkDeal ;
    @ApiModelProperty(value = "友链是否显示;友链是否显示，1表示显示，0表示不显示")
    private Integer linkShow ;

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
}
