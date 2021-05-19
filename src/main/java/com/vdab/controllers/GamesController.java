package com.vdab.controllers;

import com.vdab.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GamesController {

    private GameService gameService = new GameService();

    @GetMapping(value = "/mygames")
    public String showGamePage(Model model){
        model.addAttribute("allGames", gameService.showAllGames());
        model.addAttribute("game",gameService.findByID(1));
        model.addAttribute("address","My street" );
        return "games";
    }
}

