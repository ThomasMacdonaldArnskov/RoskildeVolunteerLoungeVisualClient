package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Created by Thomas Macdonald on 04-05-2016.
 */

class OrganicAnim {

    private static final Color organgreen = new Color(40, 118, 40, 255);

    //Active or not
    private boolean running;

    //FPS counter
    private int counter;

    //Animation Box Positions
    private float xPos, yPos, width, height;
    private float x2Pos, y2Pos, width2, height2;
    private float x3Pos, y3Pos, width3, height3;
    private float x4Pos, y4Pos, width4, height4;
    private float x5Pos, y5Pos, width5, height5;
    private float x6Pos, y6Pos, width6, height6;
    private float x7Pos, y7Pos, width7, height7;

    //Longer sustained highlights
    private float xWeightPos, yWeightPos, widthWeight, heightWeight;
    private float xRacePos, yRacePos, widthRace, heightRace;

    //Overlay elements
    private float pX, pY, radius;


    OrganicAnim() {

        //STARTING POSITION
        reset();

    }

    /**************************************
     * Hope You Like Pasta!
     * Animation Control for the visual impulse for the flammable garbage
     *
     * @param g Slick Graphics Element
     **************************************/

    void animation(Graphics g) {

        g.setColor(organgreen);

        if (running) {

            System.out.println(counter);
            counter++;

            if (counter < 6) {

                yPos -= 10.62f;

                g.fillRect(xPos, yPos, width, height);

            } else if (counter >= 6 && counter < 9) {

                height -= 36.93f;
                width2 += 36.77f;
                x2Pos -= 36.58f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);

            } else if (counter >= 9 && counter < 17) {

                x2Pos -= 26.67f;
                y3Pos -= 12.6875f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);

            } else if (counter >= 17 && counter < 25) {

                y3Pos -= 12.6875f;
                y4Pos -= 13.33f;
                height4 += 13.34f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);

                width = 14f;
                height = 10f;
                xPos = 952.6f;
                yPos = 855.6f;

            } else if (counter >= 25 && counter < 91) {

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);

            } else if (counter >= 91 && counter < 94) {

                y3Pos -= 8.24f;
                height3 -= 3.56f;
                height4 -= 13.6f;
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);

            } else if (counter >= 94 && counter < 100) {

                y3Pos -= 8.24f;
                height3 -= 3.56f;
                height4 -= 13.6f;
                y5Pos -=7.175f;
                height5 += 4.53f;
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x5Pos, y5Pos, width5, height5);

            } else if (counter >= 100 && counter < 107) {

                y3Pos -= 8.24f;
                height3 -= 3.56f;
                y5Pos -=7.175f;
                height5 += 4.53f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x5Pos, y5Pos, width5, height5);


            } else if (counter >= 107 && counter < 109) {

                x5Pos -= 24.52f;

                g.fillRect(x5Pos, y5Pos, width5,height5);

            } else if (counter >= 109 && counter < 116) {

                x5Pos -= 24.52f;
                y5Pos = 787.45f;
                g.fillRect(x5Pos, y5Pos, width5,height5);

            } else if (counter >= 116 && counter < 126) {
                x5Pos -= 24.52f;
                y5Pos = 767.3f;
                g.fillRect(x5Pos, y5Pos, width5,height5);

            } else if (counter >= 126 && counter < 130) {

                x5Pos -= 25.52f;
                y6Pos -= 37.03f;


                g.fillRect(x5Pos, y5Pos, width5,height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);


            } else if (counter >= 130 && counter < 135) {

                y6Pos -= 7f;
                height6 -= 13.08f;
                x7Pos -= 6.61f;
                y7Pos -= 2.54f;
                width7 += 24.45f;
                height7 += 2.55;

                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);

                xPos = 113.9f;
                yPos = 625.1f;
                width = 44.4f;
                height = 48.1f;

            } else if (counter >= 135 && counter < 151) {

                xPos +=1.05f;
                width+= 27.99f;
                width7 += 20.325f;

                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xPos, yPos, width, height);


            } else if (counter >= 147 && counter < 162) {
                g.fillRect(xPos, yPos, width, height);



            } else if (counter >= 162 && counter < 182) {
                g.fillRect(xPos, yPos, width, height);



            } else if (counter >= 182 && counter < 193) {
                g.fillRect(xPos, yPos, width, height);


            } else if (counter >= 193 && counter < 200) {
                g.fillRect(xPos, yPos, width, height);



            } else if (counter >= 200 && counter < 205) {
                g.fillRect(xPos, yPos, width, height);


            } else if (counter >= 205 && counter < 214) {
                g.fillRect(xPos, yPos, width, height);


            } else if (counter >= 214 && counter < 240) { //HERE IT GOES UP THE WEIGHTS
                g.fillRect(xPos, yPos, width, height);


            } else if (counter >= 240 && counter < 252) {
                g.fillRect(xPos, yPos, width, height);



            } else if (counter >= 252 && counter < 266) {
                g.fillRect(xPos, yPos, width, height);



            } else if (counter >= 266 && counter < 280) {


            } else if (counter >= 280 && counter < 297) {


                g.fillOval(x4Pos, y4Pos, width4, height4);

            } else if (counter >= 297 && counter < 312) {

                g.fillOval(x4Pos, y4Pos, width4, height4);

            } else if (counter >= 312 && counter < 323) {

                x4Pos += 33.25;
                width4 -= 66.67;

                g.fillOval(x4Pos, y4Pos, width4, height4);

            } else {

                reset();
                running = false;
            }
        }
    }


    /***************************************
     * Getter and setter methods
     ***************************************/

    public boolean isRunning() {
        return running;
    }

    void setRunning(boolean bool) {
        running = bool;
    }


    /***************************************
     * Reset values for the animation
     ***************************************/
    private void reset() {

        counter = 0;

        xPos = 957.4f;
        yPos = 1080.65f;
        width = 5f;
        height = 115.0f;

        x2Pos = 957.45f;
        y2Pos = 1027.5f;
        width2 = 4.7f;
        height2 = 5.25f;

        x3Pos = 724.40f;
        y3Pos = 1093.35f;
        width3 = 7f;
        height3 = 115f;

        x4Pos = 668.3f;
        y4Pos = 996.35f;
        width4 = 115f;
        height4 = 9.5f;

        x5Pos = 694.05f;
        y5Pos = 851.4f;
        width5 = 61.75f;
        height5 = 9.3f;

        x6Pos = 183.5f;
        y6Pos = 838.45f;
        width6 = 7f;
        height6 = 78.45f;

        x7Pos = 164.45f;
        y7Pos = 646.4f;
        width7 = 45.1f;
        height7 = 26.8f;

        xWeightPos = 1788.4f; //HERE
        yWeightPos = 627.75f;
        widthWeight = 17.45f;
        heightWeight = 45.8f;

        xRacePos = 114.75f;
        yRacePos = 627.45f;
        widthRace = 16.85f;
        heightRace = 45.9f;

        pX = 903.85f;
        pY = 892.5f;
        radius = 110.6f;
    }

}

