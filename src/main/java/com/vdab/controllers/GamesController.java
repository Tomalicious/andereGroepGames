package com.vdab.controllers;

import com.vdab.domain.Category;
import com.vdab.domain.Difficulty;
import com.vdab.domain.Game;
import com.vdab.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GamesController {

    private GameService gameService = new GameService();

    @GetMapping(value = "/")
    public String showGamePage(Model model){
        model.addAttribute("allGames", gameService.showAllGames());
        return "index";
    }

    @GetMapping(value="/newgame")
    public String addGamePage(Model model){
        List<Difficulty> difficultyList = new ArrayList<>();
        difficultyList.add(Difficulty.builder().id(1).difficultyName("very easy").build());
        model.addAttribute("difficulty", difficultyList);


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(Category.builder().id(1).categoryName("combination").build());
        model.addAttribute("category", categoryList);
        return "addgames";
    }

    @PostMapping(value ="/savegame")
    public String saveAGame(@ModelAttribute Game newgame , Category newCategory , Difficulty newDifficulty) throws SQLException {
        gameService.save(newgame , newDifficulty , newCategory);
        return "redirect:/";
    }
}

