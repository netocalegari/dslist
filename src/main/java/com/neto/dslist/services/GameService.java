package com.neto.dslist.services;

import com.neto.dslist.dtos.GameDTO;
import com.neto.dslist.dtos.GameMinDTO;
import com.neto.dslist.entities.Game;
import com.neto.dslist.exceptions.BadRequestException;
import com.neto.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new BadRequestException("Game not found"));

        return new GameDTO(game);
    }
}
