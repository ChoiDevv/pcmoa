package com.example.pcmoa.user.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSignUpDto {

    @Size(min = 3,  message = "최소 3자 이상 입력해주세요.")
    @Email
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$", message = "최소 8자 이상의 문자, 숫자, 특수문자를 포함해주세요.")
    private String password;

    private String passwordCheck;

    @Size(min = 2, max = 10, message = "최소 2자 이상 10자 이하로 입력해주세요.")
    private String name;

    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", message = "양식을 다시 확인해주세요. -를 포함해주세요.")
    private String phoneNumber;

    private String birthday;

    private String sex;

    private boolean agree;

    public UserSignUpDto(String email, String password, String passwordCheck, String name, String phoneNumber,
                         String birthday, String sex, boolean agree) {
        this.email = email;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.sex = sex;
        this.agree = agree;
    }
}
