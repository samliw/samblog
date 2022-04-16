package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
@Data
@Entity
@Table(name="s_article_tag")
public class SArticleTag implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    /** 标签ID */
    @Column(name = "TAG_ID")
    private Integer tagId ;
    /** 文章ID */
    @Column(name = "ARTICLE_ID")
    private Integer articleId ;
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
    @JoinColumn(name = "TAG_ID",referencedColumnName = "TAG_ID",insertable = false,updatable = false)
    private STag sTag;



}
