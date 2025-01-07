package com.java.square_games_services.controllers;

import com.java.square_games_services.dao.GameDAO;
import com.java.square_games_services.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameDAO gameDAO;

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game createdGame = gameDAO.create(game);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        Game game = gameDAO.read(id);
        if (game != null) {
            return ResponseEntity.ok(game);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameDAO.readAll();
        return ResponseEntity.ok(games);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game) {
        game.setId(id);
        Game updatedGame = gameDAO.update(game);
        if (updatedGame != null) {
            return ResponseEntity.ok(updatedGame);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameDAO.delete(id);
        return ResponseEntity.noContent().build();
    }
}
