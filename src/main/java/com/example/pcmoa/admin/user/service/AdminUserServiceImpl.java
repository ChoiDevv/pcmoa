package com.example.pcmoa.admin.user.service;

import com.example.pcmoa.user.entity.UserStatus;
import com.example.pcmoa.user.entity.dto.UsersDto;
import com.example.pcmoa.user.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserServiceImpl implements com.example.pcmoa.admin.user.service.AdminUserService {

    private final UserRepository userRepository;

    @Override
    public List<UsersDto> userLists() {
        return UsersDto.transformation(userRepository.findAllByUserStatus(UserStatus.ACTIVATE));
    }

    @Override
    public List<UsersDto> inactivateUserLists() {
        return UsersDto.transformation(userRepository.findAllByUserStatus(UserStatus.INACTIVATE));
    }
}
