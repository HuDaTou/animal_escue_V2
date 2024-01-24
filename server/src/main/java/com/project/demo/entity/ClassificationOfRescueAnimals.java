package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 救助动物分类：(ClassificationOfRescueAnimals)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ClassificationOfRescueAnimals")
public class ClassificationOfRescueAnimals implements Serializable {

    // ClassificationOfRescueAnimals编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classification_of_rescue_animals_id")
    private Integer classification_of_rescue_animals_id;

    // 救助动物类别
    @Basic
    private String category_of_animal_rescue;













    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
