package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bird implements Creator, Restarter {
    Texture img;
    Vector2 pos;
    float vy;
    float gravity;
    float rotate;
    Sprite sprite;
    float startRotate;
    Rectangle bounds;

    public Bird() {
        img = new Texture("Bird.png");
        pos = new Vector2(140,380);
        sprite = new Sprite(img);
        vy = 0;
        gravity = -0.65f;
        rotate = -90;
        startRotate = 0;
        bounds = new Rectangle(pos.x, pos.y, 77,55);
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.setPosition(pos.x, pos.y);
        sprite.draw(batch);
        sprite.setRotation(startRotate);
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy = 10;
            if (startRotate < 50) {
                startRotate += 20;
            } else {
                startRotate = 50;
            }
        }
        else {
            if (startRotate > -30){
                startRotate -= 3;
            }
            else {
                startRotate = -30;
            }
        }
        vy += gravity;
        pos.y += vy;

    }

    public void restart() {
        pos = new Vector2(140,380);
        vy = 0;
    }
}
