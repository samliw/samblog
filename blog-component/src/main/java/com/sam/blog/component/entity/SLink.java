package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_link")
public class SLink implements Serializable,Cloneable{
    /** id */
    @Id
    @GeneratedValue
    private Integer linkId ;
    /** 链接名称 */
    private String linkName ;
    /** 友链描述 */
    private String linkDescription ;
    /** 友链图标地址 */
    private String  headImg ;
    /** 友链的地址 */
    private String linkAddress ;
    /** 联系邮箱 */
    private String linkEmail ;
    /** 友链点击数 */
    private Integer linkClick ;
    /** 友链权重 */
    private Integer linkWeight ;
    /** 友链是否能访问;友链是否能访问，1表示能，0表示不能 */
    private Integer linkVisiable ;
    /** 友链是否已经处理;友链是否已经处理，1表示已经处理，0表示没有处理 */
    private Integer linkDeal ;
    /** 友链是否显示;友链是否显示，1表示显示，0表示不显示 */
    private Integer linkShow ;
    /** 创建人 */
    private String createdUser ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedUser ;
    /** 更新时间 */
    private Date updatedTime ;


}
