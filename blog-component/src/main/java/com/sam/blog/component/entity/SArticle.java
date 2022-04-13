package com.sam.blog.component.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_article")
public class SArticle implements Serializable,Cloneable{
    /** 文章ID */
    @Id
    @GeneratedValue
    private Integer articleId ;
    /** 文章名称 */
    private String articleName ;
    /** 文章摘要 */
    private String articleSummary ;
    /** 类型ID */
    private Integer articleTypeId ;
    /** 文章状态;博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱 */
    private Integer articleStatus ;
    /** 是否推荐;是否推荐，1表示推荐，0表示不推荐 */
    private Integer support ;
    /** 点击次数 */
    private Integer click ;
    /** 正文 */
    private String articleContent ;
    /** 缩略图地址 */
    private String articleHeadImg ;
    /** 删除标识;是否删除，1表示删除，0表示不删除 */
    private Integer deleteTag ;
    /** 创建人 */
    private String createUser ;
    /** 创建时间 */
    @Column(name = "create_time", nullable = false)
    private Date createTime ;
    /** 更新时间 */
    private Date updateTime ;
    /** 更新人 */
    private String updateUser ;
}
