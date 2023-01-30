package com.loading.piazzapanic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Receipt {
    final Launcher _parent;
    Texture RecieptTexture;
    BitmapFont font;
    private SpriteBatch batch;
    private Sprite RecieptSprite;
    private float originalScale;
    private boolean hovered = false;

    String recieptContent;

    private ArrayList<String> burgerTypes = new ArrayList<String>() {{
        add("Chicken");
        add("Beef");
    }};

    /*
    * Create a receipt sprite with the initialiser values
    *
    * @param parent the parent instance of the receipt
    * @param receiptTexture the image path of the receipt
    */
    public Receipt(Launcher parent, Texture recieptTexture) {
        this._parent = parent;
        this.font = _parent.font;
        this.batch = _parent.batch;
        this.RecieptTexture = recieptTexture;
        this.RecieptSprite = new Sprite(RecieptTexture);
        this.originalScale = RecieptSprite.getScaleX();
        ArrayList<String> ingredientChoices = new ArrayList<String>() {{
            add("Tomato");
            add("Onion");
            add("Lettuce");
            add("Pickles");
            add("Ketchup");
            add("Mayo");
        }};
        int burgerIndex = (int) (Math.random() * ingredientChoices.size());
        String burgerType = this.burgerTypes.get(0);
        this.recieptContent = "Reciept\nBurger type\n" + burgerType + "\nToppings\n";
        StringBuilder builder = new StringBuilder(this.recieptContent);
        for (int i = 0; i<3; i++) {


            int index = (int) (Math.random() * ingredientChoices.size());

            //this.recieptContent += ingredientChoices.get(index) + "\n";
            builder.append(ingredientChoices.get(index)).append("\n");
            ingredientChoices.remove(index);
        }
        recieptContent = builder.toString();

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
            RecieptSprite.setScale(originalScale * 1.7f);
            font.getData().setScale(1.1f);
        } else {
            RecieptSprite.setPosition(640, 700);
            RecieptSprite.setScale(originalScale);
            font.getData().setScale(0.7f);

        }
        RecieptSprite.draw(batch);

        font.setColor(Color.BLACK);

        if (hovered) {
            font.draw(batch, recieptContent, RecieptSprite.getX()-10, RecieptSprite.getY() + RecieptSprite.getHeight() + 25);

        } else {
            font.draw(batch, recieptContent, RecieptSprite.getX(), RecieptSprite.getY() + RecieptSprite.getHeight());

        }
        batch.end();
    }
}
