package com.example.pcmoa.user.entity;

import com.example.pcmoa.config.entity.BaseEntity;
import com.example.pcmoa.user.entity.dto.UserSignUpDto;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "pcmoa_users")
public class Users extends BaseEntity {

    @Column(unique = true)
    private String email;

    @Column
    @NotNull
    private String password;

    @Column
    @NotNull
    private String passwordCheck;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String phoneNumber;

    @Column
    @NotNull
    private String birthday;

    @Column
    @NotNull
    private String sex;

    @NotNull
    private boolean isAgree;

    @Enumerated(value = EnumType.STRING)
    @Column
    @NotNull
    private UserRole userRole;

    @Enumerated(value = EnumType.STRING)
    @Column
    private UserStatus userStatus;

    @Builder
    public Users(String email, String password, String passwordCheck, String name, String phoneNumber, String birthday,
                 String sex, boolean isAgree, UserRole userRole, UserStatus userStatus) {
        this.email = email;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.sex = sex;
        this.isAgree = isAgree;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public static Users toEntity(UserSignUpDto userSignUpDto, UserRole userRole, UserStatus userStatus, PasswordEncoder passwordEncoder) {
        return Users.builder()
                .email(userSignUpDto.getEmail())
                .password(passwordEncoder.encode(userSignUpDto.getPassword()))
                .passwordCheck(passwordEncoder.encode(userSignUpDto.getPasswordCheck()))
                .name(userSignUpDto.getName())
                .phoneNumber(userSignUpDto.getPhoneNumber())
                .birthday(userSignUpDto.getBirthday())
                .sex(userSignUpDto.getSex())
                .isAgree(userSignUpDto.isAgree())
                .userRole(userRole)
                .userStatus(userStatus)
                .build();
    }
}
