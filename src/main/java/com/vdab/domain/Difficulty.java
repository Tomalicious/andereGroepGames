package com.vdab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Difficulty extends BaseEntity{

    private String difficultyName;

    public Difficulty(int id, String difficultyName) {
        super(id);
        this.difficultyName = difficultyName;
    }

}
