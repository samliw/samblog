package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="s_system_config")
public class SSystemConfig implements Serializable,Cloneable{
    /** 用户id */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id ;
    /** 站点标题 */
    @Column(name = "CONFIG_TITLE" , length = 150)
    private String configTitle;
    /** 副标题 */
    @Column(name = "CONFIG_SUB_TITLE" , length = 300)
    private String configSubTitle;
    /** 站点地址 */
    @Column(name = "CONFIG_ADDRESS" , length = 200)
    private String configAddress;
    /** 站点关键字 */
    @Column(name = "CONFIG_KEY_WORD" , length = 350)
    private String configKeyWord;
    /** 站点描述 */
    @Column(name = "CONFIG_DESCRIBE" , length = 600)
    private String configDescribe;
    /** 电子邮件 */
    @Column(name = "CONFIG_EMAIL" , length = 50)
    private String configEmail;
    /** ICP备案号 */
    @Column(name = "ICP_NUMBER" , length = 50)
    private String ICPNumber;
    /** 状态 */
    @Column(name = "CONFIG_STATUS" , length = 50)
    private String configStatus;
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
    private Date updatedTime ;;
}
