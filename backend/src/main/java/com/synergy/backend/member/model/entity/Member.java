package com.synergy.backend.member.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@NoArgsConstructor
@Getter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String password;
    private String nickname;
    private String cellPhone;
    private LocalDateTime joinDate;
    private LocalDate birthday;
    private String gender;
    private Boolean emailAuthentication;
    private String role;
    private String profileImageUrl;
    @ManyToOne
    @JoinColumn(name = "grade_idx")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "default_address_idx")
    private DeliveryAddress defaultAddress;

    @Builder
    public Member(Long idx, String email, String password, String nickname, String cellPhone, LocalDateTime joinDate,
                  LocalDate birthday, String gender, String role,
                  String profileImageUrl,
                  DeliveryAddress defaultAddress) {
        this.idx = idx;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.cellPhone = cellPhone;
        this.joinDate = joinDate;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAuthentication = false;   // 이메일 인증은 받지 못한 상태
        this.role = "ROLE_USER";     // 최초 생성 USER
//        this.profileImageUrl = profileImageUrl;   // 프로필 이미지는 수정할때만
//        this.grade = "아기손"; //등급 최저
//        this.defaultAddress = defaultAddress; //기본 배송지
    }

    public Member(Long idx, String username, String role){
        this.idx = idx;
        this.email = username;
        this.role = role;
    }
}
