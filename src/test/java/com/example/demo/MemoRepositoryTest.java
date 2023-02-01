package com.example.demo;

import com.example.demo.entity.Memo;
import com.example.demo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void InsertDummies() {

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder()
                    .memoText("Sample..." + i)
                    .build();
            //Create!
            memoRepository.save(memo);
        });
    }

    @Test
    public void SelectDummies() {

        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("=============================");

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Test
    public void UpdateDummies() {
        Memo memo = Memo.builder()
                .mno(100L)
                .memoText("Update Text")
                .build();

        memoRepository.save(memo);
    }

    @Test
    public void DeleteDummies() {
        Long mno = 100L;

        memoRepository.deleteById(mno);
    }

    @Test
    public void testPageDefault() {

        // 1페이지 10개
        Pageable pageable = PageRequest.of(0, 10);
        Page<Memo> reault = memoRepository.findAll(pageable);
        System.out.println(reault);
        System.out.println("-----------------------------------------");
        System.out.println("Total Pages: " + reault.getTotalPages());       // 총 몇 페이지
        System.out.println("Total Count: " + reault.getTotalElements());    // 전체 개수
        System.out.println("Page Number: " + reault.getNumber());           // 현재 페이지 번호 0부터 시작
        System.out.println("Page Size: " + reault.getSize());               // 페이지당 데이터 개수
        System.out.println("has next page?: " + reault.hasNext());          // 다음 페이지 존재 여부
        System.out.println("first page?: " + reault.isFirst());             // 시작 페이지(0) 여부

        System.out.println("-----------------------------------------");

        for (Memo memo : reault.getContent()){
            System.out.println(memo);
        }
    }
}