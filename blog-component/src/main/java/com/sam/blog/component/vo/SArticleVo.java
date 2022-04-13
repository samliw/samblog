package com.sam.blog.component.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "文章选项")
public class SArticleVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "文章ID")
    private Integer articleId ;
    @ApiModelProperty(value = "文章名称")
    private String articleName ;
    @ApiModelProperty(value = "文章摘要")
    private String articleSummary ;
    @ApiModelProperty(value = "类型ID")
    private Integer articleTypeId ;
    @ApiModelProperty(value = "文章状态;博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱")
    private Integer articleStatus ;
    @ApiModelProperty(value = "是否推荐;是否推荐，1表示推荐，0表示不推荐 ")
    private Integer support ;
    @ApiModelProperty(value = "正文")
    private String articleContent ;
    @ApiModelProperty(value = "缩略图地址")
    private String articleHeadImg ;

}
