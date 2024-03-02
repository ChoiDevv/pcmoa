package com.example.pcmoa.user.controller;

import com.example.pcmoa.user.entity.dto.UserSignUpDto;
import com.example.pcmoa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 로그인 페이지 렌더링
     * @author ChoiDevv
     * @return String | "/login" 로그인 페이지
     */
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    /**
     * 로그인
     * @author ChoiDevv
     * @return String | "redirect:/" 메인 페이지
     */
    @PostMapping("/login")
    public String login() {
        return "redirect:/";
    }

    /**
     * 회원가입 페이지 렌더링
     * @author ChoiDevv
     * @return String | "user/sign-up" 회원가입 페이지
     */
    @GetMapping("/sign-up")
    public String signup(UserSignUpDto userSignUpDto) {
        return "user/sign-up";
    }

    /**
     * 회원가입
     * @param userSignUpDto 회원가입에서 입력받는 객체, BindingResult 예외처리
     * @author ChoiDevv
     * @exception IncorrectPassword 패스워드 검증 실패, DuplicatedEmail 중복된 이메일, UnknownError 알 수 없는 오류
     * @return String | "redirect:/login" 로그인 페이지
     */
    @PostMapping("/sign-up")
    public String signup(@Validated UserSignUpDto userSignUpDto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return "user/sign-up";
            }

            if (!Objects.equals(userSignUpDto.getPassword(), userSignUpDto.getPasswordCheck())) {
                bindingResult.rejectValue("passwordCheck", "IncorrectPassword", "패스워드가 일치하지 않습니다.");
                return "user/sign-up";
            }
            userService.signup(userSignUpDto);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("DuplicatedEmail", "이미 가입된 사용자가 존재합니다.");
            return "user/sign-up";
        } catch (Exception e) {
            bindingResult.reject("UnknownError", "알 수 없는 오류로 가입을 실패하였습니다. 관리자에게 문의해주세요.");
            return "user/sign-up";
        }
        return "redirect:/login";
    }
}
