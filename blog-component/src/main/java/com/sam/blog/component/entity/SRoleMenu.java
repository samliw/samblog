package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_role_menu")
public class SRoleMenu implements Serializable,Cloneable{
    /** 角色ID */
    @Id
    private Integer roleId ;
    /** 菜单ID */
    private Integer menuId ;
}