package com.loading.piazzapanic;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class HeartDisplay {
    final Launcher _parent;
    private Texture heartTexture;
    private int numHearts;
    private int maxHearts;
    private SpriteBatch batch;

    /*
    * Initialise a heart display instance with the initial values
    *
    * @param parent sets the parent of this class to the initialised variable
    * @param maxHearts takes the amount of hearts to render initially
    * @param heartTexture the image to use for the hearts
    */
    public HeartDisplay(Launcher parent, int maxHearts, Texture heartTexture) {
        this._parent = parent;
        this.maxHearts = maxHearts;
        this.numHearts = maxHearts;
        this.heartTexture = heartTexture;
        this.batch = _parent.batch;
    }

    /*
    * Get the current number of hearts
    */
    public int getNumHearts() {
        return numHearts;
    }

    /*
    * Render the hearts on the screen
    */
    public void render() {
        batch.begin();
        for (int i = 0; i < numHearts; i++) {
            batch.draw(heartTexture, i *( heartTexture.getWidth()), 0);
        }
        batch.end();
    }
    /*
    * Reduce the number of hearts on the screen
    */
    public void reduceHearts(int amount) {
        numHearts = Math.max(numHearts - amount, 0);
    }

    public void dispose() {
        batch.dispose();
    }
}
