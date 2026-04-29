package com.example.modelo;

import java.io.InputStream;

import javafx.scene.image.Image;
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

    public void asignarImagen(String ruta){

        InputStream imagen=getClass()
        .getResourceAsStream(
            ruta);

        Image objectImage = new Image(imagen);
        setImage(objectImage);
    }
}