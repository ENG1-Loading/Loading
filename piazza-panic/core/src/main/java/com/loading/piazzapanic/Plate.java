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
    /**
     * Initialiser for our plate class
     * */
    public Plate(Launcher parent) {
        this._parent = parent;
        this.batch = _parent.batch;
        plateTexture = new Texture("assets/plate.png");
        this.plateSprite = new Sprite(plateTexture);
        this.x = 830;
        this.y = 480;
    }
    /**
     * Render a sprite at a specific position
     * */
    public void render() {
        plateSprite.setPosition(x,y);
        batch.begin();
        plateSprite.draw(batch);
        batch.end();
    }
    /**
     * Change the position of our plate and thus where it is rendered*/
    public void changePosition(float _x, float _y) {
        x = _x;
        y = _y;
    }
    /**
     * Get the current x-coordinate of the plate
     * */
    public float getX() {
        return x;
    }
    /**
     * Get the current y-coordinate of the plate*/
    public float getY() {
        return y;
    }

}
