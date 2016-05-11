package example;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import org.newdawn.slick.*;

public class RoskildeVolunteerLoungeVisualClient extends BasicGame {

    private Image wires, bg, toplayer, colourScheme;
    static AudioPlayer audioPlayer = new AudioPlayer();

    private static final int LISTSIZE = 10;

    private boolean antiAlias = true;


    private ArrayList<FlammableAnim> flamList;
    private ArrayList<OrganicAnim> organList;
    private ArrayList<CardboardAnim> cardList;


    private int lastUsed = 0;
    private int prevLastUsed = 0;
    private int currentSelectionFlame = 0;
    private int currentSelectionOrgan = 0;
    private int currentSelectionCard = 0;


    //100 PERCENT VALUES FOR GRAPHS
    private final float oneHundredPercent = 297f;
    private final float middleHundredPercent = 266f;

    //X, Y AND WIDTH VALUES FOR GRAPHS

    //TEAM KAFFEBAR
    private final float xPos = 191.99f;
    private float yPos;
    private final float width = 155f;
    private float coffeeBarHeight = 0;
    private float coffeeBarOffset = 310f;

    //TEAM SHUFFLEBOARD
    private final float x2Pos = 408f;
    private float y2Pos;
    private final float width2 = 155f;
    private float shuffleBoardHeight;
    private float shuffleBoardOffset;

    private float combinedActivations;


    //MIDDLE DIAGRAM

    private final float middleY = 331f;
    private final float middleWidth = 89.32f;

    private final float cardboardX = 1015.67f;
    private final float organicX = 830f;
    private final float flamX = 923.34f;
    private float cardBoardHeight;
    private float organicHeight;
    private float flamHeight;

    private float flamOffset;
    private float organicOffset;
    private float cardboardOffset;

    private float combinedWeights;

    private float organW;
    private float cardBoardW;
    private float flamW;
    private float prevOrganW;
    private float prevCardBoardW;
    private float prevFlamW;
    private float coffeeBarActivated;
    private float shuffleBoardActivated;

    private DatabaseHandler databaseHandler;

    TrueTypeFont font;

    private RoskildeVolunteerLoungeVisualClient(String gamename) {
        super(gamename);
    }


    /**
     * Init function. Self explanatory really
     *
     * @param gc Slick Gamecontainer
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc) throws SlickException {

        //DARK COLOUR SCHEME
        /*wires = new Image("assets/wires.png");
        bg = new Image("assets/bg.png");
        toplayer = new Image("assets/toplayer.png");*/

        // initialize SerialListener
        SerialListener main = new SerialListener(this);
        main.initialize();
        System.out.println("Started SerialListener");

        try {
            databaseHandler = new DatabaseHandler("C:/Users/Thomas Macdonald/Documents");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //LIGHT COLOUR SCHEME
        colourScheme = new Image("assets/lightbluescheme.png");
        wires = new Image("assets/lb_wir.png");
        bg = new Image("assets/lb_sur.png");
        toplayer = new Image("assets/lb_ov.png");

        loadFont();
        ListsAhoy();
        LoadValues();
        updatePie();
        updateRace();

    }

    private void updateWeight() {

        //GÅR JEG UD FRA AT VÆRDIERNE HEDDER? DER ER INGEN GRUND TIL AT DET ER PREVIOUS MERE, ET LEVN FRA RANDOM GENERATOR KODEN
        prevCardBoardW = (float) ((int) (databaseHandler.getTotalWeight("Cardboard") / 10)) / 100;
        prevFlamW = (float) ((int) (databaseHandler.getTotalWeight("Flammable") / 10)) / 100;
        prevOrganW = (float) ((int) (databaseHandler.getTotalWeight("Organic") / 10)) / 100;

        /*
        prevCardBoardW = cardBoardW;
        prevFlamW = flamW;
        prevOrganW = organW;
        */
    }

