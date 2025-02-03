package com.myNotion.fpsgo.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Criteria {
    private int pageNum;
    private int amount;

    private String type;
    private String keyword;

    public String[] getTypeArr(){
        return type == null? new String[] {}: type.split("");
    }
}
