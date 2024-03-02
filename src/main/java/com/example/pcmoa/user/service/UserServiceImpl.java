package com.example.pcmoa.user.service;

import com.example.pcmoa.user.entity.Users;
import com.example.pcmoa.user.entity.dto.UserSignUpDto;
import com.example.pcmoa.user.entity.repository.UserRepository;
import com.example.pcmoa.user.entity.repository.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(UserSignUpDto userSignUpDto) {
        UserRole role = UserRole.USER;
        Users user = Users.toEntity(userSignUpDto, role, passwordEncoder);
        userRepository.save(user);
    }
}
