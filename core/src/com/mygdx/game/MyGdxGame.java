package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;


public class MyGdxGame extends ApplicationAdapter implements Restarter {
	SpriteBatch batch;
	Background bg;
	Bird bird;
	boolean gameOver;
	Texture restart;
	Tube tube;
	TubesTop top;
	TubesBot bot;

	@Override
	public void create() {
		batch = new SpriteBatch();
		bg = new Background();
		bird = new Bird();
		tube = new Tube();
		restart = new Texture("restart.png");
		gameOver = false;
		top = new TubesTop();
		bot = new TubesBot();

	}

	@Override
	public void render() {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);
		tube.render(batch);

		if (!gameOver) {
			bird.render(batch);
		} else {
			batch.draw(restart, 100, 100);
		}

		batch.end();
	}

	public void update() {
		bg.update();
		bird.update();
		tube.update();
		if (bird.bounds == top.getRect() || bird.bounds == bot.getRect()){
			gameOver = true;
		}
		if (bird.pos.x < 0 || bird.pos.y > 800) {
			 gameOver = true;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver){
			restart();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public void restart(){
		bird.restart();
		tube.restart();
		gameOver = false;
	}
}
