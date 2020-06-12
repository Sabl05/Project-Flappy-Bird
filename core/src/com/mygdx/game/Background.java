package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Background implements Creator {

    class BgImg {
        private Texture tx;
        private Vector2 pos;

        public BgImg(Vector2 pos){
            tx = new Texture("bg-img.jpg");
            this.pos = pos;
        }
    }

    private double speed;
    private BgImg[] imgs;

    public Background() {
        speed = 3.25;
        imgs = new BgImg[3];
        imgs[0] = new BgImg(new Vector2(0,0));
        imgs[1] = new BgImg(new Vector2(1280,0));
        imgs[2] = new BgImg(new Vector2(2560,0));
    }

    @Override
    public void render(SpriteBatch batch) {
        for (int i = 0; i < imgs.length; i++){
            batch.draw(imgs[i].tx, imgs[i].pos.x, imgs[i].pos.y);
        }

    }

    @Override
    public void update() {
        for (int i = 0; i < imgs.length; i++){
            imgs[i].pos.x -= speed;
        }
        if (imgs[0].pos.x < -2560){
            imgs[0].pos.x = 0;
            imgs[1].pos.x = 1280;
            imgs[2].pos.x = 2560;
        }
    }

}