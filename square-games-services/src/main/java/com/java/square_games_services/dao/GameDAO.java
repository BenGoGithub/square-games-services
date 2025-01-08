package com.java.square_games_services.dao;

import com.java.square_games_services.models.GameService;
import java.util.List;

public interface GameDAO {
    GameService create(GameService game);
    GameService read(Long id);
    List<GameService> readAll();
    GameService update(GameService game);
    void delete(Long id);
}
