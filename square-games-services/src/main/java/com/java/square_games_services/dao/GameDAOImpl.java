package com.java.square_games_services.dao;


import com.java.square_games_services.models.Game;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class GameDAOImpl implements GameDAO {
    private final Map<Long, Game> games = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Game create(Game game) {
        Long id = idGenerator.incrementAndGet();
        game.setId(id);
        games.put(id, game);
        return game;
    }

    @Override
    public Game read(Long id) {
        return games.get(id);
    }

    @Override
    public List<Game> readAll() {
        return new ArrayList<>(games.values());
    }

    @Override
    public Game update(Game game) {
        if (game.getId() != null && games.containsKey(game.getId())) {
            games.put(game.getId(), game);
            return game;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        games.remove(id);
    }
}
