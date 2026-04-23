package com.example.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.example.state.GameState;
import com.example.state.PlayingState;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Game {

     private GameState currentState;
      private Pane root;
    private GameObject bird;
    private List<GameObject> pipes = new ArrayList<>();
    private Text scoreText = new Text("Score: 0");
    private int score = 0;
    private AnimationTimer timer;
    private Scene scene;

    public Game() {
       currentState = new PlayingState(this);

        root = new Pane();
        root.setPrefSize(400, 600);

        bird = new Bird(50, 100);
        root.getChildren().addAll(bird, scoreText);
        
        scoreText.setTranslateY(20);
    scene = new Scene(root);
    scene.setOnMouseClicked(e -> currentState.handleInput());
       
}
   public void start() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                currentState.update();
            }
        };
        timer.start(); 
    }

    
    public GameState getCurrentState() {
        return currentState;
    }

    public GameObject getBird() {
        return bird;
    }

    public List<GameObject> getPipes() {
        return pipes;
    }
    public Scene getScene() {
        return scene;
    }


}
