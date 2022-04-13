package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_tag")
public class STag implements Serializable,Cloneable{
    /** 标签ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId ;
    /** 标签名称 */
    private String tagName ;
    /** 标签分类-前端显示不用;1 正常 2 推荐 3 一般推荐 4 非常推荐 */
    private Integer tagType ;
    /** 删除标识;删除标识  1 删除  0 未删除 */
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
