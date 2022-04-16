package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "loginId")
@Data
@Entity
@Table(name="s_login_log")
public class SLoginLog implements Serializable,Cloneable{
    /** 日志ID */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LOGIN_ID")
    private Integer loginId ;
    /** 用户ID */
    @Column(name = "USER_ID")
    private Integer userId ;
    /** 登录地址 */
    @Column(name = "LOGIN_LOCATION" , length = 150)
    private String loginLocation ;
    /** IP地址 */
    @Column(name = "IP_ADDRESS" , length = 50)
    private String ipAddress ;
    /** 状态;登录状态（0成功 1失败） */
    @Column(name = "STATUS")
    private Integer status ;
    /** 更新时间 */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", updatable = false,insertable = false)
    private SUser sUser;
}
