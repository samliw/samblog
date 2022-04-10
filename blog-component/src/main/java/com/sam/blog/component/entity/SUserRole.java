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
@Table(name="s_user_role")
public class SUserRole implements Serializable,Cloneable{
    /** 用户ID */
    @Id
    private Integer userId ;
    /** 角色ID */
    private Integer roleId ;

}
