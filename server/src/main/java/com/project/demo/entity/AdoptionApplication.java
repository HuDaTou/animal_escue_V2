package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 领养申请：(AdoptionApplication)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AdoptionApplication")
public class AdoptionApplication implements Serializable {

    // AdoptionApplication编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adoption_application_id")
    private Integer adoption_application_id;

    // 动物编号
    @Basic
    private String animal_no;
    // 动物名称
    @Basic
    private String animal_name;
    // 动物性别
    @Basic
    private String animal_sex;
    // 用户编号
    @Basic
    private Integer user_no;
    // 领养人姓名
    @Basic
    private String name_of_adopter;
    // 联系方式
    @Basic
    private String contact_information;
    // 是否爱护动物
    @Basic
    private String do_you_care_for_animals;
    // 家庭收养动物环境
    @Basic
    private String family_adoption_environment;



    // 审核状态
    @Basic
    private String examine_state;







    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
