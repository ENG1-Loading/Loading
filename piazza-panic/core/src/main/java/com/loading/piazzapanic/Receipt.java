package com.loading.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.swing.*;

public class Receipt {
    final Launcher _parent;
    Texture RecieptTexture;
    private SpriteBatch batch;
    private Sprite RecieptSprite;
    private float originalScale;
    private boolean hovered = false;

    /*
    * Create a receipt sprite with the initialiser values
    *
    * @param parent the parent instance of the receipt
    * @param receiptTexture the image path of the receipt
    */
    public Receipt(Launcher parent, Texture recieptTexture) {
        this._parent = parent;
        this.batch = _parent.batch;
        this.RecieptTexture = recieptTexture;
        this.RecieptSprite = new Sprite(RecieptTexture);
        this.originalScale = RecieptSprite.getScaleX();

    }
    /*
     * Render the character with the initialised values
     *
     *
     * */
    public void render() {
        RecieptSprite.setPosition(640, 700);
        hovered = Gdx.input.getX() > RecieptSprite.getX() && Gdx.input.getX() < RecieptSprite.getX() + RecieptSprite.getWidth()
                && Gdx.input.getY() > 0 && Gdx.input.getY() < 100;
        batch.begin();
        if (hovered) {
            RecieptSprite.setPosition(RecieptSprite.getX(), RecieptSprite.getY() - 25);
            RecieptSprite.setScale(originalScale * 1.5f);
        } else {
            RecieptSprite.setPosition(640, 700);
            RecieptSprite.setScale(originalScale);
        }
        RecieptSprite.draw(batch);
        batch.end();
    }
}
