package com.loading.piazzapanic;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameOverScreenFail implements Screen {
    final Launcher _parent;
    Stage stage;
    Label gameOverLabel;

    Label infoLabel;
    TextButton menuButton;

    private  Sprite backgroundSprite;


    /*
     * Initialises a class of our game over success screen with the parent instance and time taken to complete the level
     *
     * @param parent the instance of parent class that our class should use
     * @param timeTaken the amount of time (ms) that it took for the player to complete the level*/
    public GameOverScreenFail(Launcher parent, long timeTaken) {

        this._parent = parent;
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        Texture background = new Texture("assets/Gameover.png");
        backgroundSprite = new Sprite(background);
        Table table = new Table();
        this.stage = new Stage();
        gameOverLabel = new Label("Game Over, it took you: "+(int) (timeTaken/1000)+" seconds to run out of lives", new Label.LabelStyle(new BitmapFont(), Color.RED));
        infoLabel = new Label("To go back to menu press the button", new Label.LabelStyle(new BitmapFont(), Color.GOLD));
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
        table.add(gameOverLabel).center();
        table.row();
        table.add(infoLabel).center();
        table.row();
        table.add(menuButton).center();
        table.setPosition((screenWidth - table.getWidth()) / 2, (screenHeight - table.getHeight()) / 2);
        this.stage.addActor(table);

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        _parent.batch.begin();
        backgroundSprite.draw(_parent.batch);
        _parent.batch.end();
        stage.act();
        stage.draw();
        System.out.println(Gdx.graphics.getHeight());
        System.out.println(Gdx.graphics.getWidth());
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
        _parent.batch.dispose();
        _parent.font.dispose();
    }
}
