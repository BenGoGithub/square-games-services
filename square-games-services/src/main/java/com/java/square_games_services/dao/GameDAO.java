package com.java.square_games_services.dao;

import com.java.square_games_services.models.Game;
import java.util.List;

public interface GameDAO {
    Game create(Game game);
    Game read(Long id);
    List<Game> readAll();
    Game update(Game game);
    void delete(Long id);
}
