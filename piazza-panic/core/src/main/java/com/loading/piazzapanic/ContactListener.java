package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.Manifold;

public class ContactListener implements com.badlogic.gdx.physics.box2d.ContactListener {

    @Override
    public void beginContact(Contact contact) {
        System.out.println(contact);
        Sprite a = (Sprite) contact.getFixtureA().getBody().getUserData();
        Sprite b = (Sprite) contact.getFixtureB().getBody().getUserData();

        System.out.println(a.getTexture());
        System.out.println(b.getTexture());
        System.out.println("A" +contact.getFixtureA().getBody().getUserData());
        System.out.println("B" + contact.getFixtureB().getBody().getUserData());
    }
    //Acom.badlogic.gdx.graphics.g2d.Sprite@74fe5c40
    //Bcom.badlogic.gdx.graphics.g2d.Sprite@3febb011
    @Override
    public void endContact(Contact contact) {
        System.out.println("Contact ended");

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
