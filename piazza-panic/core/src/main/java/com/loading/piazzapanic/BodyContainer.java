package com.loading.piazzapanic;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class BodyContainer {
 
    private static short PHYSICS_ENTITY = 0x01;
    private static short WORLD_ENTITY = 0x02;

    public static Body createBody(float x, float y, float width, float height, boolean isStatic, World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x , y );
        bodyDef.fixedRotation = true;
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(x / 2 / 32f, y / 2 / 32f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.filter.categoryBits = isStatic ? WORLD_ENTITY : PHYSICS_ENTITY;
        fixtureDef.filter.maskBits = isStatic ? PHYSICS_ENTITY : WORLD_ENTITY;
        body.createFixture(fixtureDef);
        shape.dispose();
        
        return body;
    }
}
