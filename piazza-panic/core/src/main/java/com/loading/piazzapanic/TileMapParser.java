package com.loading.piazzapanic;

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

    /**
     * Constructor that creates a parser for .tmx files
     * 
     * @param gameScreen the screen that objects are loaded onto
     */
    public TileMapParser(GameScreen gameScreen) {
        this._gameScreen = gameScreen;
    }

    // Loads the map file and then parses objects on the "colliders" layer before
    // returning a MapRenderer
    public OrthogonalTiledMapRenderer setupMap() {
        _tiledMap = new TmxMapLoader().load("assets/main.tmx");
        parseObjects(_tiledMap.getLayers().get("colliders").getObjects());

        return new OrthogonalTiledMapRenderer(_tiledMap, 1 / 32f);
    }

    /**
     * Parses each type of object within a .tmx layer.
     * Rectangles are players
     * Polygons are static objects, and are usually interactable but also barriers
     * 
     * @param mapObjects the collection of objects on the layer
     */
    public void parseObjects(MapObjects mapObjects) {
        for (MapObject obj : mapObjects) {
            // Chef Player Characters
            if (obj instanceof RectangleMapObject) {
                Rectangle rectangle = ((RectangleMapObject) obj).getRectangle();
                String recName = obj.getName();
                if (_gameScreen.players.size() >= 2) {
                } else {

                    if (recName.contains("chef")) {
                        switch (recName) {
                            case "chef1":
                                if (_gameScreen.players.size() == 1) {

                                    Body chef1 = BodyContainer.createBody(
                                            rectangle.getX() + rectangle.getWidth() / 2,
                                            rectangle.getY() + rectangle.getHeight() / 2,
                                            rectangle.getWidth(),
                                            rectangle.getHeight(),
                                            false, _gameScreen.getWorld());
                                    _gameScreen.addPlayer(new Player(rectangle.getWidth(), rectangle.getHeight(), chef1,
                                            "assets/chef1.png", (rectangle.getX() + rectangle.getWidth() / 2) + 50,
                                            rectangle.getY() + rectangle.getHeight() / 2));

                                }
                            case "chef2":
                                Body chef2 = BodyContainer.createBody(
                                        rectangle.getX() + rectangle.getWidth() / 2,
                                        rectangle.getY() + rectangle.getHeight() / 2,
                                        rectangle.getWidth(),
                                        rectangle.getHeight(),
                                        true, _gameScreen.getWorld());

                                _gameScreen.addPlayer(new Player(rectangle.getWidth(), rectangle.getHeight(), chef2,
                                        "assets/chef1.png", rectangle.getX() + rectangle.getWidth() / 2,
                                        rectangle.getY() + rectangle.getHeight() / 2));
                            default:
                                break;
                        }
                    }

                }

            }
            // static counter tops / interactable tops
            if (obj instanceof PolygonMapObject) {
                createStaticObject((PolygonMapObject) obj);
            }
        }
    }

    /**
     * Creates the Box2D body for the polygon object
     * 
     * @param polygonMapObject the polygon object from the .tmx layer
     */
    public void createStaticObject(PolygonMapObject polygonMapObject) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = _gameScreen.getWorld().createBody(bodyDef);
        Shape shape = createPolygonShape(polygonMapObject);
        body.createFixture(shape, 1000);
        shape.dispose();
    }

    /**
     * helper function to calculate the shape of the polygon object for the body
     * 
     * @param polygonMapObject the polygon object from the .tmx layer
     */
    private Shape createPolygonShape(PolygonMapObject polygonMapObject) {
        float[] vertices = polygonMapObject.getPolygon().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        for (int i = 0; i < vertices.length / 2; i++) {
            Vector2 current = new Vector2(vertices[i * 2] / 32f, vertices[i * 2 + 1] / 32f);
            worldVertices[i] = current;
        }

        PolygonShape shape = new PolygonShape();
        shape.set(worldVertices);
        return shape;
    }

}
