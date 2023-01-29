package com.loading.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen{

    final Launcher _parent;
    OrthographicCamera camera;

    Texture background;
    Sprite backgroundSprite;

    /*
    * Create a menu screen with the initialiser screen
    *
    * @param parent sets the parent instance of this class */
    public MenuScreen(final Launcher parent) {
        this._parent = parent;

        this.background = new Texture("assets/menuScreen.png");
        this.backgroundSprite = new Sprite(this.background);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 800);
    }

    /*
    * Defines what to do when the screen is called*/
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Keys.SPACE) {
                    _parent.setScreen(new GameScreen(_parent));
                }
                return true;
            }
        });
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        _parent.batch.setProjectionMatrix(camera.combined);

        _parent.batch.begin();
        backgroundSprite.draw(_parent.batch);
        _parent.batch.end();

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
        // TODO Auto-generated method stub

    }

}
