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
@Table(name="s_user")
public class SUser implements Serializable,Cloneable{
    /** 用户id */
    @Id
    @GeneratedValue
    private Integer userId ;
    /** 用户名称 */
    private String userName ;
    /** 用户类型 */
    private String userType ;
    /** 用户账号 */
    private String loginName ;
    /** 用户邮箱 */
    private String userEmail ;
    /** 用户手机号 */
    private String userPhone ;
    /** 用户性别;用户性别（0男 1女 2未知 */
    private Integer userSex ;
    /** 头像路径 */
    private String userPicture ;
    /** 密码 */
    private String userPassword ;
    /** 用户账号状态;帐号状态（0正常 1停用） */
    private Integer userStatus ;
    /** 删除标识;删除标志（0代表存在 1代表删除） */
    private Integer deleteTag ;
    /** 最后登录Ip */
    private String lastLoginId ;
    /** 最后登录时间 */
    private Date lastTime ;
    /** 创建人 */
    private String createdUser ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedUser ;
    /** 更新时间 */
    private Date updatedTime ;

}