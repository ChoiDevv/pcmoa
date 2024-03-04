package com.example.pcmoa.admin.controller;

import com.example.pcmoa.admin.service.AdminService;
import com.example.pcmoa.user.entity.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

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
     * 관리자 대시보드 사용자 현황 페이지 렌더링
     * @author ChoiDevv
     * @return String | "/admin/dashboard" 사용자 현황 페이지 렌더링
     */
    @GetMapping("/admin/user-list")
    public String userLists(Model model) {
        List<UsersDto> users = adminService.userLists();
        List<UsersDto> inactivateUsers = adminService.inactivateUserLists();
        model.addAttribute("users", users);
        model.addAttribute("inactivateUsers", inactivateUsers);
        return "admin/user_list";
    }
}
