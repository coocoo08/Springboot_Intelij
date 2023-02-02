package com.example.demo.controller;

import com.example.demo.domain.SampleDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/ex1")
    public void ex1() {
        log.info("ex1...................................");

    }

    @GetMapping({"/ex2"})
    public void exModel(Model model){
        List<SampleDto> list = IntStream.rangeClosed(1, 20).asLongStream().
                mapToObj(i -> {
                  SampleDto dto = SampleDto.builder()
                          .sno(i)
                          .first("First.." + i)
                          .last("last.." + i)
                          .regTime(LocalDateTime.now())
                          .build();
                  return dto;
                }).collect(Collectors.toList());
        model.addAttribute("list", list);
    }
}
