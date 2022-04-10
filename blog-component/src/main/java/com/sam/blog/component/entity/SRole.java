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
@Table(name="s_role")
public class SRole implements Serializable,Cloneable{
    /** 角色ID */
    @Id
    @GeneratedValue
    private Integer roleId ;
    /** 角色名称 */
    private String roleName ;
    /** 角色权限字符串 */
    private String roleKey ;
    /** 显示顺序 */
    private Integer roleSort ;
    /** 权限范围;数据范围（1：全部数据权限 2：自定数据权限） */
    private Integer dataScope ;
    /** 角色状态;角色状态（0正常 1停用） */
    private Integer roleStatus ;
    /** 删除标志;删除标志（0代表存在 2代表删除） */
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