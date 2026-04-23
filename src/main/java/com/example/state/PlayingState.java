package com.example.state;

import com.example.modelo.Bird;
import com.example.modelo.Game;

public class PlayingState implements GameState {
Game game;

    public PlayingState(Game game) {
        this.game = game;
    }

    @Override
    public void update() {
    game.getBird().update();
    }

    @Override
    public void handleInput() {
          ((Bird)game.getBird()).jump(); 
    }


}
