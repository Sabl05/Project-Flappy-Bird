package com.mygdx.game;

        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.math.Rectangle;
        import com.badlogic.gdx.math.Vector2;
        import java.util.Random;

public class Tube implements Creator, Restarter{
    static TubesBot[] botTubes;
    static TubesTop[] topTubes;
    public static  final int TUBE_WIDTH = 138;
    private Texture topPipe, bottomPipe;

    public Tube(){
        topPipe = new Texture("top.jpg");
        bottomPipe = new Texture("bottom.jpg");
        int startPoint = 400;

        botTubes = new TubesBot[3];
        topTubes = new TubesTop[3];
        for (int i = 0; i < botTubes.length; i++) {
            botTubes[i] = new TubesBot(new Vector2(startPoint, 0));
            topTubes[i] = new TubesTop(new Vector2(startPoint, 0));
            startPoint += 520;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        for (int i = 0; i < botTubes.length; i++) {
            batch.draw(bottomPipe, botTubes[i].posBotPipe.x, botTubes[i].posBotPipe.y);
            batch.draw(topPipe, topTubes[i].posTopPipe.x, topTubes[i].posTopPipe.y);
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < botTubes.length; i++) {
            botTubes[i].update();
            topTubes[i].update();
        }
    }

    public void restart() {
        int startPoint = 400;
        for (int i = 0; i < botTubes.length; i++) {
            botTubes[i] = new TubesBot(new Vector2(startPoint, 0));
            topTubes[i] = new TubesTop(new Vector2(startPoint, 0));
            startPoint += 520;
        }
    }

}