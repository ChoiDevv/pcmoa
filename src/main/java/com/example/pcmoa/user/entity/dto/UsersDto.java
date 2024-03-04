package com.example.pcmoa.user.entity.dto;

import com.example.pcmoa.user.entity.UserRole;
import com.example.pcmoa.user.entity.UserStatus;
import com.example.pcmoa.user.entity.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class UsersDto {
    private Long id;
    private String createdDate;
    private String email;
    private String name;
    private String phoneNumber;
    private String birthday;
    private String sex;
    private UserRole userRole;
    private UserStatus userStatus;

    @Builder
    public UsersDto(Long id, String createdDate, String email, String name, String phoneNumber,
                    String birthday, String sex, UserRole userRole, UserStatus userStatus) {
        this.id = id;
        this.createdDate = createdDate;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.sex = sex;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public static List<UsersDto> transformation(List<Users> users) {
        List<UsersDto> data = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Users user: users) {
            UsersDto dto = UsersDto.builder()
                    .id(user.getId())
                    .createdDate(user.getCreatedDate().format(formatter))
                    .email(user.getEmail())
                    .name(user.getName())
                    .phoneNumber(user.getPhoneNumber())
                    .birthday(user.getBirthday())
                    .sex(user.getSex())
                    .userRole(user.getUserRole())
                    .userStatus(user.getUserStatus())
                    .build();
            data.add(dto);
        }
        return data;
    }
}
