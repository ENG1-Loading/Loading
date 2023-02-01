package com.loading.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends Entity {

    Texture playerTexture;
    Sprite playerSprite;

    Texture arrowTexture;
    Sprite arrowSprite;
    Texture spriteSheet;
    private TextureRegion[][] spriteSheetFrames;
    private float speed = 1;
    private int frame = 0;
    private int frameCount = 4;
    private float frameDuration = 0.1f;
    private float elapsedTime = 0;

    // True if currently active chef
    boolean active;
    boolean moving = false;

    /**
     * Initialises player object with the given arguments
     *
     * @param width  the width to spawn the player-sprite width
     * @param height the height to spawn the player-sprite with
     * @param body   the body data to give the sprite
     * @param path   the path to the texture of the sprite
     * @param posx   the positional x to spawn the sprite at
     * @param posy   the positional y to spawn the sprite at
     */
    public Player(float width, float height, Body body, String path, float posx, float posy) {
        super(width, height, body, posx, posy);
        this.speed = 5f;

        this.playerTexture = new Texture(path);
        this.spriteSheet = new Texture("assets/spritesheet.png");
        this.spriteSheetFrames = TextureRegion.split(spriteSheet, 25, 34);
        this.playerSprite = new Sprite(playerTexture);
        this.arrowTexture = new Texture("assets/arrow.png");
        this.arrowSprite = new Sprite(arrowTexture);
        this.playerSprite.setScale(2); // scaled up by 2
        this.body.setUserData(playerSprite);

        // TextureRegion[][] sheet = TextureRegion.split(tmp)

    }

    @Override
    public void render(SpriteBatch batch) {
    }

    @Override
    public void update() {
    }

    /**
     * Render the character with the initialised values
     *
     * @param batch the batch data to supply the renderer with
     */
    public void update(float delta) {
        elapsedTime += delta;
        if (elapsedTime > frameDuration) {
            elapsedTime = 0;
            frame = (frame + 1) % frameCount;
        }
    }

    /**
     * Render the character with the initialised values
     *
     * @param batch the batch data to supply the renderer with
     */
    public void render(SpriteBatch batch, float delta) {
        playerSprite.setPosition(body.getPosition().x, body.getPosition().y);

        playerSprite.draw(batch);
        /*
         * if (moving) {
         * update(delta);
         * 
         * batch.draw(spriteSheetFrames[0][frame], x, y, 50, 40);
         * } else {
         * batch.draw(spriteSheetFrames[0][1], x, y, 50, 40);
         * }
         * 
         */

        if (active) {
            arrowSprite.setX(body.getPosition().x + 10); // render the arrow after the player and position it above
            arrowSprite.setY(body.getPosition().y + (playerSprite.getHeight()) + 10);
            arrowSprite.draw(batch);
        }

        doUserInput();

    }

    /**
     * Checks if the sprite is currently on any x or y coordinates that would
     * collide with objects that it shouldn't
     *
     * @param x the current x-coordinate of the sprite
     * @param y the current y-coordinate of the sprite
     *
     * @return Boolean if the sprite is currently colliding or not
     */
    private Boolean isColliding(float x, float y) {
        return !(y > 623) && !(y < 303) && !(x > 1195) && !(x < 65)
                && (!(y < 528) || !(y > 433) || !(x > 65) || !(x > 255.0) || !(x < 870));
    }

    /*
     * Defines what to do when a specific key is pressed, used for movement
     */
    private void doUserInput() {
        Boolean keyBeingPressed = false;

        if (active) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                if (isColliding(body.getPosition().x - speed, body.getPosition().y)) {
                    body.setTransform(body.getPosition().x - speed, body.getPosition().y, body.getAngle());
                    x -= speed;
                    keyBeingPressed = true;
                }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                if (isColliding(body.getPosition().x + speed, body.getPosition().y)) {
                    body.setTransform(body.getPosition().x + speed, body.getPosition().y, body.getAngle());
                    x += speed;
                    keyBeingPressed = true;
                }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (isColliding(body.getPosition().x, body.getPosition().y + speed)) {
                    body.setTransform(body.getPosition().x, body.getPosition().y + speed, body.getAngle());
                    y += speed;
                    keyBeingPressed = true;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                if (isColliding(body.getPosition().x, body.getPosition().y - speed)) {
                    body.setTransform(body.getPosition().x, body.getPosition().y - speed, body.getAngle());
                    y -= speed;
                    keyBeingPressed = true;
                }
            }
            if (keyBeingPressed) {
                moving = true;
            } else {
                moving = false;
            }
        }

    }

    /**
     * Change with sprite is the currently active one (which one the user is
     * controlling)
     *
     * @param state this will allow us to set a character to a false state (not
     *              currently being used) or true state (allowed to be used)
     */
    public void setActivePlayer(boolean state) {
        active = state;
    }

}
