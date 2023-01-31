package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Npc {
    final Launcher _parent;

    private Texture NpcTexture;

    private SpriteBatch batch;
    private TextureRegion[][] spriteSheetFrames;
    private float speed = 100;
    private int frame = 0;
    private int frameCount = 4;
    private float frameDuration = 0.1f;
    private float elapsedTime = 0;
    Boolean moving = true;
    Texture stationary;
    private float x=1300, y=100;
    public Npc(Launcher parent, Texture npcTexture) {
        this._parent = parent;
        this.NpcTexture = npcTexture;
        this.batch = _parent.batch;
        System.out.println(npcTexture.getWidth());
        this.spriteSheetFrames = TextureRegion.split(npcTexture, 15,17);


    }
    public void update(float delta) {
        elapsedTime += delta;
        if (elapsedTime > frameDuration) {
            elapsedTime = 0;
            frame = (frame + 1) % frameCount;
        }

    }
    /*
     * Renders the sprites we have supplied
     * */
    public void render(float delta) {

        batch.begin();
        if (moving) {
            update(delta);

            batch.draw(spriteSheetFrames[0][frame], x, y, 30, 60);
        } else {
            batch.draw(spriteSheetFrames[0][1], 1000, 225, 30, 60);
        }

        batch.end();

    }

    public void toggleMoving(Boolean ismoving) {
        moving = ismoving;
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
