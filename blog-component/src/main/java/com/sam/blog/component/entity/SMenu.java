package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_menu")
public class SMenu implements Serializable,Cloneable{
    /** 菜单ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId ;
    /** 菜单名称 */
    private String menuName ;
    /** 父类菜单ID */
    private Integer parentMenuId ;
    /** 显示顺序 */
    private Integer orderNumber ;
    /** 地址 */
    private String menuUrl ;
    /** 类型;菜单类型（0目录 1菜单 2按钮） */
    private Integer menuType ;
    /** 是否显示;菜单状态（0显示 1隐藏） */
    private Integer menuVisible ;
    /** 菜单图标 */
    private String menuIcon ;
    /** 备注 */
    private String remark ;
    /** 创建人 */
    private String createdUser ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedUser ;
    /** 更新时间 */
    private Date updatedTime ;

}
