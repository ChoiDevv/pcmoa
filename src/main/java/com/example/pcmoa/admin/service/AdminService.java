package com.example.pcmoa.admin.service;

import com.example.pcmoa.user.entity.dto.UsersDto;

import java.util.List;

public interface AdminService {
    List<UsersDto> userLists();

    List<UsersDto> inactivateUserLists();
}