    private void updatePie() {

        //GÅR JEG UD FRA AT VÆRDIERNE HEDDER? BEHØVER NOK IKKE HIVES FRA DATABASEN, DA DEN I ALLE TILFÆLDE BURDE VÆRE OPDATERET PÅ DET TIDSPUNKT HVOR "NOT-PIE" BLIVER KALDT
        flamW = (float) databaseHandler.getTotalWeight("Flammable");
        organW = (float) databaseHandler.getTotalWeight("Organic");
        cardBoardW = (float) databaseHandler.getTotalWeight("Cardboard");

        combinedWeights = flamW + organW + cardBoardW;

        flamHeight = (flamW / combinedWeights) * middleHundredPercent;
        organicHeight = (organW / combinedWeights) * middleHundredPercent;
        cardBoardHeight = (cardBoardW / combinedWeights) * middleHundredPercent;

        flamOffset = middleHundredPercent - flamHeight;
        organicOffset = middleHundredPercent - organicHeight;
        cardboardOffset = middleHundredPercent - cardBoardHeight;
    }

    private void displayPie(Graphics g) {
        Color flamred = new Color(198, 55, 32, 255);
        Color cardblue = new Color(73, 73, 163, 255);
        Color organgreen = new Color(40, 118, 40, 255);

        g.setColor(cardblue);
        g.fillRect(cardboardX, middleY + cardboardOffset, middleWidth, cardBoardHeight);
        g.setColor(organgreen);
        g.fillRect(organicX, middleY + organicOffset, middleWidth, organicHeight);
        g.setColor(flamred);
        g.fillRect(flamX, middleY + flamOffset, middleWidth, flamHeight);
    }

    private void updateRace() {

        //GÅR JEG UD FRA VÆRDIERNE HEDDER? SKAL SELVFØLGELIG VÆRE NOGET ANDET NÅR VI HAR TO SYSTEMER, I DENNE ER KAFFEBAR SAT TIL ORGANISK I STEDET OG SHUFFLEBOARD TIL FLAMMABLE
        shuffleBoardActivated = (float) databaseHandler.getCurrentWeight("Flammable");
        coffeeBarActivated = (float) databaseHandler.getCurrentWeight("Organic");

        combinedActivations = shuffleBoardActivated + coffeeBarActivated;

        shuffleBoardHeight = (shuffleBoardActivated / combinedActivations) * oneHundredPercent;
        coffeeBarHeight = (coffeeBarActivated / combinedActivations) * oneHundredPercent;

        shuffleBoardOffset = oneHundredPercent - shuffleBoardHeight;
        coffeeBarOffset = oneHundredPercent - coffeeBarHeight;
    }

    private void displayRace(Graphics g) {
        Color raceColor = new Color(55, 80, 85);
        g.setColor(raceColor);

        //TEAM KAFFEBAR
        g.fillRect(xPos, yPos + coffeeBarOffset, width, coffeeBarHeight);

        //TEAM SHUFFLEBOARD
        g.fillRect(x2Pos, y2Pos + shuffleBoardOffset, width2, shuffleBoardHeight);
    }

    /***********************************
     * Methods for starting the animations... Obviously shouldn't be based on keyboard input
     ***********************************/

    private void startFlammable() {

        prevLastUsed = lastUsed;
        lastUsed = 0;
        selector(0);
        flamList.get(currentSelectionFlame).setRunning(true);

        // ONLY FOR TESTING
        //graphTester();
    }

    private void startCardboard() {

        prevLastUsed = lastUsed;
        lastUsed = 1;
        selector(1);
        cardList.get(currentSelectionCard).setRunning(true);

        // ONLY FOR TESTING
        //graphTester();
    }

    private void startOrganic() {

        prevLastUsed = lastUsed;
        lastUsed = 2;
        selector(2);
        organList.get(currentSelectionOrgan).setRunning(true);

        // ONLY FOR TESTING
        //graphTester();
    }


    private void selector(int i) {

        if (i == 0)
            currentSelectionFlame = (currentSelectionFlame + 1) % LISTSIZE;
        else if (i == 1)
            currentSelectionCard = (currentSelectionCard + 1) % LISTSIZE;
        else if (i == 2)
            currentSelectionOrgan = (currentSelectionOrgan + 1) % LISTSIZE;
        else
            System.out.println("You've ruined the system!");

    }

