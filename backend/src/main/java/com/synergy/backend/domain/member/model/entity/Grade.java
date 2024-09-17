package com.synergy.backend.domain.member.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "grade")
@Getter
public class Grade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private Integer defaultPercent;
    private Integer gradeRange;
    private Integer recurPercent;
    private Integer upgradePercent;
    private Integer recurNum;
    private Integer upgradeNum;
    private String imageUrl;
    private Integer conditionMin;
    private Integer conditionMax;
}