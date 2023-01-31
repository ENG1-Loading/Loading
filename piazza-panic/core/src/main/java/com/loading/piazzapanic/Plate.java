package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Plate {
    final Launcher _parent;
    Texture plateTexture;
    private SpriteBatch batch;
    private Sprite plateSprite;
    private float x;
    private float y;
    public Plate(Launcher parent) {
        this._parent = parent;
        this.batch = _parent.batch;
        plateTexture = new Texture("assets/plate.png");
        this.plateSprite = new Sprite(plateTexture);
        this.x = 830;
        this.y = 480;
    }

    public void render() {
        plateSprite.setPosition(x,y);
        batch.begin();
        plateSprite.draw(batch);
        batch.end();
    }

    public void changePosition(float _x, float _y) {
        x = _x;
        y = _y;
    }

}
