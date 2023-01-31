package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CuttingBoard {
    final Launcher _parent;
    private Texture CuttingBoardTexture;
    private SpriteBatch batch;

    public CuttingBoard(Launcher parent, Texture cuttingBoardTexture) {
        this._parent = parent;
        this.CuttingBoardTexture = cuttingBoardTexture;
        this.batch = _parent.batch;
    }

    public void render() {
        batch.begin();
        batch.draw(CuttingBoardTexture, 350, 480);
        batch.end();
    }
}
