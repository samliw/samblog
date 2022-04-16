package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
@Data
@Entity
@Table(name="s_user_role")
public class SUserRole implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private Integer id;
    /** 用户ID */
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


}
