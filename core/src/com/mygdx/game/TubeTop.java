package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

class TubesTop {
    private static final int FLUCTUATION = 130;
    private static final int PIPE_GAP = 260;
    private static final int LOWEST_OPENING = 120;
    private int startPoint;
    Vector2 posTopPipe;
    private Random rand;
    private int speed = 3;
    Rectangle boundsTop;


    public TubesTop(Vector2 pos) {
        posTopPipe = pos;
        rand = new Random();
        startPoint = 400;
        posTopPipe = new Vector2(posTopPipe.x, rand.nextInt(FLUCTUATION )+ PIPE_GAP + LOWEST_OPENING);
        boundsTop = new Rectangle(posTopPipe.x, posTopPipe.y, 138 ,716);
    }

    public TubesTop(){}

    public Rectangle getRect() {
        return boundsTop;
    }

    public void update() {
        posTopPipe.x -= speed;
        if (posTopPipe.x < -138) {
            posTopPipe.x = 1280;
        }
        boundsTop.x = posTopPipe.x;
    }
}
