package com.sam.blog.component.entity;

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
@Table(name="s_article_tag")
public class SArticleTag implements Serializable,Cloneable{
    /** 标签ID */
    @Id
    @Column(name = "TAG_ID")
    private Integer tagId ;
    /** 文章ID */
    @Column(name = "ARTICLE_ID")
    private Integer articleId ;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ARTICLE_ID" , insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private SArticle sArticle;
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

}
