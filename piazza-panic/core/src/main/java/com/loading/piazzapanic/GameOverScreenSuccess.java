package com.loading.piazzapanic;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class GameOverScreenSuccess implements Screen {
    final Launcher _parent;
    Stage stage;
    Label gameOverLabel;

    Label infoLabel;
    TextButton menuButton;

    MenuScreen menu;



    public GameOverScreenSuccess(long timeTaken, Launcher parent) {

        this._parent = parent;
        menu = new MenuScreen(parent);
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        Table table = new Table();
        stage = new Stage();
        gameOverLabel = new Label("Game Over, it took you: "+timeTaken+" to complete the level", new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        infoLabel = new Label("To go back to menu press space :)", new Label.LabelStyle(new BitmapFont(), Color.GOLD));


        // Position the label at the center of the screen
        table.add(gameOverLabel).center();
        table.row();
        table.add(infoLabel).center();
        table.setPosition((screenWidth - table.getWidth()) / 2, (screenHeight - table.getHeight()) / 2);
        stage.addActor(table);

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.SPACE) {
                    _parent.setScreen(new MenuScreen(_parent));
                }
                if (keycode == Input.Keys.A) {
                    System.out.println("aaaa");
                }
                return true;
            }
        });
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {

    }
}
