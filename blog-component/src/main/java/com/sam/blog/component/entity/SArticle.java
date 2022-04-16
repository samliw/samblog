package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "articleId")
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "articleId")
@Data
@Entity
@Table(name="s_article")
public class SArticle implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 文章ID */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ARTICLE_ID")
    private Integer articleId ;
    /** 文章名称 */
    @Column(name = "ARTICLE_NAME" , length = 300)
    private String articleName ;
    /** 文章摘要 */
    @Column(name = "ARTICLE_SUMMARY" , length = 600)
    private String articleSummary ;
    /** 类型ID */
    @Column(name = "ARTICLE_TYPE_ID")
    private Integer articleTypeId ;
    /** 文章状态;博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱 */
    @Column(name = "ARTICLE_STATUS")
    private Integer articleStatus ;
    /** 是否推荐;是否推荐，1表示推荐，0表示不推荐 */
    @Column(name = "SUPPORT")
    private Integer support ;
    /** 点击次数 */
    @Column(name = "CLICK")
    private Integer click ;
    /** 正文 */
    @Column(name = "ARTICLE_CONTENT" , columnDefinition="text comment '正文'")
    private String articleContent ;
    /** 缩略图地址 */
    @Column(name = "ARTICLE_HEAD_IMG")
    private String articleHeadImg ;
    /** 删除标识;是否删除，1表示删除，0表示不删除 */
    @Column(name = "DELETE_TAG")
    private Integer deleteTag ;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_TYPE_ID", referencedColumnName = "TYPE_ID", insertable = false, updatable = false)
    private SArticleType sArticleType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ARTICLE_ID", insertable = false, updatable = false)
    private List<SArticleTag> sArticleTagList = new ArrayList<>();

}
