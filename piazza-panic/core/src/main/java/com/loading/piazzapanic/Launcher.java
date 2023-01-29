package com.loading.piazzapanic;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Launcher extends Game {

	public SpriteBatch batch;
	public BitmapFont font;

	/*
	* When the launcher is run set the screen to menu screen
	*/
	@Override
	public void create() {
		// create stuff
		font = new BitmapFont();
		batch = new SpriteBatch();

		// Shows Team Loading logo, waits (basically standard publisher logo cliche)
		setScreen(new MenuScreen(this));

	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
