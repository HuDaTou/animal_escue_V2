package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 志愿者申请：(VolunteerApplication)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "VolunteerApplication")
public class VolunteerApplication implements Serializable {

    // VolunteerApplication编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteer_application_id")
    private Integer volunteer_application_id;

    // 用户编号
    @Basic
    private Integer user_no;
    // 用户姓名
    @Basic
    private String user_name;
    // 申请时间
    @Basic
    private Timestamp application_time;
    // 申请原因
    @Basic
    private String reason_for_application;
    // 个人简介
    @Basic
    private String personal_profile;



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
