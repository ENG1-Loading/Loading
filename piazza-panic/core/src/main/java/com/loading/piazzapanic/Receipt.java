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
    final ArrayList<String> CHICKEN_BURGER = new ArrayList<String>() {
        {
            add("Chicken");
            add("Bun");
            add("Lettuce");
            add("Tomato");
            add("Pickles");
            add("Mayo");
        }
    };
    final ArrayList<String> BEEF_BURGER = new ArrayList<String>() {
        {
            add("Beef");
            add("Bun");
            add("Lettuce");
            add("Tomato");
            add("Pickles");
            add("Ketchup");
        }
    };
    final ArrayList<String> CHICKEN_SALAD = new ArrayList<String>() {
        {
            add("Chicken");
            add("Lettuce");
            add("Tomato");
            add("Mayo");
        }
    };
    final ArrayList<String> PLAIN_SALAD = new ArrayList<String>() {
        {
            add("Lettuce");
            add("Tomato");
            add("Mayo");
        }
    };
    final ArrayList<ArrayList<String>> recipes = new ArrayList<ArrayList<String>>() {{
        add(CHICKEN_BURGER);
        add(BEEF_BURGER);
        add(CHICKEN_SALAD);
        add(PLAIN_SALAD);
    }};
    ArrayList<String> expectedToppings = new ArrayList<String>();
    String recieptContent = "";


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
        int recipeIndex = (int) (Math.random() * recipes.size());
        ArrayList<String> chosenRecipe = recipes.get(recipeIndex);
        StringBuilder builder = new StringBuilder(recieptContent);

        for (String ingredient: chosenRecipe) {
            builder.append(ingredient).append("\n");
            expectedToppings.add(ingredient);
        }
        recieptContent = builder.toString();
        //ArrayList<String> ingredientChoices = new ArrayList<String>() {{
        //    add("Tomato");
        //    add("Lettuce");
        //    add("Pickles");
        //}};
        //int burgerIndex = (int) (Math.random() * burgerTypes.size());
        //String burgerType = this.burgerTypes.get(burgerIndex);
        //expectedToppings.add(burgerType);
        //this.recieptContent = "Reciept\nBurger type\n" + burgerType + "\nToppings\n";
        //StringBuilder builder = new StringBuilder(this.recieptContent);
        //for (int i = 0; i<3; i++) {
//
//
        //    int index = (int) (Math.random() * ingredientChoices.size());
//
        //    //this.recieptContent += ingredientChoices.get(index) + "\n";
        //    builder.append(ingredientChoices.get(index)).append("\n");
        //    expectedToppings.add(ingredientChoices.get(index));
        //    ingredientChoices.remove(index);
        //}
        //recieptContent = builder.toString();

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
            font.draw(batch, recieptContent, RecieptSprite.getX()-15, RecieptSprite.getY() + RecieptSprite.getHeight() + 25);

        } else {
            font.draw(batch, recieptContent, RecieptSprite.getX(), RecieptSprite.getY() + RecieptSprite.getHeight());

        }
        batch.end();
    }

    public ArrayList<String> getExpectedToppings() {
        return expectedToppings;
    }
}
