package com.myNotion.fpsgo.board.web;

import com.myNotion.fpsgo.board.Board;
import com.myNotion.fpsgo.board.Criteria;
import com.myNotion.fpsgo.board.service.BoardServiceJPA;
import com.myNotion.fpsgo.board.service.BoardServiceMybatis;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceJPA boardServiceJPA;
    private final BoardServiceMybatis boardServiceMybatis;

    @GetMapping("/board/{no}")
    public Board getBoard(@PathVariable(name="no") long no){
        return boardServiceJPA.getBoard(no);
    }

    @GetMapping("/boards")
    public List<Board> getBoards(){
        Criteria cri = new Criteria(1,10);
        return boardServiceMybatis.getBoardPage(cri);
    }

    @PostMapping("/board")
    public void save(@RequestBody Board board){
        boardServiceJPA.addBoard(board);
    }

    @DeleteMapping("/board/{no}")
    public void deleteBoard(@PathVariable(name="no") Long no){
        boardServiceJPA.deleteBoard(no);
    }

}
