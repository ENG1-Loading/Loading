package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bin {
    final Launcher _parent;
    private Texture BinTexture;
    private SpriteBatch batch;

    /**
     * Create our instance of bin*/
    public Bin(Launcher parent, Texture binTexture) {
        this._parent = parent;
        this.BinTexture = binTexture;
        this.batch = _parent.batch;

    }
    /**
     * Render our bin
     * */
    public void render() {
        batch.begin();
        batch.draw(BinTexture, 185,270, 64, 64);
        batch.end();
    }
}
