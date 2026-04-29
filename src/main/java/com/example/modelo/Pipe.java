package com.example.modelo;

import java.util.concurrent.ThreadLocalRandom;

public class Pipe extends GameObject{

    private static final double SPEED = 2;

    public Pipe(double x, double y) {
        super(x, y);
         setFitWidth(60);
        setFitHeight(400);
        asignarImagen("/images/up_pipe.png");
        
    }

    @Override
    public void update() {
         setTranslateX(getTranslateX() - SPEED);
        if(getTranslateX()<-60) {
            setTranslateX(400);   
                setTranslateY(ThreadLocalRandom.current().nextInt(200, 400));
        }    

        
    }

}
