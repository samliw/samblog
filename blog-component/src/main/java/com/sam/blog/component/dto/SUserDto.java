package com.sam.blog.component.dto;

import lombok.Data;

import java.util.Date;

public class SUserDto {
    private Integer userId ;
    /** 用户昵称 */
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getDeleteTag() {
        return deleteTag;
    }

    public void setDeleteTag(Integer deleteTag) {
        this.deleteTag = deleteTag;
    }

    public String getLastLoginId() {
        return lastLoginId;
    }

    public void setLastLoginId(String lastLoginId) {
        this.lastLoginId = lastLoginId;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public SUserDto(Integer userId, String loginName) {
        this.userId = userId;
        this.loginName = loginName;
    }
}
