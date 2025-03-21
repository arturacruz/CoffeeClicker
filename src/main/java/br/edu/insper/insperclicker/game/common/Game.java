package br.edu.insper.insperclicker.game.common;

import br.edu.insper.insperclicker.exception.GameResourceAlreadyOwnedException;
import br.edu.insper.insperclicker.exception.GameResourceNotFoundException;
import br.edu.insper.insperclicker.exception.GameResourceNotUnlockedException;
import br.edu.insper.insperclicker.exception.InsufficientFundsException;

import java.time.LocalDateTime;

public class Game
{

    private LocalDateTime lastRequest;
    private final Graduation graduation;
    private final Player player;

    public Game(String playerName)
    {
        // TODO: Call init functions
        System.out.println("Initializing game for " + playerName);
        lastRequest = LocalDateTime.now();
        this.graduation = new Graduation();

        this.player = new Player(playerName);
    }

    public void doPassiveActions()
    {
        this.graduation.doPassiveActions(lastRequest);
        updateLastRequest();

    }

    public void click(int clickAmount)
    {
        this.graduation.click(clickAmount);
    }

    public void buyBuilding(String buildingName, int amount) throws GameResourceNotFoundException,
                                                                    InsufficientFundsException,
                                                                    GameResourceNotUnlockedException
    {
        graduation.buyBuilding(buildingName, amount);
    }

    public void buyUpgrade(String upgradeName) throws GameResourceNotFoundException,
                                                        GameResourceAlreadyOwnedException,
                                                        GameResourceNotUnlockedException,
                                                        InsufficientFundsException
    {
        graduation.buyUpgrade(upgradeName);
    }

    public Graduation getCurrentGraduation()
    {
        return this.graduation;
    }

    public LocalDateTime getLastRequest()
    {
        return lastRequest;
    }

    private void updateLastRequest()
    {
        this.lastRequest = LocalDateTime.now();
    }

    public Player getPlayer() {
        return player;
    }
}
