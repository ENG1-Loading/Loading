package com.loading.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends Entity {

    Texture playerTexture;
    Sprite playerSprite;

    Texture arrowTexture;
    Sprite arrowSprite;

    // True if currently active chef
    boolean active;

    /* maybe switch to using enums
    enum STATE {
        ACTIVE,
        WALKING,
        STATIC,
        CARRYING
    }
    */

    /*
    * Initialises player object with the given arguments
    *
    * @param width the width to spawn the player-sprite width
    * @param height the height to spawn the player-sprite with
    * @param body the body data to give the sprite
    * @param path the path to the texture of the sprite
    * @param posx the positional x to spawn the sprite at
    * @param posy the positional y to spawn the sprite at
    * */
    public Player(float width, float height, Body body, String path, float posx, float posy) {
        super(width, height, body, posx, posy);
        this.speed = 5f;
        this.playerTexture = new Texture(path);
        this.playerSprite = new Sprite(playerTexture);
        this.arrowTexture = new Texture("assets/arrow.png");
        this.arrowSprite = new Sprite(arrowTexture);
        this.playerSprite.setScale(2); // scaled up by 2
        this.body.setUserData(playerSprite);

    }

    @Override
    public void update() {
    }

    /*
    * Render the character with the initialised values
    *
    * @param batch the batch data to supply the renderer with
    * */
    @Override
    public void render(SpriteBatch batch) {
        playerSprite.setPosition(body.getPosition().x, body.getPosition().y);
        // this was used to get user position for boundaries
        //if (active) {
        //    System.out.println("X: "+ body.getPosition().x);
        //    System.out.println("Y: " + body.getPosition().y);
        //}

        playerSprite.draw(batch);


        if (active) {
            arrowSprite.setX(body.getPosition().x-5); // render the arrow after the player and position it above
            arrowSprite.setY(body.getPosition().y + (playerSprite.getHeight()) +10);
            arrowSprite.draw(batch);
        }

        doUserInput();

    }

    /*
    * Checks if the sprite is currently on any x or y coordinates that would collide with objects that it shouldn't
    *
    * @param x the current x-coordinate of the sprite
    * @param y the current y-coordinate of the sprite
    *
    * @return Boolean if the sprite is currently colliding or not
    * */
    private Boolean isColliding(float x,float y) {
        /* coords
        * counter
        * Right top:
        * X: 265.0
          Y: 523.0
          *
        * Right bottom:
        *X: 265.0
          Y: 433.0
          Left top:
          * X: 865.0
            Y: 528.0
          Left bottom:
          * X: 865.0
            Y: 433.0
          Left side:
          * X: 65.0
            Y: 323.0
          Right side:
          * X: 1195.0
            Y: 323.0
          Bottom:
          * X: 1195.0
            Y: 303.0
          Top:
          * X: 1145.0
            Y: 623.0
        * */
        return !(y > 623) && !(y < 303) && !(x > 1195) && !(x < 65) && (!(y < 528) || !(y > 433) || !(x > 65) || !(x > 255.0) || !(x < 870));
    }

    /*
    * Defines what to do when a specific key is pressed, used for movement
    * */
    private void doUserInput() {
        //if (Gdx.input.isKeyPressed(Input.Keys.A)) {
        //    x -= speed;
        //}
        //if (Gdx.input.isKeyPressed(Input.Keys.D)) {
        //    x += speed;
        //}
        //if (Gdx.input.isKeyPressed(Input.Keys.W)) {
        //    y += speed;
        //}
        //if (Gdx.input.isKeyPressed(Input.Keys.S)) {
        //    y -= speed;
        //}
        if (active) {
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                if (isColliding(body.getPosition().x - speed,body.getPosition().y )) {
                    body.setTransform(body.getPosition().x - speed, body.getPosition().y, body.getAngle());
                }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                if (isColliding(body.getPosition().x + speed, body.getPosition().y)) {
                    body.setTransform(body.getPosition().x + speed, body.getPosition().y, body.getAngle());
                }

            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (isColliding(body.getPosition().x, body.getPosition().y + speed)) {
                    body.setTransform(body.getPosition().x, body.getPosition().y + speed, body.getAngle());
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                if (isColliding(body.getPosition().x, body.getPosition().y - speed)) {
                    body.setTransform(body.getPosition().x, body.getPosition().y - speed, body.getAngle());
                }
            }
        }
        //System.out.println("Vx : " + velX * speed + " Vy : " + velY * speed);
        //body.setLinearVelocity(velX * speed, velY * speed);
    }

    /*
    * Change with sprite is the currently active one (which one the user is controlling)
    *
    * @param state this will allow us to set a character to a false state (not currently being used) or true state (allowed to be used)
    * */
    public void setActivePlayer(boolean state) {
        active = state;
    }

    /*
    * Show us which player is the currently active one
     */
    public boolean getActivePlayer() {
        return active;
    }
    
}
