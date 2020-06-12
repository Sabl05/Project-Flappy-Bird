package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

class TubesBot {
    private static final int FLUCTUATION = 130;
    private static final int PIPE_GAP = 260;
    private static final int LOWEST_OPENING = 120;
    private int startPoint;
    Vector2 posBotPipe;
    private Random rand;
    private int speed = 3;
    Rectangle boundsBot;

    public TubesBot(Vector2 pos) {
        posBotPipe = pos;
        rand = new Random();
        startPoint = 400;
        posBotPipe = new Vector2(posBotPipe.x,   rand.nextInt(FLUCTUATION )+ PIPE_GAP + LOWEST_OPENING - PIPE_GAP - 712);
        boundsBot = new Rectangle(posBotPipe.x, posBotPipe.y, 138, 716);
    }
    public TubesBot(){}

    public Rectangle getRect() {
        return boundsBot;
    }

    public void update() {
        posBotPipe.x -= speed;
        if(posBotPipe.x < -138){
            posBotPipe.x = 1280;
        }
        boundsBot.x = posBotPipe.x;
    }
}
