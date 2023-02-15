package com.example.demo.controller;

import com.example.demo.domain.UserRequestDto;
import com.example.demo.service.userService;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class Hello {

    private userService userService;

    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }

    /* 회원가입 */
    @PostMapping("/auth/joinProc")
    public String joinProc(@Valid UserRequestDto userDto, Errors errors, Model model) {


        if (errors.hasErrors()) {
            /* 회원가입 실패시 입력 데이터 값을 유지 */
            model.addAttribute("userDto", userDto);

            /* 유효성 통과 못한 필드와 메시지를 핸들링 */
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            /* 회원가입 페이지로 다시 리턴 */
            return "/user/user-join";
        }
        userService.userJoin(userDto);
        return "redirect:/auth/login";
    }
}