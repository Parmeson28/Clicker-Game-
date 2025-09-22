package com.javaProjects.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture image;

    private Object BlahajObj;


    @Override
    public void create() {

        batch = new SpriteBatch();
        image = new Texture("Blahaj.png");
        
        Button button = new Button();

        Gdx.graphics.setWindowedMode(1280, 720);

    }

    @Override
    public void render() {

        input();
        logic();
        draw();

    }

    private void input(){
        
    }

    private void logic(){

    }

    private void draw(){
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.begin();

        batch.draw(image, 40, 20);
        
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
