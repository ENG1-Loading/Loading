package com.loading.piazzapanic;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {

    final Launcher _parent;

    // Texture <varName> for a new texture
    // Sound <varName> for sound
    // Music <varName> for music
    Music themeMusic;
    OrthographicCamera camera;

    private OrthogonalTiledMapRenderer _mapRenderer;
    private TileMapParser _tileMapper;

    private HeartDisplay heartDisplay;
    private Box2DDebugRenderer box2dDebugRenderer;

    Texture background;
    Sprite backgroundSprite;

    Texture chef1;
    Sprite chef1Sprite;

    ArrayList<Player> players;
    int activePlayer;

    World world;

    Texture heartTexture;
    int maxHearts = 6;

    long timeStarted = 0;
    long elapsedTime;


    public GameScreen(final Launcher parent) {
        this._parent = parent;

        this.players = new ArrayList<Player>();

        this.box2dDebugRenderer = new Box2DDebugRenderer();

        this.background = new Texture("assets/main.png");
        this.backgroundSprite = new Sprite(this.background);

        this.chef1 = new Texture("assets/chef1.png");
        this.chef1Sprite = new Sprite(this.chef1);

        this.heartTexture = new Texture("assets/heart.png");
        this.heartDisplay = new HeartDisplay(_parent, this.maxHearts, this.heartTexture);
        // Image loading

        // Sound and music loading

        // camera
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 800);

        // world and map
        this.world = new World(new Vector2(0, 0), false);
        this._tileMapper = new TileMapParser(this);
        this._mapRenderer = _tileMapper.setupMap();

    }

    public World getWorld() {
        return this.world;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void setActivePlayer(int index) {
        activePlayer = index;
    }

    private void update() {
        // Vector3 position = camera.position;
        // position.x = Math.round(players.get(activePlayer).x * 32f * 10) / 10;
        // position.y = Math.round(players.get(activePlayer).y * 32f * 10) / 10;
        // camera.position.set(position);
        camera.update();

        _parent.batch.setProjectionMatrix(camera.combined);
        _mapRenderer.setView(camera);
    }

    // Allows for forward and backward cycling of players without causing index out
    // of bounds errors
    private void cyclePlayer(int direction) {
        Player current = players.get(activePlayer);
        current.setActivePlayer(false);

        int index = players.indexOf(current);
        int length = players.size();
        switch (direction) {
            case 1:
                index += 1;
                if (index == length) {
                    index = 0;
                }

            case -1:
                index -= 1;
                if (index < 0) {
                    index = length - 1;
                }
            default:
                break;
        }
        System.out.println("Setting active player to : " + index);
        activePlayer = index;
        players.get(activePlayer).setActivePlayer(true);
    }

    public void reduceHearts() {
        this.heartDisplay.reduceHearts(1);
    }


    public void create() {
        timeStarted = System.currentTimeMillis();
    }
    @Override
    public void render(float delta) {
        if (timeStarted == 0) {
            timeStarted = System.currentTimeMillis();
        }

        elapsedTime = (System.currentTimeMillis()- timeStarted) ;

        //System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        ScreenUtils.clear(0, 0, 0.2f, 1);

        this.update();

        _mapRenderer.render();

        _parent.batch.begin();

        backgroundSprite.draw(this._parent.batch);
        for (Player chef : players) {
            chef.render(this._parent.batch);
        }

        _parent.batch.end();

        box2dDebugRenderer.render(world, camera.combined.scl(32f));

        heartDisplay.render();
    }

    @Override
    public void show() {
        // Starts the music when game starts
        // themeMusic.play();
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.E) {
                    cyclePlayer(1);
                }
                if (keycode == Input.Keys.Q) {
                    cyclePlayer(-1);
                }
                if (keycode == Input.Keys.SPACE) {
                    // some interact method here
                }

                if (keycode == Input.Keys.L) {
                    int currentHearts = heartDisplay.getNumHearts();
                    if (currentHearts < 1) {
                        _parent.setScreen(new GameOverScreenFail(_parent, elapsedTime));
                    }
                    System.out.println(currentHearts);
                    reduceHearts();
                }

                if (keycode == Input.Keys.N) {
                    _parent.setScreen(new GameOverScreenSuccess(_parent, elapsedTime));
                }

                return true;
            }
        });
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
        _parent.batch.dispose();
        _parent.font.dispose();
    }
}
