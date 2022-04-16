package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@Entity
@Table(name="s_article_type")
public class SArticleType implements Serializable{
    /** 类型ID */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TYPE_ID")
    private Integer typeId ;
    /** 类型名称 */
    @Column(name = "TYPE_NAME" , length = 300)
    private String typeName ;
    /** 删除标识;删除标识 1 删除 0 未删除 */
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

}
