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
    /** 用户登录名称 */
    @Column(name = "USER_NAME")
    private String userName ;
    @Column(name = "ERROR_DESCRIBE")
    private String errorDescribe;
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
    @Column(name = "CREATE_TIME")
    private Date createTime ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", updatable = false,insertable = false)
    private SUser sUser;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SUser getsUser() {
        return sUser;
    }

    public void setsUser(SUser sUser) {
        this.sUser = sUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getErrorDescribe() {
        return errorDescribe;
    }

    public void setErrorDescribe(String errorDescribe) {
        this.errorDescribe = errorDescribe;
    }
}
