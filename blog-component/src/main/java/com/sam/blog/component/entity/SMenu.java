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
@Table(name="s_menu")
public class SMenu implements Serializable,Cloneable{
    /** 菜单ID */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MENU_ID")
    private Integer menuId ;
    /** 菜单名称 */
    @Column(name = "MENU_NAME" , length = 150)
    private String menuName ;
    /** 父类菜单ID */
    @Column(name = "PARENT_MENU_ID")
    private Integer parentMenuId ;
    /** 显示顺序 */
    @Column(name = "ORDER_NUMBER")
    private Integer orderNumber ;
    /** 页面路径(路由地址) */
    @Column(name = "MENU_URL" , length = 150)
    private String menuUrl ;
    /** 类型;菜单类型（0目录 1菜单 2按钮） */
    @Column(name = "MENU_TYPE")
    private Integer menuType ;
    /** 是否显示;菜单状态（0显示 1隐藏） */
    @Column(name = "MENU_VISIBLE")
    private Integer MENU_VISIBLE ;
    /** 菜单图标 */
    @Column(name = "MENU_ICON" , length = 150)
    private String menuIcon ;
    /** 备注 */
    @Column(name = "REMARK" , length = 300)
    private String remark ;
    /** 创建人 */
    @Column(name = "created_user" , length = 50)
    private String createdUser ;
    /** 创建时间 */
    @Column(name = "created_time")
    private Date createdTime ;
    /** 更新人 */
    @Column(name = "updated_user" , length = 50)
    private String updatedUser ;
    /** 更新时间 */
    @Column(name = "updated_time")
    private Date updatedTime ;


}
