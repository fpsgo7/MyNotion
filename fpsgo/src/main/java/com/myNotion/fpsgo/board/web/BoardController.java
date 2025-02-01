package com.myNotion.fpsgo.board.web;

import com.myNotion.fpsgo.board.Board;
import com.myNotion.fpsgo.board.service.BoardServiceJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceJPA boardServiceJPA;

    @GetMapping("/board/{no}")
    public Board getBoard(@PathVariable(name="no") long no){
        return boardServiceJPA.getBoard(no);
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
