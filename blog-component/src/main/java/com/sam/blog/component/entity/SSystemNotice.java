package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Data
@Entity
@Table(name="s_system_notice")
public class SSystemNotice implements Serializable,Cloneable{
    /** 通知ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeId ;
    /** 通知名称 */
    private String noticeName ;
    /** 通知内容 */
    private String noticeContent ;
    /** 删除标识;是否删除，1表示删除，0表示不删除 */
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