    private void graphTester() {
        Random rand = new Random();

        coffeeBarActivated = rand.nextInt(1000);
        shuffleBoardActivated = rand.nextInt(1000);

        organW = rand.nextInt(1000);
        cardBoardW = rand.nextInt(1000);
        flamW = rand.nextInt(1000);
    }

    /**
     * Changes the order in which the animations are displayed based on what was last activated
     *
     * @param g Slick Graphics Element
     */
    private void displayOrder(Graphics g) {
        if (lastUsed == 0 && prevLastUsed == 1) {
            for (int i = 0; i < LISTSIZE; i++) {
                organList.get(i).animation(g);
                cardList.get(i).animation(g);
                flamList.get(i).animation(g);
            }
        } else if (lastUsed == 0 && prevLastUsed == 2) {
            for (int i = 0; i < LISTSIZE; i++) {
                cardList.get(i).animation(g);
                organList.get(i).animation(g);
                flamList.get(i).animation(g);
            }
        } else if (lastUsed == 1 && prevLastUsed == 0) {
            for (int i = 0; i < LISTSIZE; i++) {
                organList.get(i).animation(g);
                flamList.get(i).animation(g);
                cardList.get(i).animation(g);
            }
        } else if (lastUsed == 1 && prevLastUsed == 2) {
            for (int i = 0; i < LISTSIZE; i++) {
                flamList.get(i).animation(g);
                organList.get(i).animation(g);
                cardList.get(i).animation(g);
            }
        } else if (lastUsed == 2 && prevLastUsed == 0) {
            for (int i = 0; i < LISTSIZE; i++) {
                cardList.get(i).animation(g);
                flamList.get(i).animation(g);
                organList.get(i).animation(g);
            }
        } else {
            for (int i = 0; i < LISTSIZE; i++) {
                flamList.get(i).animation(g);
                cardList.get(i).animation(g);
                organList.get(i).animation(g);
            }
        }
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        /*startFlammable(gc);
        startCardboard(gc);
        startOrganic(gc);*/

        for (int j = 0; j < LISTSIZE; j++) {
            if (cardList.get(j).isUpdatePie() || organList.get(j).isUpdatePie() || flamList.get(j).isUpdatePie())
                updatePie();
            if (cardList.get(j).isUpdateTrashRace() || organList.get(j).isUpdateTrashRace() || flamList.get(j).isUpdateTrashRace())
                updateRace();
            if (cardList.get(j).isUpdateWeight() || organList.get(j).isUpdateWeight() || flamList.get(j).isUpdateWeight()) {
                updateWeight();
            }
        }

        //KEYBOARD CONTROL FOR TESTING
        /*
        if (gc.getInput().isKeyPressed(Input.KEY_1)) {
            prevLastUsed = lastUsed;
            lastUsed = 0;
            selector(2);
            organList.get(currentSelectionOrgan).setRunning(true);
        }
        if (gc.getInput().isKeyPressed(Input.KEY_2)) {
            prevLastUsed = lastUsed;
            lastUsed = 0;
            selector(0);
            flamList.get(currentSelectionFlame).setRunning(true);
        }

        if (gc.getInput().isKeyPressed(Input.KEY_3)) {
            prevLastUsed = lastUsed;
            lastUsed = 0;
            selector(1);
            cardList.get(currentSelectionCard).setRunning(true);
        }*/
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

        //LAYER 0 : BACKGROUND
        /**
         * Completely mono coloured - Just to account for pixel mistakes
         */
        g.drawImage(colourScheme, 0, 0);

        //LAYER 1 : WIRES
        g.drawImage(wires, 0, 0);

        //LAYER 2 : ANIMATIONC:\Users\Anders\AppData\Local\GitHub\PortableGit_d76a6a98c9315931ec4927243517bc09e9b731a0\cmd
        displayOrder(g);


        //LAYER 3: SURROUNDING AREAS
        g.drawImage(bg, 0, 0);


        //FOR TESTING
        //organicAnim.animation(g);
        //cardboardAnim.animation(g);

        //LAYER 4 : VISUAL COMPONENTS SUCH AS THE GRAPHS
        //displayRace(g);
        displayPie(g);
        font.drawString(1587, 338, "" + prevCardBoardW + " KG.", Color.white);
        font.drawString(1587, 441, "" + prevOrganW + " KG.", Color.white);
        font.drawString(1587, 542, "" + prevFlamW + " KG.", Color.white);

        //LAYER 5 : GRAPH OVERLAYS
        g.drawImage(toplayer, 0, 0);

        //LAYER 6 : OVERLAY ANIMATIONS (NODE POPS) WHEN THEY ARE DONE AT SOME POINT
        for (int i = 0; i < LISTSIZE; i++) {
            flamList.get(i).animationOverlay(g);
            organList.get(i).animationOverlay(g);
            cardList.get(i).animationOverlay(g);
        }


    }

