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
}
