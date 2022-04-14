package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_user_role")
public class SUserRole implements Serializable{
    /** 用户ID */
    @Id
    @Column(name = "USER_ID")
    private Integer userId ;
    /** 角色ID */
    @Column(name = "ROLE_ID")
    private Integer roleId ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID",insertable = false,updatable = false)
    private SRole sRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID",insertable = false,updatable = false)
    private SUser sUser;

    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID",insertable = false,updatable = false)
    private List<SUser> sUserList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID",insertable = false,updatable = false)
    private List<SRole> sRoleList = new ArrayList<>();*/

}
