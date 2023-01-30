package com.loading.piazzapanic;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameOverScreenSuccess implements Screen {
    final Launcher _parent;
    Stage stage;
    Label gameOverLabel;

    Label infoLabel;
    TextButton menuButton;

    /*
    * Initialises a class of our game over success screen with the parent instance and time taken to complete the level
    *
    * @param parent the instance of parent class that our class should use
    * @param timeTaken the amount of time (ms) that it took for the player to complete the level*/
    public GameOverScreenSuccess(Launcher parent, long timeTaken) {

        this._parent = parent;
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        Table table = new Table();
        this.stage = new Stage();
        gameOverLabel = new Label("Game Over, it took you: "+timeTaken+" to complete the level", new Label.LabelStyle(new BitmapFont(), Color.GREEN));
        infoLabel = new Label("To go back to menu press space :)", new Label.LabelStyle(new BitmapFont(), Color.GOLD));
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(new TextureRegion(new Texture("button.png")));
        style.down = new TextureRegionDrawable(new TextureRegion(new Texture("button_down.png")));
        style.font = new BitmapFont();
        style.fontColor = Color.WHITE;
        menuButton = new TextButton("Menu", style);
        menuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                _parent.setScreen(new MenuScreen(_parent));
            }
        });

        // Position the label at the center of the screen
        table.add(gameOverLabel).center();
        table.row();
        table.add(infoLabel).center();
        table.row();
        table.add(menuButton).center();
        table.setPosition((screenWidth - table.getWidth()) / 2, (screenHeight - table.getHeight()) / 2);
        this.stage.addActor(table);

    }
    /*
    * When the screen is showed we need to set our input processor to the stage in order to register clicks*/
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage); // bind the input processor to our stage

    }
    /*
    * Render the objects drawn onto the screen*/
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
    /*
    * When screen is closed then clear our input processer*/
    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }
    /*
    * Dispose and clear our currently rendered things
    * */
    @Override
    public void dispose() {
        _parent.batch.dispose();
        _parent.font.dispose();
    }
}
