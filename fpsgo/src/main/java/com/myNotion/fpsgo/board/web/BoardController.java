package com.myNotion.fpsgo.board.web;

import com.myNotion.fpsgo.board.Board;
import com.myNotion.fpsgo.board.Criteria;
import com.myNotion.fpsgo.board.PageDTO;
import com.myNotion.fpsgo.board.service.BoardServiceJPA;
import com.myNotion.fpsgo.board.service.BoardServiceMybatis;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<JSONObject> getBoards(
            @RequestParam(value = "pageNum") String pageNum
            ,@RequestParam(value = "amount")  String amount
            ,@RequestParam(value = "type")  String type
            ,@RequestParam(value = "keyword")  String keyword
    ){
        JSONObject jsonObject = new JSONObject();
        Criteria cri = new Criteria(Integer.parseInt(pageNum) ,Integer.parseInt(amount) ,type,keyword);
        int total = boardServiceMybatis.getTotalCount(cri);
        PageDTO pageDTO = new PageDTO(cri, total);
        List<Board> boards = boardServiceMybatis.getBoardPageSearch(cri);
        jsonObject.put("pageInfo",pageDTO);
        jsonObject.put("boards", boards);
        return ResponseEntity.ok().body(jsonObject);
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
