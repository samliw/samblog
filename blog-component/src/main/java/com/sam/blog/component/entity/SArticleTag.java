package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_article_tag")
public class SArticleTag implements Serializable,Cloneable{
    /** 标签ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId ;
    /** 文章ID */
    private Integer articleId ;
    /** 创建人 */
    private String createdUser ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedUser ;
    /** 更新时间 */
    private Date updatedTime ;

}
