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
        x = body.getPosition().x * 32f;
        y = body.getPosition().y * 32f;



    }

    @Override
    public void render(SpriteBatch batch) {
        playerSprite.setX(x);
        playerSprite.setY(y); 
        playerSprite.draw(batch);

        if (active) {
            arrowSprite.setX(x-5); // render the arrow after the player and position it above
            arrowSprite.setY(y + (playerSprite.getHeight()) +10);
            arrowSprite.draw(batch);
        }
        doUserInput();

    }

    private void doUserInput() {
        velX = 0;
        velY = 0;
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
                x -= speed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                x += speed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                y += speed;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                y -= speed;
            }
        }
        //System.out.println("Vx : " + velX * speed + " Vy : " + velY * speed);
        //body.setLinearVelocity(velX * speed, velY * speed);
    }

    public void setActivePlayer(boolean state) {
        active = state;
    }

    public boolean getActivePlayer() {
        return active;
    }
    
}
