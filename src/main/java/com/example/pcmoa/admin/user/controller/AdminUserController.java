package com.example.pcmoa.admin.user.controller;

import com.example.pcmoa.admin.user.service.AdminUserService;
import com.example.pcmoa.product.entity.dto.ProductDto;
import com.example.pcmoa.user.entity.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;

    /**
     * 관리자 대시보드 페이지 렌더링
     * @author ChoiDevv
     * @return String | "/admin/dashboard" 대시보드(메인) 페이지
     */
    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    /**
     * 관리자 대시보드 사용자 페이지 렌더링
     * @author ChoiDevv
     * @return String | "/admin/dashboard" 사용자 페이지 렌더링
     */
    @GetMapping("/admin/user-list")
    public String users(Model model) {
        List<UsersDto> users = adminUserService.userLists();
        List<UsersDto> inactivateUsers = adminUserService.inactivateUserLists();
        model.addAttribute("users", users);
        model.addAttribute("inactivateUsers", inactivateUsers);
        return "admin/user_list";
    }
}
