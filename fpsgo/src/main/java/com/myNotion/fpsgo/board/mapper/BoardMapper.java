package com.myNotion.fpsgo.board.mapper;

import com.myNotion.fpsgo.board.Board;
import com.myNotion.fpsgo.board.Criteria;

import java.util.List;

public interface BoardMapper {
    /*전체 조회*/
    public List<Board> selectBoards();
    /*전체 조회 + 페이지 추가*/
    public List<Board> selectBoardPage(Criteria cri);
}
