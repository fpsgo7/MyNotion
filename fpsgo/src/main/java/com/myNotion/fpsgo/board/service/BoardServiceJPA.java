package com.myNotion.fpsgo.board.service;

import com.myNotion.fpsgo.board.Board;
import com.myNotion.fpsgo.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceJPA{
    private final BoardRepository boardRepository;

    public Board getBoard(Long no) {
        return boardRepository.findById(no)
                .orElseThrow(()->new IllegalArgumentException("해당 번호를 가진 게시글이 없습니다.:" +no));
    }

    public Board addBoard(Board board) {
        return boardRepository
                .save(board);
    }

    public void deleteBoard(Long no) {
        Board board = boardRepository.findById(no)
                .orElseThrow(()->new IllegalArgumentException("삭제할 대상이 없습니다.:" +no));
        boardRepository.delete(board);
    }
}
