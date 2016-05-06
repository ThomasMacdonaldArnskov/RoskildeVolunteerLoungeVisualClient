package example;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.newdawn.slick.*;

public class RoskildeVolunteerLoungeVisualClient extends BasicGame {
    private Image wires, bg, toplayer, colourScheme;

    private static final int LISTSIZE = 10;


    private ArrayList<FlammableAnim> flamList;
    private ArrayList<OrganicAnim> organList;
    private ArrayList<CardboardAnim> cardList;


    private int lastUsed = 0;
    private int prevLastUsed = 0;
    private int currentSelectionFlame = 0;
    private int currentSelectionOrgan = 0;
    private int currentSelectionCard = 0;


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

        //LIGHT COLOUR SCHEME
        colourScheme = new Image("assets/lightbluescheme.png");
        wires = new Image("assets/lightblueschemewires.png");
        bg = new Image("assets/lightblueschemebackground.png");
        toplayer = new Image("assets/lightblueschemeoverlay.png");


        ListsAhoy();
    }

    /***********************************
     * Methods for starting the animations... Obviously shouldn't be based on keyboard input
     *
     ***********************************/

    private void startFlammable(GameContainer gc) {
        if (gc.getInput().isKeyPressed(Input.KEY_1)) {
            prevLastUsed = lastUsed;
            lastUsed = 0;
            selector(0);
            flamList.get(currentSelectionFlame).setRunning(true);
        }
    }

    private void startCardboard(GameContainer gc) {
        if (gc.getInput().isKeyPressed(Input.KEY_2)) {
            prevLastUsed = lastUsed;
            lastUsed = 1;
            selector(1);
            cardList.get(currentSelectionCard).setRunning(true);
        }
    }

    private void startOrganic(GameContainer gc) {
        if (gc.getInput().isKeyPressed(Input.KEY_3)) {
            prevLastUsed = lastUsed;
            lastUsed = 2;
            selector(2);
            organList.get(currentSelectionOrgan).setRunning(true);
        }
    }

    public void selector(int i) {

        if (i == 0)
            currentSelectionFlame = (currentSelectionFlame + 1) % LISTSIZE;
        else if (i == 1)
            currentSelectionCard = (currentSelectionCard + 1) % LISTSIZE;
        else if (i == 2)
            currentSelectionOrgan = (currentSelectionOrgan + 1) % LISTSIZE;
        else
            System.out.println("You've ruined the system!");

    }

    /**
     * Changes the order in which the animations are displayed based on what was last activated
     *
     * @param g Slick Graphics Elelemt
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
        startFlammable(gc);
        startCardboard(gc);
        startOrganic(gc);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

        //LAYER 0 : BACKGROUND
        /**
         * Completely monocoloured - Just to account for pixel mistakes
         */
        g.drawImage(colourScheme,0,0);

        //LAYER 1 : WIRES
        g.drawImage(wires, 0, 0);

        //LAYER 2 : ANIMATION
        displayOrder(g);


        //LAYER 3: SURROUNDING AREAS
        g.drawImage(bg, 0, 0);


        //FOR TESTING
        //organicAnim.animation(g);
        //cardboardAnim.animation(g);

        //LAYER 4 : VISUAL COMPONENTS SUCH AS THE GRAPHS
        g.drawImage(toplayer, 0, 0);

        //LAYER 5 : OVERLAY ANIMATIONS (NODE POPS) WHEN THEY ARE DONE AT SOME POINT
        //flamAnim.animationOverlay(g);
        //flamAnim2.animationOverlay(g);

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

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new RoskildeVolunteerLoungeVisualClient("Simple Slick Game"));
            appgc.setDisplayMode(1920, 1080, true);
            appgc.setShowFPS(false);
            appgc.setTargetFrameRate(24);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(RoskildeVolunteerLoungeVisualClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}