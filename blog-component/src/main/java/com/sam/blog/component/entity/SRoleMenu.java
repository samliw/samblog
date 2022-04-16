package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
@Data
@Entity
@Table(name="s_role_menu")
public class SRoleMenu implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private Integer id;
    /** 角色ID */
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