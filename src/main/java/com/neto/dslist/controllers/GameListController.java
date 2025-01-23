package com.neto.dslist.controllers;

import com.neto.dslist.dtos.GameListDTO;
import com.neto.dslist.dtos.GameMinDTO;
import com.neto.dslist.dtos.MovementDTO;
import com.neto.dslist.services.GameListService;
import com.neto.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/movement")
    public void move(@PathVariable Long listId, @RequestBody MovementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getTargetIndex());
    }
}
