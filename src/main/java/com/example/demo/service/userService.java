package com.example.demo.service;

import com.example.demo.domain.UserRequestDto;
import org.springframework.validation.Errors;

import java.util.Map;

public interface userService {

    Map<String, String> validateHandling(Errors errors);
    void userJoin(UserRequestDto userDto);
}
