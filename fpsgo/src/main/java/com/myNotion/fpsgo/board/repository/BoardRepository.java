package com.myNotion.fpsgo.board.repository;

import com.myNotion.fpsgo.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

}
