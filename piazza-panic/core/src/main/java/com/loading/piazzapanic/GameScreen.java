package com.loading.piazzapanic;

import java.util.ArrayList;
import java.util.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.loading.piazzapanic.foodstuffs.*;

public class GameScreen implements Screen {

    final Launcher _parent;

    // Texture <varName> for a new texture
    // Sound <varName> for sound
    // Music <varName> for music
    Music themeMusic;
    OrthographicCamera camera;

    private OrthogonalTiledMapRenderer _mapRenderer;
    private TileMapParser _tileMapper;

    private HeartDisplay heartDisplay;
    private Box2DDebugRenderer box2dDebugRenderer;
    private Bun bun;
    private Burger burger;
    private Lettuce lettuce;
    private Pickles pickles;
    private Tomato tomato;

    private Npc npc;
    private CuttingBoard cuttingBoard;


    private Bin bin;

    private Receipt receipt;

    private Plate plate;
    private SauceBottle ketchupBottle;
    private SauceBottle mayoBottle;
    private Sauce ketchup;
    private Sauce mayo;
    Texture ketchupBottleTexture;
    Texture mayoBottleTexture;

    Texture NpcTexture;

    Texture receiptTexture;

    Texture background;
    Sprite backgroundSprite;
    Texture binTexture;
    Texture cuttingBoardTexture;

    Texture chef1;
    Sprite chef1Sprite;

    ArrayList<Player> players;
    int activePlayer;



    World world;
    ListenerHelper listener;

    Texture heartTexture;
    int maxHearts = 6;

    long timeStarted = 0;
    long elapsedTime;

    Boolean endNpcTime = false;

    String message = "";
    float messageX;
    float messageY;

    Boolean npcAtRegister = false;

    Boolean collectedReciept = false;

    Boolean collectedPlate = false;
    Boolean bunPickedUp= false;
    Boolean tomatoPickedUp = false;
    Boolean tomatoChopped = false;
    Boolean picklesPickedUp = false;
    Boolean chickenPickedUp = false;
    Boolean chickenCooked = false;
    Boolean beefPickedUp = false;
    Boolean beefCooked = false;
    Boolean lettucePickedUp = false;
    Boolean lettuceChopped = false;
    Boolean mayoCollected = false;
    Boolean ketchupCollected = false;
    ArrayList<String> currentlyCollectedIngredients = new ArrayList<String>();

    BitmapFont secondFont;

    String messageTwo = "";

    int plateCollectedBy;

    public GameScreen(final Launcher parent) {
        this._parent = parent;

        this.players = new ArrayList<Player>();

        this.activePlayer = 0;

        this.box2dDebugRenderer = new Box2DDebugRenderer();

        this.background = new Texture("assets/main.png");
        this.backgroundSprite = new Sprite(this.background);

        //this.chef1 = new Texture("assets/chef1.png");
        //this.chef1Sprite = new Sprite(this.chef1);

        this.heartTexture = new Texture("assets/heart.png");
        this.heartDisplay = new HeartDisplay(_parent, this.maxHearts, this.heartTexture);
        // Image loading
        this.NpcTexture = new Texture("assets/Npc_Spritesheet.png");
        this.npc = new Npc(_parent, NpcTexture);

        this.receiptTexture = new Texture("assets/Receipt.png");
        this.receipt = new Receipt(_parent, receiptTexture);

        // Sound and music loading

        // camera
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 800);

        // world and map
        this.world = new World(new Vector2(0, 0), false);
        this.listener = new ListenerHelper();
        world.setContactListener(new ContactListener());

        this._tileMapper = new TileMapParser(this);
        this._mapRenderer = _tileMapper.setupMap();

        this.plate = new Plate(_parent);
        binTexture = new Texture("assets/bin.png");
        this.bin = new Bin(_parent, binTexture);

        cuttingBoardTexture = new Texture("assets/chopping_board.png");
        this.cuttingBoard = new CuttingBoard(_parent, cuttingBoardTexture);

        Body mayoBody = BodyContainer.createBody(
                0, 0,
                10,

                10,
                false, this.getWorld()
        );
        this.mayoBottle = new SauceBottle(10,10,mayoBody,"assets/foodstuffs/mayo_bottle.png","Mayo");
        Body ketchupBody = BodyContainer.createBody(
                0, 0,
                10,

                10,
                false, this.getWorld()
        );

