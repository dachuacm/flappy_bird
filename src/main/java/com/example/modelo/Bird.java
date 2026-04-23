package com.example.modelo;

import java.io.InputStream;

import javafx.scene.image.Image;

public class Bird extends GameObject {
   private static final double GRAVITY = 0.3;
   private static final double JUMP_STRENGTH = -8;
    public Bird(double x, double y) {
         super(x, y);
         velocityY = 0;
         setFitWidth(40);
         setFitHeight(30);
        InputStream imagen=getClass()
        .getResourceAsStream(
            "/images/bird.png");

        Image birdImage = new Image(imagen);
        setImage(birdImage);


     }

     @Override
     public void update() {
            velocityY += GRAVITY;
            setTranslateY(
                getTranslateY() + 
                velocityY);
        }     
        public void jump() {
            velocityY = JUMP_STRENGTH;
        }

    }


