package com.loading.piazzapanic;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class ListenerHelper implements ContactListener {
    
    @Override
    public void beginContact(Contact contact) {
        System.out.println("CONTACT!");

        Fixture fix1 = contact.getFixtureA();
        Fixture fix2 = contact.getFixtureB();

        if ((fix1.getBody().getType() == BodyType.DynamicBody) && (fix2.getBody().getType() == BodyType.StaticBody)) {
            fix1.getBody().applyForceToCenter(50,50, true);
        }
        if ((fix2.getBody().getType() == BodyType.DynamicBody) && (fix1.getBody().getType() == BodyType.StaticBody)) {
            fix2.getBody().applyForceToCenter(50,50, true);
        }
    }

    @Override
    public void endContact(Contact contact) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        // TODO Auto-generated method stub
        
    }
    
}
