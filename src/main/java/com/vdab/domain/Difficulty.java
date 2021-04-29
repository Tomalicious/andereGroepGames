package com.vdab.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class Difficulty extends BaseEntity{

    private String difficultyName;

    public Difficulty(int id, String difficultyName) {
        super(id);
        this.difficultyName = difficultyName;
    }

}