        this.ketchupBottle = new SauceBottle(10,10,ketchupBody, "assets/foodstuffs/ketchup_bottle.png", "Ketchup");
        mayoBottle.setPosition(550,500);
        ketchupBottle.setPosition(600, 500);

        _parent.font.setColor(Color.RED);

        secondFont = new BitmapFont();
    }

    public World getWorld() {
        return this.world;
    }

    public void addPlayer(Player player) {
        players.add(player);
        if (players.size() == 1) {
            players.get(0).setActivePlayer(true);
        }
    }



    public void setActivePlayer(int index) {
        activePlayer = index;
    }

    private void update() {
        // Vector3 position = camera.position;
        // position.x = Math.round(players.get(activePlayer).x * 32f * 10) / 10;
        // position.y = Math.round(players.get(activePlayer).y * 32f * 10) / 10;
        // camera.position.set(position);
        camera.update();

        _parent.batch.setProjectionMatrix(camera.combined);
        _mapRenderer.setView(camera);
    }

    // Allows for forward and backward cycling of players without causing index out
    // of bounds errors
    private void cyclePlayer(int direction) {
        Player current = players.get(activePlayer);
        current.setActivePlayer(false);

        int index = players.indexOf(current);
        int length = players.size();
        if (direction > 0) {
            index += 1;
            if (index == length) index = 0;
        } else {
            index -= 1;
            if (index < 0) index = length - 1;
        }
        activePlayer = index;
        players.get(activePlayer).setActivePlayer(true);
    }

    public void reduceHearts() {
        this.heartDisplay.reduceHearts(1);
    }

    public void checkPosition() {
        Player current = players.get(activePlayer);
        float playerPosx = current.getBody().getPosition().x;
        float playerPosY = current.getBody().getPosition().y;
        /*
        * X: 960.0
        Y: 303.0
        *
        * X: 1045.0
        Y: 303.0
        */
        if ((playerPosx < 1045 && playerPosx > 960) && (playerPosY >300 && playerPosY < 330) && (!collectedReciept)) {
            setMessage("Press F to get \ncustomer reciept");
            messageX = 1050;
            messageY = 320;
        } else if((playerPosx < 1045 && playerPosx > 960) && (playerPosY >300 && playerPosY < 330) && (collectedReciept)) {
            setMessage("Press F to get \nserve order");
            messageX = 1050;
            messageY = 320;
        }else if((playerPosx > 860 && playerPosx < 890) && (playerPosY > 450 && playerPosY <500) && (!collectedPlate)) {
            if (!collectedReciept) {
                setMessage("Please collect\nreceipt first.");
            } else {
                _parent.font.setColor(Color.RED);
                _parent.font.getData().setScale(1f);
                setMessage("Press F to\npickup plate");
            }

            messageX = 780;
            messageY = 550;
        } else if((playerPosx < 80 && playerPosx > 50) && (playerPosY > 610 && playerPosY < 630) && (collectedPlate) && (plateCollectedBy == activePlayer) && (!chickenPickedUp) && !beefPickedUp) {
            setMessage("Press F to \npickup the \nchicken");
            messageY = 720;
            messageX = 5;
        } else if((playerPosx < 80 && playerPosx > 50) && (playerPosY > 490 && playerPosY < 530) && (collectedPlate) && (plateCollectedBy == activePlayer) && (!beefPickedUp) && !chickenPickedUp) {
            setMessage("Press F to \npickup the \nbeef");
            messageY = 600;
            messageX = 5;
        } else if ((playerPosx < 80 && playerPosx > 50) && (playerPosY > 360 && playerPosY < 390)&& (collectedPlate) && (plateCollectedBy == activePlayer) && (!bunPickedUp)) {
            setMessage("Press F to \npickup the \nbun");
            messageX = 5;
            messageY = 470;
        } else if((playerPosx > 1180 && playerPosx<1210) && (playerPosY > 360 && playerPosY < 390)&& (collectedPlate) && (plateCollectedBy == activePlayer) && (!lettucePickedUp)) {
            setMessage("Press F to \npickup the \nLettuce");
            messageX = 1210;
            messageY = 480;
        } else if((playerPosx> 1180 && playerPosx <1210) && (playerPosY > 480 && playerPosY < 510)&& (collectedPlate) && (plateCollectedBy == activePlayer) && (!tomatoPickedUp)) {{
            setMessage("Press F to \npickup the \nTomato");
            messageX = 1210;
            messageY = 600;
        }} else if((playerPosx > 1180 && playerPosx < 1210) && (playerPosY > 610 && playerPosY < 630)&& (collectedPlate) && (plateCollectedBy == activePlayer) && (!picklesPickedUp)) {{
            setMessage("Press F to \npickup the \nPickle");
            messageY = 730;
            messageX = 1210;
            /*
            * Current x: 185.0
Current y: 303.0*/
        }} else if ((playerPosx > 170 && playerPosx < 200) && (playerPosY > 290 && playerPosY < 315) && (collectedPlate) && (tomatoPickedUp || bunPickedUp || lettucePickedUp || picklesPickedUp || chickenPickedUp || beefPickedUp)) {
            setMessage("Press R to\nclear plate");
            messageY = 330;
            messageX = 220;
        } else if((playerPosx > 350 && playerPosx < 390) && (playerPosY>420 && playerPosY <450 ) && (tomatoPickedUp) && (!tomatoChopped)) {
            setMessage("Press F to chop\ntomato");
            messageY = 550;
            messageX = 350;
        } else if((playerPosx > 350 && playerPosx < 390) && (playerPosY>420 && playerPosY <450 ) && (lettucePickedUp) && (!lettuceChopped)) {
            setMessage("Press F to chop\nlettuce");
            messageY = 550;
            messageX = 350;
            /**
             * mayoBottle.setPosition(550,500);
             *         ketchupBottle.setPosition(600, 500)
             */

        } else if((playerPosx > 530 && playerPosx <560) && (playerPosY > 480 && playerPosY <535) && (collectedPlate) && (!mayoCollected)) {
            setMessage("Press F to \nget mayo");
            messageY = 480;
            messageX = 540;
        } else if((playerPosx > 590 && playerPosx < 620) && (playerPosY > 480 && playerPosY <535) && (collectedPlate) && (!ketchupCollected)) {
            setMessage("Press F to \nget ketchup");
            messageY = 480;
            messageX = 540;
        }
        else {
            setMessage("");

        }
        if((players.get(0).getBody().getPosition().x > players.get(1).getBody().getPosition().x - 70)
                && players.get(0).getBody().getPosition().x < players.get(1).getBody().getPosition().x + 70 &&
                players.get(0).getBody().getPosition().y > players.get(1).getBody().getPosition().y - 70 &&
                players.get(0).getBody().getPosition().y < players.get(1).getBody().getPosition().y + 70 && collectedPlate) {
            _parent.font.setColor(Color.RED);
            _parent.font.getData().setScale(1f);
            setMessage("Press F to give the other\nplayer the plate");
            messageX = players.get(0).getBody().getPosition().x;
            messageY = playerPosY + 100;
        } else {

        }
    }
    public Vector2 getPos() {
        return players.get(activePlayer).getBody().getPosition();
    }
    public void create() {
        timeStarted = System.currentTimeMillis();
    }
    @Override
    public void render(float delta) {
        checkPosition();
        if (timeStarted == 0) {
            timeStarted = System.currentTimeMillis();
        }

        elapsedTime = (System.currentTimeMillis()- timeStarted) ;

        //System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        ScreenUtils.clear(0, 0, 0.2f, 1);

        this.update();

        _mapRenderer.render();

        _parent.batch.begin();


        backgroundSprite.draw(this._parent.batch);
        for (Player chef : players) {
            chef.render(this._parent.batch);
        }
        secondFont.getData().setScale(1);
        secondFont.setColor(Color.RED);
        secondFont.draw(_parent.batch, messageTwo,20, Gdx.graphics.getHeight()- 15);
        _parent.font.draw(_parent.batch, message, messageX, messageY);
        _parent.batch.end();
        cuttingBoard.render();
        box2dDebugRenderer.render(world, camera.combined.scl(32f));
        mayoBottle.render(_parent.batch);
        ketchupBottle.render(_parent.batch);
        heartDisplay.render();
        if (collectedPlate) {
            plate.changePosition(players.get(plateCollectedBy).getBody().getPosition().x + 20,players.get(plateCollectedBy).getBody().getPosition().y);
        }
        plate.render();
        //    Boolean bunPickedUp, burgerPickedUp, lettucePickedUp, picklesPickedUp, tomatoPickedUp = false;
        if (tomatoPickedUp) {
            tomato.setPosition(plate.getX() - 10, plate.getY() - 10);
            tomato.render(_parent.batch);
        }
        if (lettucePickedUp) {
            lettuce.setPosition(plate.getX() -5, plate.getY() - 19);
            lettuce.render(_parent.batch);
        }
        if (bunPickedUp) {
            bun.setPosition(plate.getX()-10, plate.getY()-30);
            bun.render(_parent.batch);
        }
        if (picklesPickedUp) {

            pickles.setPosition(plate.getX() - 20, plate.getY() - 10);
            pickles.render(_parent.batch);
        }
        if (chickenPickedUp||beefPickedUp ) {


            burger.setPosition(plate.getX() - 20, plate.getY() -20);
            burger.render(_parent.batch);
        }
        if (ketchupCollected) {
            ketchup.setPosition(plate.getX(), plate.getY());
            ketchup.render(_parent.batch);
        }
        if (mayoCollected) {
            mayo.setPosition(plate.getX() , plate.getY()-10);
            mayo.render(_parent.batch);
        }

        npc.render(Gdx.graphics.getDeltaTime());
        bin.render();

        if (!endNpcTime && npc.getX() >= 1000) {
            npc.move(npc.getX()-1,225);
        } else if (endNpcTime) {
            if (npc.getX() > -50) {
                npc.move(npc.getX()-1, 225);
            }
        } else {
            npc.toggleMoving(false);
            npcAtRegister = true;
            if (collectedReciept) {
                receipt.render();
                _parent.font.getData().setScale(1);
                _parent.font.setColor(Color.RED);
                npcAtRegister = false;
                setMessage("");
            }

        }





        world.step(delta, 0, 2);
    }

    @Override
    public void show() {
        // Starts the music when game starts
        // themeMusic.play();
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.E) {
                    cyclePlayer(1);
                }
                if (keycode == Input.Keys.Q) {
                    cyclePlayer(-1);
                }
                if (keycode == Input.Keys.SPACE) {
                    // some interact method here
                }
                if (keycode == Input.Keys.C) {
                    endNpcTime = true;
                }
                if (keycode == Input.Keys.Z) {
                    System.out.println(receipt.getExpectedToppings());
                }
                if (keycode == Input.Keys.F) {
                    Vector2 pos = getPos();
                    float playerPosx = pos.x;
                    float playerPosY = pos.y;
                    if ((playerPosx < 1045 && playerPosx > 960) && (playerPosY >300 && playerPosY < 330) && (!collectedReciept)) {
                        collectedReciept = true;
                    } else if ((playerPosx < 1045 && playerPosx > 960) && (playerPosY >300 && playerPosY < 330) && (collectedReciept)) {
                        Boolean success = serve();
                        if (!success) {
                            int currentHearts = heartDisplay.getNumHearts();
                            if (currentHearts < 1) {
                                _parent.setScreen(new GameOverScreenFail(_parent, elapsedTime));

                            }
                            System.out.println(currentHearts);

                            reduceHearts();
                        } else {
                            _parent.setScreen(new GameOverScreenSuccess(_parent, elapsedTime));
                        }
                    }
                    else if ((playerPosx > 860 && playerPosx < 890) && (playerPosY > 450 && playerPosY <500) && (collectedReciept)) {
                        System.out.println("Plate collected");
                        collectedPlate = true;
                        plateCollectedBy = activePlayer;
                    }

                    else {

                    }
                    if((players.get(0).getBody().getPosition().x > players.get(1).getBody().getPosition().x - 70)
                            && players.get(0).getBody().getPosition().x < players.get(1).getBody().getPosition().x + 70 &&
                            players.get(0).getBody().getPosition().y > players.get(1).getBody().getPosition().y - 70 &&
                            players.get(0).getBody().getPosition().y < players.get(1).getBody().getPosition().y + 70 && collectedPlate) {
                        if (plateCollectedBy == 0) {
                            plateCollectedBy = 1;
                        } else {
                            plateCollectedBy = 0;
                        }
                    }
                    if((playerPosx> 1180 && playerPosx <1210) && (playerPosY > 480 && playerPosY < 510)&& (collectedPlate) && (plateCollectedBy == activePlayer) && (!tomatoPickedUp)) {
                        pickup("Tomato");

                    } else if((playerPosx > 1180 && playerPosx<1210) && (playerPosY > 360 && playerPosY < 390)&& (collectedPlate) && (plateCollectedBy == activePlayer) && (!lettucePickedUp)) {
                        pickup("Lettuce");
                    }
                    if ((playerPosx < 80 && playerPosx > 50) && (playerPosY > 360 && playerPosY < 390)&& (collectedPlate) && (plateCollectedBy == activePlayer) && (!bunPickedUp)) {
                        pickup("Bun");
                    }
                    if((playerPosx > 1180 && playerPosx < 1210) && (playerPosY > 610 && playerPosY < 630)&& (collectedPlate) && (plateCollectedBy == activePlayer) && (!picklesPickedUp)) {
                        pickup("Pickle");
                    }
                    if((playerPosx < 80 && playerPosx > 50) && (playerPosY > 610 && playerPosY < 630) && (collectedPlate) && (plateCollectedBy == activePlayer) && (!chickenPickedUp) && (!beefPickedUp)) {

                        pickup("Chicken");
                    }
                    if((playerPosx < 80 && playerPosx > 50) && (playerPosY > 490 && playerPosY < 530) && (collectedPlate) && (plateCollectedBy == activePlayer) && (!beefPickedUp) && (!chickenPickedUp)) {
                        pickup("Beef");
                    }
                    if((playerPosx > 350 && playerPosx < 390) && (playerPosY>420 && playerPosY <450 ) && (tomatoPickedUp) && (!tomatoChopped)) {
                        tomatoChopped = true;
                        tomato.chop();
                        System.out.println("Tomato chopped.");
                    } else if ((playerPosx > 350 && playerPosx < 390) && (playerPosY>420 && playerPosY <450 ) && (lettucePickedUp) && (!lettuceChopped)) {
                        lettuceChopped = true;
                        lettuce.chop();
                    }
                    if((playerPosx > 530 && playerPosx <560) && (playerPosY > 480 && playerPosY <535) && (collectedPlate) && (!mayoCollected)) {
                        pickup("Mayo");
                    } else if((playerPosx > 590 && playerPosx < 620) && (playerPosY > 480 && playerPosY <535) && (collectedPlate) && (!ketchupCollected)) {
                        pickup("Ketchup");
                    }

                }

                if (keycode == Input.Keys.L) {
                    int currentHearts = heartDisplay.getNumHearts();
                    if (currentHearts < 1) {
                        _parent.setScreen(new GameOverScreenFail(_parent, elapsedTime));
                    }
                    System.out.println(currentHearts);
                    reduceHearts();
                }

                if (keycode == Input.Keys.N) {
                    _parent.setScreen(new GameOverScreenSuccess(_parent, elapsedTime));
                }

                if (keycode == Input.Keys.R) {
                    Vector2 pos = getPos();
                    float playerPosx = pos.x;
                    float playerPosY = pos.y;
                    if ((playerPosx > 170 && playerPosx < 200) && (playerPosY > 290 && playerPosY < 315) && (collectedPlate) && (tomatoPickedUp || bunPickedUp || lettucePickedUp || picklesPickedUp || beefPickedUp || chickenPickedUp)) {
                        tomatoPickedUp = false;
                        bunPickedUp = false;
                        lettucePickedUp = false;
                        picklesPickedUp = false;
                        chickenPickedUp = false;
                        beefPickedUp = false;
                        tomatoChopped = false;
                        lettuceChopped = false;
                        beefCooked = false;
                        chickenCooked = false;
                        ketchupCollected = false;
                        mayoCollected = false;
                        currentlyCollectedIngredients = new ArrayList<String>();
                    }
                }

                if (keycode == Input.Keys.ESCAPE) {
                    Gdx.app.exit();
                    System.exit(-1);
                }



                return true;
            }
        });
    }

    public void setMessage(String _message) {
        this.message = _message;
    }

    public void setMessageTwo(String _messageTwo) {
        messageTwo = _messageTwo;
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        _parent.batch.dispose();
        _parent.font.dispose();
    }

    public void pickup(String itemPickedUp) {
        /*
        *     private Bun bun;
              private Burger burger;
              private Lettuce lettuce;
              private Pickles pickles;*/
        switch(itemPickedUp) {
            case "Tomato":
                System.out.println("Tomato picked up");
                currentlyCollectedIngredients.add("Tomato");
                tomatoPickedUp = true;
                Body tomatoBody = BodyContainer.createBody(
                        0, 0,
                        10,

                        10,
                        false, this.getWorld()
                );
                this.tomato = new Tomato(10, 10, tomatoBody, "assets/foodstuffs/tomato.png", "Tomato");
                tomato.setScale(0.45f);
                break;
            case "Lettuce":
                System.out.println("Lettuce picked up");
                currentlyCollectedIngredients.add("Lettuce");
                lettucePickedUp = true;
                Body lettuceBody = BodyContainer.createBody(
                        0, 0,
                        10,

                        10,
                        false, this.getWorld()
                );

                this.lettuce = new Lettuce(10, 10, lettuceBody, "assets/foodstuffs/lettuce.png", "Lettuce");
                lettuce.setScale(0.45f);
                break;
            case "Bun":
                System.out.println("Bun picked up");
                currentlyCollectedIngredients.add("Bun");
                bunPickedUp = true;
                Body bunBody = BodyContainer.createBody(
                        0, 0,
                        10,

                        10,
                        false, this.getWorld()
                );
                this.bun = new Bun(10,10,bunBody,"assets/foodstuffs/bun.png", "Bun");
                bun.setScale(0.45f);
                break;
            case "Pickle":
                System.out.println("Pickle picked up");
                picklesPickedUp = true;
                currentlyCollectedIngredients.add("Pickles");
                Body pickleBody = BodyContainer.createBody(
                        0, 0,
                        10,

                        10,
                        false, this.getWorld()
                );
                this.pickles = new Pickles(10,10,pickleBody,"assets/foodstuffs/pickle.png", "Pickle");
                pickles.setScale(0.45f);
                break;
            case "Chicken":
                System.out.println("Chicken picked up");
                chickenPickedUp = true;
                currentlyCollectedIngredients.add("Chicken");
                Body burgerBody = BodyContainer.createBody(
                        0, 0,
                        10,

                        10,
                        false, this.getWorld()
                );
                this.burger = new Burger(10,10,burgerBody, "assets/foodstuffs/chicken.png", "Chicken");
                burger.setScale(0.45f);
                break;
                case "Beef":
                System.out.println("Beef picked up");
                beefPickedUp = true;
                currentlyCollectedIngredients.add("Beef");
                Body beefBody = BodyContainer.createBody(
                        0, 0,
                        10,

                        10,
                        false, this.getWorld()
                );
                this.burger = new Burger(10,10,beefBody, "assets/foodstuffs/beef.png", "Beef");
                burger.setScale(0.45f);
                break;
            case "Mayo":
                mayoCollected = true;
                currentlyCollectedIngredients.add("Mayo");
                Body mayoBody = BodyContainer.createBody(0, 0,
                        10,

                        10,
                        false, this.getWorld());
                this.mayo = new Sauce(10,10,mayoBody, "assets/foodstuffs/mayo.png", "Mayo");
                mayo.setScale(0.45f);
                break;
            case "Ketchup":
                ketchupCollected = true;
                currentlyCollectedIngredients.add("Ketchup");
                Body ketchupBody = BodyContainer.createBody(0, 0,
                        10,

                        10,
                        false, this.getWorld());
                this.ketchup = new Sauce(10,10,ketchupBody, "assets/foodstuffs/ketchup.png", "Ketchup");
                ketchup.setScale(0.45f);
                break;
            default:
                break;
        }

    }

    public Boolean serve() {
        if (!(receipt.getExpectedToppings().size() == currentlyCollectedIngredients.size())) {
            if (receipt.getExpectedToppings().size() > currentlyCollectedIngredients.size()) {
                setMessageTwo("You dont have enough toppings...");
            } else {
                setMessageTwo("You have too many toppings...");
            }
            System.out.println("Not equal lengths");
            System.out.println(receipt.getExpectedToppings());
            System.out.println(currentlyCollectedIngredients);
            return false;
        }
        for (String i: receipt.getExpectedToppings()) {
            if (!currentlyCollectedIngredients.contains(i)) {
                setMessageTwo("You got the ingredients wrong");
                System.out.println("Mismatched ingredients");
                System.out.println(receipt.getExpectedToppings());
                System.out.println(currentlyCollectedIngredients);
                return false;
            }
        }
        String status;
        for (String i: currentlyCollectedIngredients) {
            switch (i) {
                case "Tomato":
                     status = tomato.getPrepStatus();
                    if (!Objects.equals(status, "CHOPPED")) {
                        System.out.println("Tomatos are not chopped");
                        setMessageTwo("Tomatos aren't chopped");
                        return false;
                    }
                    break;
                case "Lettuce":
                     status = lettuce.getPrepStatus();
                     if (!Objects.equals(status, "CHOPPED")) {
                         setMessageTwo("Lettuce aren't chopped");
                         System.out.println("Lettuce are not chopped");
                         System.out.println(status);
                         return false;
                     }
                     break;
                default:
                    break;

            }
        }
        return true;
    }
}
