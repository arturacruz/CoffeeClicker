package br.edu.insper.coffeeclicker.game;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GameState
{
    private final HashMap<String, Game> gameStates = new HashMap<>();

    public Game getGameInstance(String player)
    {
        if(!gameStates.containsKey(player))
        {
            gameStates.put(player, new Game(player));
        }
        Game game = gameStates.get(player);
        game.doPassiveActions();
        return game;
    }

}
