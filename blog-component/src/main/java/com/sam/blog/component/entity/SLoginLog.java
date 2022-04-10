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
@Table(name="s_login_log")
public class SLoginLog implements Serializable,Cloneable{
    /** 日志ID */
    @Id
    @GeneratedValue
    private String loginId ;
    /** 用户ID */
    private String userId ;
    /** 登录地址 */
    private String loginLocation ;
    /** IP地址 */
    private String ipAddress ;
    /** 状态;登录状态（0成功 1失败） */
    private Integer status ;
    /** 更新时间 */
    private Date updatedTime ;

}
