package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_article_type")
public class SArticleType implements Serializable,Cloneable{
    /** 类型ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId ;
    /** 类型名称 */
    private String typeName ;
    /** 删除标识;删除标识 1 删除 0 未删除 */
    private Integer deleteTag ;
    /** 创建人 */
    private String createdUser ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedUser ;
    /** 更新时间 */
    private Date updatedTime ;

}
