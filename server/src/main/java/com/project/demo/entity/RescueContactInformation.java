package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 救助联系方式：(RescueContactInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RescueContactInformation")
public class RescueContactInformation implements Serializable {

    // RescueContactInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rescue_contact_information_id")
    private Integer rescue_contact_information_id;

    // 救助站名称
    @Basic
    private String name_of_rescue_station;
    // 位置
    @Basic
    private String position;
    // 动物名称
    @Basic
    private String animal_name;
    // 救助要求
    @Basic
    private String salvage_requirements;
    // 注意事项
    @Basic
    private String matters_needing_attention;
    // 联系人
    @Basic
    private String contacts;
    // 联系方式
    @Basic
    private String contact_information;

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
