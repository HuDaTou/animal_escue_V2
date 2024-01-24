package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 志愿者：(Volunteer)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Volunteer")
public class Volunteer implements Serializable {

    // Volunteer编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteer_id")
    private Integer volunteer_id;

    // 志愿者编号
    @Basic
    private String volunteer_no;
    // 志愿者姓名
    @Basic
    private String volunteer_name;











    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
