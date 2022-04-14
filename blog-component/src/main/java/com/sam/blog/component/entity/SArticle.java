package com.sam.blog.component.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_article")
public class SArticle implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 文章ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARTICLE_ID")
    private Integer articleId ;
    /** 文章名称 */
    @Column(name = "ARTICLE_NAME")
    private String articleName ;
    /** 文章摘要 */
    @Column(name = "ARTICLE_SUMMARY")
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
    @Column(name = "ARTICLE_CONTENT")
    private String articleContent ;
    /** 缩略图地址 */
    @Column(name = "ARTICLE_HEAD_IMG")
    private String articleHeadImg ;
    /** 删除标识;是否删除，1表示删除，0表示不删除 */
    @Column(name = "DELETE_TAG")
    private Integer deleteTag ;
    /** 创建人 */
    @Column(name = "created_user")
    private String createdUser ;
    /** 创建时间 */
    @Column(name = "created_time")
    private Date createdTime ;
    /** 更新人 */
    @Column(name = "updated_user")
    private String updatedUser ;
    /** 更新时间 */
    @Column(name = "updated_time")
    private Date updatedTime ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_TYPE_ID", referencedColumnName = "TYPE_ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private SArticleType sArticleType;
}
