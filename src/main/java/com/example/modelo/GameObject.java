package com.example.modelo;

import javafx.scene.image.ImageView;

public abstract class GameObject extends ImageView {

    protected double velocityX;
    protected double velocityY;

    public GameObject(double x,double y) {
        setTranslateX(x);
        setTranslateY(y);
    }

    public abstract void update();
        
    public boolean collidesWith(GameObject other) {
        return this.getBoundsInParent().
        intersects(
            other.getBoundsInParent());
    }
}