package com.loading.piazzapanic;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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

    private Box2DDebugRenderer box2dDebugRenderer;

    ArrayList<Player> players;
    int activePlayer;

    World world;


    public GameScreen(final Launcher parent) {
        this._parent = parent;

        this.players = new ArrayList<Player>();

        // Image loading

        // Sound and music loading

        // camera
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false,40,25);

        // world and map
        this.world = new World(new Vector2(0,0), false);
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
        Vector3 position = camera.position;
        position.x = Math.round(players.get(activePlayer).x * 32f * 10) / 10;
        position.y = Math.round(players.get(activePlayer).y * 32f * 10) / 10;
        camera.position.set(position);
        camera.update();

        _parent.batch.setProjectionMatrix(camera.combined);
        _mapRenderer.setView(camera);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        this.update();

        _mapRenderer.render();

        _parent.batch.begin();

        _parent.batch.end();

        box2dDebugRenderer.render(world, camera.combined.scl(32f));
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
        // TODO
    }
}
