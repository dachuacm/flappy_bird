package com.example.state;

import com.example.modelo.Bird;
import com.example.modelo.Game;

public class PlayingState implements GameState {
private Game game;

    public PlayingState(Game game) {
        this.game = game;
        game.getTimer().start(); 
    }

    @Override
    public void update() {
    game.getBird().update();
    game.updatePipes();
    if(game.checkCollisions()){
        game.setCurrentState(new GameOverState(game));
    }
    
    }

    @Override
    public void handleInput() {
          ((Bird)game.getBird()).jump(); 
    }


}
