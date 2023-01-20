package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float posX = 100;
	float posY = 200;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		if (Gdx.input.isTouched()) {
			posX = Gdx.input.getX();
			posY = Gdx.graphics.getHeight() - Gdx.input.getY();
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			posY += 1;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			posY -= 1;
		}
		 if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			posX -= 1;
		}
		 if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			posX += 1;
		}
		batch.begin();
		batch.draw(img, posX, posY);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
