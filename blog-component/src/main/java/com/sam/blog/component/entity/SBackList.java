package com.sam.blog.component.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.models.auth.In;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "backId")
@Data
@Entity
@Table(name="s_back_list")
public class SBackList implements Serializable,Cloneable{
    /** ID */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BACK_ID")
    private Integer backId ;
    /** 文章ID */
    @Column(name = "ARTICLE_ID")
    private Integer articleId ;
    /** ip 地址 */
    @Column(name = "IP_ADDRESS" , length = 50)
    private String ipAddress ;
    /** 访问地址 */
    @Column(name = "LOCATION" , length = 300)
    private String location ;
    /** 浏览器类型 */
    @Column(name = "BROWSER_TYPE" , length = 50)
    private String browserType ;
    /** 访问状态;访问状态,1表示正常，0表示不正常 */
    @Column(name = "STATUS")
    private Integer status ;
    /** 创建时间 */
    @Column(name = "CREATED_TIME")
    private Date createdTime ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID",referencedColumnName = "ARTICLE_ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private SArticle sArticle;


}
