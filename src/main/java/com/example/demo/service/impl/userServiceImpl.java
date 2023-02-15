package com.example.demo.service.impl;

import com.example.demo.domain.UserRequestDto;
import com.example.demo.service.userService;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class userServiceImpl implements userService {
    /* 회원가입 시, 유효성 체크 */
    @Override
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    @Override
    public void userJoin(UserRequestDto userDto) {

    }
}
