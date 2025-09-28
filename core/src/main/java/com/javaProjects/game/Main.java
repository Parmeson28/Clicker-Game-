package com.javaProjects.game;

import java.util.Vector;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    SpriteBatch batch;
    Texture blahajTexture;

    SpriteBatch spriteBatch;
    FitViewport viewport;

    Sprite blahajSprite;

    Vector2 touchPos;

    int blahajCounter = 0;


    @Override
    public void create() {    // create is executed immediatly when the game is run

        blahajTexture = new Texture("blahaj2.png");

       // Gdx.graphics.setWindowedMode(1280, 720); da pra mudar no Clickergames/lwjgl3/src/main/java/com/javaProjects/game/lwjgl3/Lwjgl3Launcher.java

        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(1280, 720);
        blahajSprite = new Sprite(blahajTexture);
        blahajSprite.setSize(510, 300);


        touchPos = new Vector2();
    }

    @Override
    public void resize(int width, int height){

        viewport.update(width, height, true);

    }


    @Override
    public void render() {

        input();
        logic();
        draw();

    }

    private void input(){

        if (Gdx.input.justTouched()){
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            viewport.unproject(touchPos);

            Rectangle blahajCollision = new Rectangle(blahajSprite.getX(), blahajSprite.getY(), 510f, 300f);
            if(blahajCollision.contains(touchPos.x, touchPos.y)){

                blahajCounter += 1;
                System.out.println(blahajCounter);
            }

        }
        
    }

    private void logic(){

    }

    private void draw(){
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        spriteBatch.begin();
       
        blahajSprite.draw(spriteBatch);

        
        spriteBatch.end();
      
    }

    @Override
    public void dispose() {
        batch.dispose();
        blahajTexture.dispose();
    }
}
