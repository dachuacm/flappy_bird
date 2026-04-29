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
       

        root = new Pane();
        root.setPrefSize(400, 600);

        bird = new Bird(50, 100);
         pipes.add(new Pipe(300, ThreadLocalRandom.current().nextInt(100, 200)));   
        pipes.add(new Pipe(100, ThreadLocalRandom.current().nextInt(100, 200)));  
        
        root.getChildren().addAll(bird, scoreText);
        root.getChildren().addAll(pipes);

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
        currentState = new PlayingState(this); 
        
    }

    
 
    public AnimationTimer getTimer() {
    return timer;
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

    
public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }
public void updatePipes() {
      for(GameObject pipe : pipes) {
          pipe.update();
      }
    }

public boolean checkCollisions() {
       for(GameObject pipe : pipes) {
           if (bird.collidesWith(pipe)) {
               return true;
           }
       }
       score++;
       scoreText.setText("Score: " + score);
       return false;
    }

     public void detener(){
        timer.stop();
    }

public void restart() {
        score = 0;
        scoreText.setText("Score: 0");
        bird.setTranslateX(50);
        bird.setTranslateY(80);
        pipes.get(0).setTranslateX(300);
        pipes.get(1).setTranslateX(100);
        for(GameObject pipe : pipes) {
            
            pipe.setTranslateY(ThreadLocalRandom.current().nextInt(200, 400));
        }
        setCurrentState(new PlayingState(this));
      
    }
}
