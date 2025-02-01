package com.myNotion.fpsgo.board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Board {
    @Id
    Long no;
    String title;
    String content;
    String author;
}
