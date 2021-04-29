package com.vdab.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString
public class Game extends BaseEntity{
    private String gameName;
    private String editor;
    private int yearEdition;
    private String age;
    private int minPlayers;
    private int maxPlayers;
    private Category category;
    private String playDuration;
    private Difficulty difficulty;
    private double price;
    private String image;
    private String author;

}
