package com.example.demo.repository.search;

import com.example.demo.entity.Board;
import com.example.demo.entity.QBoard;
import com.example.demo.entity.QReply;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {

    private SearchBoardRepositoryImpl boardRepository;

    public SearchBoardRepositoryImpl(){
        super(Board.class);
    }

    @Override
    public Board search1() {
        log.info("search1......................................");
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;
        JPQLQuery<Board> jpqlQuery = from(board);
        jpqlQuery.select(board).where(board.bno.eq(1L));
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board));

        log.info("------------------------");
        log.info(jpqlQuery);
        log.info("------------------------");

        List<Board> result = jpqlQuery.fetch();

        return null;
    }
}
