package com.loading.piazzapanic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class TileMapParser {

    private TiledMap _tiledMap;
    private GameScreen _gameScreen;

    Texture chef1;
    Sprite chef1Sprite;


    public TileMapParser(GameScreen gameScreen) {
        this._gameScreen = gameScreen;
        this.chef1 = new Texture("assets/chef1.png");
        this.chef1Sprite = new Sprite(chef1);
    }

    public OrthogonalTiledMapRenderer setupMap() {
        _tiledMap = new TmxMapLoader().load("assets/main.tmx");
        parseObjects(_tiledMap.getLayers().get("colliders").getObjects());

        return new OrthogonalTiledMapRenderer(_tiledMap, 1 / 32f);
    }

    public void parseObjects(MapObjects mapObjects) {
        for (MapObject obj : mapObjects) {
            // Chef Player Characters
            if (obj instanceof RectangleMapObject) {
                Rectangle rectangle = ((RectangleMapObject)obj).getRectangle();
                String recName = obj.getName();

                if (recName.contains("chef")) {
                    switch (recName) {
                        case "chef1":
                            Body chef1 = BodyContainer.createBody(
                                rectangle.getX() + rectangle.getWidth() / 2, 
                                rectangle.getY() + rectangle.getHeight() / 2, 
                                rectangle.getWidth(), 
                                rectangle.getHeight(), 
                                false, _gameScreen.getWorld()
                            );
                            _gameScreen.addPlayer(new Player(rectangle.getWidth(), rectangle.getHeight(), chef1, "assets/chef1.png"));
                            _gameScreen.setActivePlayer(0);
                        case "chef2":
                            Body chef2 = BodyContainer.createBody(
                                rectangle.getX() + rectangle.getWidth() / 2, 
                                rectangle.getY() + rectangle.getHeight() / 2, 
                                rectangle.getWidth(), 
                                rectangle.getHeight(), 
                                true, _gameScreen.getWorld()
                            );
                            _gameScreen.addPlayer(new Player(rectangle.getWidth(), rectangle.getHeight(), chef2, "assets/chef1.png"));
                        case "chef3":
                            Body chef3 = BodyContainer.createBody(
                                rectangle.getX() + rectangle.getWidth() / 2, 
                                rectangle.getY() + rectangle.getHeight() / 2, 
                                rectangle.getWidth(), 
                                rectangle.getHeight(), 
                                true, _gameScreen.getWorld()
                            );
                            _gameScreen.addPlayer(new Player(rectangle.getWidth(), rectangle.getHeight(), chef3, "assets/chef1.png"));
                        default:
                            break;
                    }
                }
                
            }
            // static counter tops / interactable tops
            if (obj instanceof PolygonMapObject) {
                createStaticObject((PolygonMapObject)obj);
            }
        }
    }

    public void createStaticObject(PolygonMapObject polygonMapObject) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = _gameScreen.getWorld().createBody(bodyDef);
        Shape shape = createPolygonShape(polygonMapObject);
        body.createFixture(shape, 1000);
        shape.dispose();    
    }

    // helper to get the shape of the polygon object for the body
    private Shape createPolygonShape(PolygonMapObject polygonMapObject) {
        float[] vertices = polygonMapObject.getPolygon().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i=0; i < vertices.length / 2; i++) {
            Vector2 current = new Vector2(vertices[i*2] / 32f, vertices[i * 2 + 1] / 32f);
            worldVertices[i] = current;
        }

        PolygonShape shape = new PolygonShape();
        shape.set(worldVertices);
        return shape;
    }
    
}