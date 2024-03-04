package com.example.pcmoa.admin.user.service;

import com.example.pcmoa.user.entity.dto.UsersDto;

import java.util.List;

public interface AdminUserService {
    List<UsersDto> userLists();

    List<UsersDto> inactivateUserLists();
}
