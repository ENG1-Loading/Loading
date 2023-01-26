package com.loading.piazzapanic;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class HeartDisplay {
    private Texture heartTexture;
    private int numHearts;
    private int maxHearts;
    private SpriteBatch batch;

    public HeartDisplay(int maxHearts, Texture heartTexture) {
        this.maxHearts = maxHearts;
        this.numHearts = maxHearts;
        this.heartTexture = heartTexture;
        this.batch = new SpriteBatch();
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
}
