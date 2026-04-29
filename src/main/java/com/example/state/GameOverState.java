package com.example.state;


import com.example.modelo.Game;

public class GameOverState implements GameState {
Game game;
    public GameOverState(Game game) {
        this.game = game;
       
    }

    @Override
    public void update() {
       game.detener();
      }

    @Override
    public void handleInput() {
       game.restart();    
    }

}
