package com.loading.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final Launcher _parent;

    // Texture <varName> for a new texture
    // Sound <varName> for sound
    // Music <varName> for music
    Music themeMusic;
    OrthographicCamera camera;

    Texture logo;


    public GameScreen(final Launcher parent) {
        this._parent = parent;

        logo = new Texture(Gdx.files.internal("Logo500x500.png"));

        // Image loading

        // Sound and music loading

        // camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();

        _parent.batch.setProjectionMatrix(camera.combined);

        _parent.batch.begin();

        _parent.batch.draw(logo, 0, 0);

        _parent.batch.end();

        // User input
        //      TODO: Write input handler


    }

    @Override
    public void show() {
        // Starts the music when game starts
        // themeMusic.play();
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        logo.dispose();

    }
}
