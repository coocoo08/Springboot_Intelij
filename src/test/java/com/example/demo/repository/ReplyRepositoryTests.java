package com.example.demo.repository;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReply() {

        IntStream.rangeClosed(1, 300). forEach(i ->{
            // 1부터 100까지의 임의의 번호
            long bno = (long)(Math.random() * 100) + 1;
            String email = "user" + bno + "@naver.com";

            Board board = Board.builder().bno(bno).build();

            Reply reply = Reply.builder()
                    .text("Reply Text..." + i)
                    .board(board)
                    .replyer(email)
                    .build();

            replyRepository.save(reply);
        });
    }

    @Test
    public void readReply1(){

        Optional<Reply> result = replyRepository.findById(301L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
    }
}
