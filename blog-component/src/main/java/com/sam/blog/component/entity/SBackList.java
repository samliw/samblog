package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.models.auth.In;
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
@Table(name="s_back_list")
public class SBackList implements Serializable,Cloneable{
    /** ID */
    @Id
    @GeneratedValue
    private Integer backId ;
    /** 文章ID */
    private Integer articleId ;
    /** ip 地址 */
    private String ipAddress ;
    /** 访问地址 */
    private String location ;
    /** 浏览器类型 */
    private String browserType ;
    /** 访问状态;访问状态,1表示正常，0表示不正常 */
    private Integer status ;
    /** 创建时间 */
    private Date createdTime ;


}
