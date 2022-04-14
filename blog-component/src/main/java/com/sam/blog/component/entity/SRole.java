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
@Table(name="s_role")
public class SRole implements Serializable,Cloneable{
    /** 角色ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer roleId ;
    /** 角色名称 */
    @Column(name = "ROLE_NAME")
    private String roleName ;
    /** 角色权限字符串 */
    @Column(name = "ROLE_KEY")
    private String roleKey ;
    /** 显示顺序 */
    @Column(name = "ROLE_SORT")
    private Integer roleSort ;
    /** 权限范围;数据范围（1：全部数据权限 2：自定数据权限） */
    @Column(name = "DATA_SCOPE")
    private Integer dataScope ;
    /** 角色状态;角色状态（0正常 1停用） */
    @Column(name = "ROLE_STATUS")
    private Integer ROLE_STATUS ;
    /** 删除标志;删除标志（0代表存在 1代表删除） */
    @Column(name = "DELETE_TAG")
    private Integer deleteTag ;
    /** 创建人 */
    @Column(name = "created_user")
    private String createdUser ;
    /** 创建时间 */
    @Column(name = "created_time")
    private Date createdTime ;
    /** 更新人 */
    @Column(name = "updated_user")
    private String updatedUser ;
    /** 更新时间 */
    @Column(name = "updated_time")
    private Date updatedTime ;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID",referencedColumnName = "ROLE_ID",updatable = false,insertable = false)
    private List<SRoleMenu> sRoleMenuList = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID",referencedColumnName = "ROLE_ID",updatable = false,insertable = false)
    private List<SUserRole> sUserRoleList = new ArrayList<>();
}