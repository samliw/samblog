package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_article_type")
public class SArticleType implements Serializable{
    /** 类型ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPE_ID")
    private Integer typeId ;
    /** 类型名称 */
    @Column(name = "TYPE_NAME")
    private String typeName ;
    /** 删除标识;删除标识 1 删除 0 未删除 */
    @Column(name = "DELETE_TAG")
    private Integer deleteTag ;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_TYPE_ID", referencedColumnName = "TYPE_ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<SArticle> sArticleList = new ArrayList<>();
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
