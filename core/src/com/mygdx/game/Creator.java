package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Creator {
    void update();
    void render(SpriteBatch batch);
}
