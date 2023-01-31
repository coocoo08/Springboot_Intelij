package com.example.demo;

import com.example.demo.domain.Memo;
import com.example.demo.domain.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void InsertDummies() {

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Memo memo = Memo.builder()
                    .memoText("Sample..." + i)
                    .build();
            //Create!
            memoRepository.save(memo);
        });
    }

    @Test
    public void SelectDummies() {

        Long id = 10L;

        Optional<Memo> result = memoRepository.findById(id);

        System.out.println("=============================");

        if(result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Test
    public void UpdateDummies() {
        Memo memo = Memo.builder()
                .id(10L)
                .memoText("Update Text")
                .build();

        memoRepository.save(memo);
    }

    @Test
    public void DeleteDummies() {
        Long id = 10L;

        memoRepository.deleteById(id);
    }
}