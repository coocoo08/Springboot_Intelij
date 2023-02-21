package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMember(){
        IntStream.rangeClosed(1, 100).forEach(i ->{

            Member member = Member.builder()
                    .email("user" + i + "@naver.com")
                    .password("1111")
                    .nickname("user" + i)
                    .build();

            memberRepository.save(member);
        });
    }

    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1, 100).forEach(i ->{

            Member member = Member.builder()
                    .email("r" + i + "@naver.com")
                    .password("1111")
                    .nickname("reviewer" + i)
                    .build();

            memberRepository.save(member);
        });
    }
}
