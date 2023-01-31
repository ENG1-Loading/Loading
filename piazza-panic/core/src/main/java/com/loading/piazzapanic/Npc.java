package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Npc {
    final Launcher _parent;

    private Texture NpcTexture;

    private SpriteBatch batch;
    private float x=1300, y=100;
    public Npc(Launcher parent, Texture npcTexture) {
        this._parent = parent;
        this.NpcTexture = npcTexture;
        this.batch = _parent.batch;
    }
    /*
     * Renders the sprites we have supplied
     * */
    public void render() {

        batch.begin();
        batch.draw(NpcTexture, x, y, 64, 64);

        batch.end();

    }
    /*
     * Moves a sprites position to a given x and y
     *
     * @param x the x-coordinate to move the sprite to
     * @param y the y-coordinate to move the sprite to
     */
    public void move(float x, float y) {

        this.x = x;
        this.y = y;
    }
    /*
    * Getter for the sprites current x-coordinate
    * */
    public float getX() {
        return x;
    }

    /*
    * To dispose of the current sprite (free up system resources)
     */
    public void dispose() {
        batch.dispose();
    }
}
