package com.loading.piazzapanic;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class BodyContainer {
 
    /** Constructor for creating a Box2D body
     * It can create both static and dynamic bodies
     * 
     * @param x current x coordinate
     * @param y current y coordinate
     * @param width width of the body
     * @param height height of the body
     * @param isStatic static or dynamic body, true if static
     * @param world the World that will contain the body
     * @return returns a Box2D body object
     */

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
        body.createFixture(fixtureDef);
        shape.dispose();
        
        return body;
    }
}
