package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_role_menu")
public class SRoleMenu implements Serializable{
    /** 角色ID */
    @Id
    @Column(name = "ROLE_ID")
    private Integer roleId ;
    /** 菜单ID */
    @Column(name = "MENU_ID")
    private Integer menuId ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID",insertable = false,updatable = false)
    private SRole sRole;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID",insertable = false,updatable = false)
    private SMenu sMenu;
}