    private void loadFont() {

        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("assets/dejavu.ttf");

            Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            awtFont = awtFont.deriveFont(24f); // set font size
            font = new TrueTypeFont(awtFont, antiAlias);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the ever living sh** out of animation lists
     */
    private void ListsAhoy() {

        flamList = new ArrayList<>(LISTSIZE);
        flamList.add(0, new FlammableAnim());
        flamList.add(1, new FlammableAnim());
        flamList.add(2, new FlammableAnim());
        flamList.add(3, new FlammableAnim());
        flamList.add(4, new FlammableAnim());
        flamList.add(5, new FlammableAnim());
        flamList.add(6, new FlammableAnim());
        flamList.add(7, new FlammableAnim());
        flamList.add(8, new FlammableAnim());
        flamList.add(9, new FlammableAnim());

        organList = new ArrayList<>(LISTSIZE);
        organList.add(0, new OrganicAnim());
        organList.add(1, new OrganicAnim());
        organList.add(2, new OrganicAnim());
        organList.add(3, new OrganicAnim());
        organList.add(4, new OrganicAnim());
        organList.add(5, new OrganicAnim());
        organList.add(6, new OrganicAnim());
        organList.add(7, new OrganicAnim());
        organList.add(8, new OrganicAnim());
        organList.add(9, new OrganicAnim());

        cardList = new ArrayList<>(LISTSIZE);
        cardList.add(0, new CardboardAnim());
        cardList.add(1, new CardboardAnim());
        cardList.add(2, new CardboardAnim());
        cardList.add(3, new CardboardAnim());
        cardList.add(4, new CardboardAnim());
        cardList.add(5, new CardboardAnim());
        cardList.add(6, new CardboardAnim());
        cardList.add(7, new CardboardAnim());
        cardList.add(8, new CardboardAnim());
        cardList.add(9, new CardboardAnim());
    }

    private void LoadValues() {
        //X, Y AND WIDTH VALUES FOR GRAPHS

        //TEAM KAFFEBAR
        yPos = 310f;
        coffeeBarHeight = 0;
        coffeeBarOffset = 310f;

        //TEAM SHUFFLEBOARD
        y2Pos = 310f;
        shuffleBoardHeight = 0;
        shuffleBoardOffset = 310f;

        //MIDDLE DIAGRAM
        cardBoardHeight = 0;
        organicHeight = 0;
        flamHeight = 0;

        flamOffset = 310;
        organicOffset = 310;
        cardboardOffset = 310;

        //ONLY FOR TESTING
        organW = 2000;
        cardBoardW = 900;
        flamW = 4000;
        coffeeBarActivated = 150;
        shuffleBoardActivated = 100;
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new RoskildeVolunteerLoungeVisualClient("Simple Slick Game"));
            appgc.setDisplayMode(1920, 1080, false);
            appgc.setShowFPS(false);
            appgc.setTargetFrameRate(24);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(RoskildeVolunteerLoungeVisualClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onReceive(String msg) {
        String[] splitMessage = msg.split(",");

        double weight = Double.parseDouble(splitMessage[1]);
        System.out.println("Weight is: " + weight);

        databaseHandler.addItem(splitMessage[0], weight);
        System.out.println("Added to database!");

        if (splitMessage[0].equals("Flammable")) {
            startFlammable();
        } else if (splitMessage[0].equals("Cardboard")) {
            startCardboard();
        } else if (splitMessage[0].equals("Organic")) {
            audioPlayer.playSoundBio(1);
            startOrganic();
        } else {
            System.out.println("Someone is trying to hack our wonderful system!");
        }
    }
}