package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 救助动物信息：(AnimalRescueInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AnimalRescueInformation")
public class AnimalRescueInformation implements Serializable {

    // AnimalRescueInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_rescue_information_id")
    private Integer animal_rescue_information_id;

    // 动物编号
    @Basic
    private String animal_no;
    // 动物名称
    @Basic
    private String animal_name;
    // 动物类别
    @Basic
    private String animal_category;
    // 动物性别
    @Basic
    private String animal_sex;
    // 年龄
    @Basic
    private String age;
    // 照片
    @Basic
    private String photo;
    // 疫苗接种情况
    @Basic
    private String vaccination;
    // 详情
    @Basic
    private String details;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;











    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
