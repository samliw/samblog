package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_tag")
public class STag implements Serializable,Cloneable{
    /** 标签ID */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TAG_ID")
    private Integer tagId ;
    /** 标签名称 */
    @Column(name = "TAG_NAME" , length = 150)
    private String tagName ;
    /** 标签分类-前端显示不用;1 正常 2 推荐 3 一般推荐 4 非常推荐 */
    @Column(name = "TAG_TYPE")
    private Integer tagType ;
    /** 删除标识;删除标识  1 删除  0 未删除 */
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
