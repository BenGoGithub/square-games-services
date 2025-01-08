package com.java.square_games_services.controllers.heartbeat;

import com.java.square_games_services.dao.GameDAO;
import com.java.square_games_services.models.GameService;
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
    public ResponseEntity<GameService> createGame(@RequestBody GameService game) {
        GameService createdGame = gameDAO.create(game);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameService> getGame(@PathVariable Long id) {
        GameService game = gameDAO.read(id);
        if (game != null) {
            return ResponseEntity.ok(game);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<GameService>> getAllGames() {
        List<GameService> games = gameDAO.readAll();
        return ResponseEntity.ok(games);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameService> updateGame(@PathVariable Long id, @RequestBody GameService game) {
        game.setId(id);
        GameService updatedGame = gameDAO.update(game);
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
