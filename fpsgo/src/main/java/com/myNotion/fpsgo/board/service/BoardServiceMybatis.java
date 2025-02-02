package com.myNotion.fpsgo.board.service;

import com.myNotion.fpsgo.board.Board;
import com.myNotion.fpsgo.board.Criteria;
import com.myNotion.fpsgo.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceMybatis {

    private final BoardMapper boardMapper;

    // 전체 조회
    public List<Board> getBoards(){
        return boardMapper.selectBoards();
    }

    public List<Board> getBoardPage(Criteria cri){
        return boardMapper.selectBoardPage(cri);
    }
}
