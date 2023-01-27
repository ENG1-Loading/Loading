package com.loading.piazzapanic;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class HeartDisplay {
    final Launcher _parent;
    private Texture heartTexture;
    private int numHearts;
    private int maxHearts;
    private SpriteBatch batch;

    public HeartDisplay(Launcher parent, int maxHearts, Texture heartTexture) {
        this._parent = parent;
        this.maxHearts = maxHearts;
        this.numHearts = maxHearts;
        this.heartTexture = heartTexture;
        this.batch = _parent.batch;
    }

    public int getNumHearts() {
        return numHearts;
    }

    public void render() {
        batch.begin();
        for (int i = 0; i < numHearts; i++) {
            batch.draw(heartTexture, i *( heartTexture.getWidth()), 0);
        }
        batch.end();
    }

    public void reduceHearts(int amount) {
        numHearts = Math.max(numHearts - amount, 0);
    }

    public void dispose() {
        batch.dispose();
    }
}
