package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class TextPopup {
    private final float duration;
    private float elapsedTime = 0;
    private BitmapFont font;
    private String text;
    private Vector2 position;

    public TextPopup(String text, Vector2 position, float duration) {
        this.text = text;
        this.position = position;
        this.duration = duration;
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    public void update(float delta) {
        elapsedTime += delta;
    }

    public boolean isVisible() {
        return elapsedTime < duration;
    }

    public void render(SpriteBatch batch) {
        if (isVisible()) {
            System.out.println("Visible" + position.x);
            font.draw(batch, text, position.x, position.y);
        }
    }

    public void setText(String newText) {
        text = newText;
    }

    public void setPos(float x, float y) {
        position.x = x;
        position.y = y;
    }

    public void resetCounter() {
        elapsedTime = 0;
    }
}

