package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ReviewRepository reviewRepository;

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

    @Commit
    @Transactional
    @Test
    public void testDeleteMember(){
        Long mid = 2L; // Member의 mid
        Member member = Member.builder().mid(mid).build();

        // 기존
        // memberRepository.deleteById(mid);
        // reviewRepository.deleteByMember(member);

        // 순서 주의
        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);
    }
}
