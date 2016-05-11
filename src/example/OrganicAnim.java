package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Class for organic animation
 * Created by Thomas Macdonald on 04-05-2016.
 */

class OrganicAnim {

    private static final Color organgreen = new Color(40, 118, 40, 255);

    //Active or not
    private boolean running, updateTrashRace, updatePie, updateWeight;

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

    private int alpha = 255;
    private int alphaOverlay = 255;
    private int alphaOverlayDeux = 255;
    private int alphaOverlayR = 255;

    private float pX, pY, radius;
    private float pX2, pY2, radius2;
    private float pXr, pYr, widthRP, heightRP;


    OrganicAnim() {

        //STARTING POSITION
        reset();

    }

    public void updateTrashRace() {
        System.out.println("*MODEM SOUND* updated the race parameters");
        updateTrashRace = true;
    }

    public void updateWeight() {
        System.out.println("*MODEM SOUND* updated the weight parameters");
        updateWeight = true;
    }

    public void updatePieChart() {
        System.out.println("*MODEM SOUND* updated the pie chart");
        updatePie = true;
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
                y5Pos -= 7.175f;
                height5 += 4.53f;
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x5Pos, y5Pos, width5, height5);

            } else if (counter >= 100 && counter < 107) {

                y3Pos -= 8.24f;
                height3 -= 3.56f;
                y5Pos -= 7.175f;
                height5 += 4.53f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x5Pos, y5Pos, width5, height5);


            } else if (counter >= 107 && counter < 109) {

                x5Pos -= 24.52f;

                g.fillRect(x5Pos, y5Pos, width5, height5);

            } else if (counter >= 109 && counter < 116) {

                x5Pos -= 24.52f;
                y5Pos = 787.45f;
                g.fillRect(x5Pos, y5Pos, width5, height5);

            } else if (counter >= 116 && counter < 126) {
                x5Pos -= 24.52f;
                y5Pos = 767.3f;
                g.fillRect(x5Pos, y5Pos, width5, height5);

            } else if (counter >= 126 && counter < 130) {

                x5Pos -= 25.52f;
                y6Pos -= 37.03f;


                g.fillRect(x5Pos, y5Pos, width5, height5);
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

                xPos = 131.9f;
                yPos = 625.1f;
                width = 44.4f;
                height = 48.1f;

            } else if (counter >= 135 && counter < 151) {

                width += 27.99f;
                width7 += 20.325f;

                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xPos, yPos, width, height);

                x2Pos = 592.95f;
                y2Pos = 669.8f;
                width2 = 8.1f;
                height2 = 52.25f;

                x3Pos = 592.95f;
                y3Pos = 715.45f;
                width3 = 8.1f;
                height3 = 6.65f;

                x4Pos = 1317.5f;
                y4Pos = 711.7f;
                width4 = 7f;
                height4 = 27.7f;

            } else if (counter >= 151 && counter < 152) {
                y2Pos += 11.4125f;
                height2 -= 11.4f;
                width3 += 13.3625f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);

                updateTrashRace();
            } else if (counter >= 152 && counter < 155) {
                y2Pos += 11.4125f;
                height2 -= 11.4f;
                width3 += 13.3625f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);

                updateTrashRace = false;
            } else if (counter >= 155 && counter < 159) {
                width3 += 13.3625f;
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(xPos, yPos, width, height);

            } else if (counter >= 159 && counter < 168) {

                x3Pos += 77.13f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x3Pos, y3Pos, width3, height3);

            } else if (counter >= 168 && counter < 172) {

                width3 -= 20.1875;
                x3Pos += 21.9f;
                height4 += 7.49f;
                y4Pos -= 10.88f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);

            } else if (counter >= 172 && counter < 176) {

                height4 -= 13.05f;
                widthWeight += 46.48f;
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xPos, yPos, width, height);

            } else if (counter >= 176 && counter < 182) {

                widthWeight += 46.48f;
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);

                x2Pos = 1267.6f;
                y2Pos = 640.55f;
                width2 = 29.35f;
                height2 = 6.95f;

                x3Pos = 624.35f;
                y3Pos = 640.55f;
                width3 = 29.35f;
                height3 = 6.95f;

                x6Pos = 1330.3f;
                y6Pos = 628.2f;
                width6 = 7f;
                height6 = 107.8f;

            } else if (counter >= 182 && counter < 183) {

                y2Pos -= 6.56f;
                y3Pos -= 6.56f;
                y6Pos -= 20.66;
                height2 += 6.75f;
                height3 += 6.75f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                x7Pos = 1337.3f;
                y7Pos = 408.25f;
                width7 = 6.15f;
                height7 = 100f;

                updateWeight();
            } else if (counter >= 183 && counter < 191) {

                y2Pos -= 6.56f;
                y3Pos -= 6.56f;
                y6Pos -= 20.66;
                height2 += 6.75f;
                height3 += 6.75f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                updateWeight = false;
            } else if (counter >= 191 && counter < 195) {

                y2Pos -= 6.56f;
                y3Pos -= 6.56f;
                y6Pos -= 20.66;
                height2 += 6.75f;
                height3 += 6.75f;
                width7 += 31.27f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

            } else if (counter >= 195 && counter < 198) {

                y2Pos -= 6.56f;
                y3Pos -= 6.56f;
                height2 += 6.75f;
                height3 += 6.75f;
                width7 += 31.27f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

            } else if (counter >= 198 && counter < 215) {
                y2Pos -= 16f;
                y3Pos -= 16f;
                x7Pos += 4.56f;

                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x7Pos, y7Pos, width7, height7);


                x4Pos = 1266.75f;
                y4Pos = 268.8f;
                width4 = 115f;
                height4 = 5.25f;

                x5Pos = 537.35f;
                y5Pos = 268.8f;
                width5 = 115f;
                height5 = 5.25f;

            } else if (counter >= 215 && counter < 227) {

                height2 -= 9.22f;
                height3 -= 9.22f;
                x4Pos -= 8.34f;
                x5Pos += 8.34f;
                x7Pos += 4.56f;

                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x7Pos, y7Pos, width7, height7);


            } else if (counter >= 227 && counter < 249) {
                x4Pos -= 8.34f;
                x5Pos += 8.34f;
                x7Pos += 4.52f;

                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x7Pos, y7Pos, width7, height7);

                x6Pos = 930.3f;
                y6Pos = 211.6f;
                width6 = 7f;
                height6 = 62.6f;

                x3Pos = 982.8f;
                y3Pos = 211.6f;
                width3 = 7f;
                height3 = 62.6f;


            } else if (counter >= 249 && counter < 256) {

                width4 -= 13.24;
                width5 -= 13.24;
                x5Pos += 13.5f;
                y6Pos += 7.69f;
                y3Pos += 7.69f;

                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);

                x2Pos = 762.3f;
                y2Pos = 310.2f;
                width2 = 402.05f;
                height2 = 2.4f;

            } else if (counter >= 256 && counter < 263) {
                y6Pos += 7.69f;
                y3Pos += 7.69f;
                height2 += 11.2f;

                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);


            } else if (counter >= 263 && counter < 282) {

                height2 += 11.2f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x7Pos, y7Pos, width7, height7);



                x4Pos = 811.15f;
                y4Pos = 309f;
                width4 = 298.4f;
                height4 = 298.4f;

            } else if (counter >= 282 && counter < 283) {

                x4Pos -= 12.86;
                y4Pos -= 12.86;
                width4 += 25.92;
                height4 += 25.92;

                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x7Pos, y7Pos, width7, height7);



                updatePieChart();

            } else if (counter >= 283 && counter < 297) {

                x4Pos -= 12.86;
                y4Pos -= 12.86;
                width4 += 25.92;
                height4 += 25.92;

                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x7Pos, y7Pos, width7, height7);



                updatePie = false;
            } else if (counter >= 297 && counter < 312) {

                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x7Pos, y7Pos, width7, height7);


            } else if (counter >= 312 && counter < 323) {

                Color alphacontrol = new Color(40, 118, 40, alpha);
                g.setColor(alphacontrol);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x7Pos, y7Pos, width7, height7);



                alpha -= 23;

            } else {

                reset();
                running = false;
            }
        }
    }

    /**
     * When there is time at some point
     *
     * @param g Slick Graphics element
     */
    void animationOverlay(Graphics g) {

        if (running) {
            g.setLineWidth(10f);

            if (counter >= 24 && counter < 44) {
                elipsePulse(g);
            } else if (counter >= 44 && counter < 64) {
                elipseReset(670.65f, 892.5f, 110.6f);
            } else if (counter >= 64 && counter < 84) {
                elipsePulse(g);
            } else if (counter >= 84 && counter < 104) {
                elipseReset(697.35f, 769.65f, 54.2f);
            } else if (counter >= 106 && counter < 116) {
                elipsePulse(g);
            } else if (counter >= 116 && counter < 126) {
                elipsePulseDeux(g);
                elipseReset(1370.45f, 410.15f, 88.6f);
            } else if (counter >= 150 && counter < 160) {
                rectPulse(g);
            } else if (counter >= 160 && counter < 161) {
                rectReset(1297.75f, 630.05f, 488.9f, 40.55f);
                elipseResetDeux(1498.45f, 436.2f, 38.1f);
            } else if (counter >= 179 && counter < 189) {
                rectPulse(g);
            } else if (counter >= 194 && counter < 197) {
                elipsePulse(g);
                rectReset(1570.35f, 411.5f, 224.4f, 92.75f);
            } else if (counter >= 197 && counter < 204) {
                elipsePulse(g);
                elipsePulseDeux(g);
            } else if (counter >= 204 && counter < 208) {
                elipsePulseDeux(g);
            } else if (counter >= 249 && counter < 259) {
                rectPulse(g);
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

    boolean isUpdateTrashRace() {
        return updateTrashRace;
    }

    boolean isUpdatePie() {
        return updatePie;
    }

    public boolean isUpdateWeight() {
        return updateWeight;
    }


    /***************************************
     * Reset values for the animation
     ***************************************/
    private void reset() {

        counter = 0;
        alpha = 255;

        alphaOverlay = 255;
        alphaOverlayDeux = 255;
        alphaOverlayR = 255;

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

        xWeightPos = 1296.70f; //HERE
        yWeightPos = 628.1f;
        widthWeight = 28.2f;
        heightWeight = 45.7f;



        pX = 670.65f;
        pY = 892.5f;
        radius = 110.6f;

        pX2 = 424.15f;
        pY2 = 772.45f;
        radius2 = 52.1f;

        pXr = 134.1f;
        pYr = 630.05f;
        widthRP = 488.9f;
        heightRP = 40.55f;
    }

    private void elipsePulse(Graphics g) {
        Color overLayColor = new Color(40, 118, 40, alphaOverlay);

        pX -= 1.75f;
        pY -= 1.75f;
        radius += 3.5f;
        g.setLineWidth(10f);
        g.setColor(overLayColor);
        g.drawOval(pX, pY, radius, radius);
        alphaOverlay -= 25.37f;
    }

    private void elipsePulseDeux(Graphics g) {
        Color overLayColor2 = new Color(40, 118, 40, alphaOverlayDeux);

        pX2 -= 1.75f;
        pY2 -= 1.75f;
        radius2 += 3.5f;
        g.setLineWidth(10f);
        g.setColor(overLayColor2);
        g.drawOval(pX2, pY2, radius2, radius2);
        alphaOverlayDeux -= 25.37f;
    }

    private void elipseReset(float x, float y, float radius) {
        alphaOverlay = 255;

        this.pX = x;
        this.pY = y;
        this.radius = radius;
    }

    private void elipseResetDeux(float x, float y, float radius) {
        alphaOverlayDeux = 255;

        this.pX2 = x;
        this.pY2 = y;
        this.radius2 = radius;
    }

    private void rectPulse(Graphics g) {
        Color overLayColorR = new Color(40, 118, 40, alphaOverlayR);

        pXr -= 2;
        pYr -= 2;
        widthRP += 4;
        heightRP += 4;
        g.setColor(overLayColorR);
        g.setLineWidth(5f);
        g.drawRect(pXr, pYr, widthRP, heightRP);
        alphaOverlayR -= 25.37f;
    }

    private void rectReset(float x, float y, float width, float height) {
        alphaOverlayR = 255;

        this.pXr = x;
        this.pYr = y;
        this.widthRP = width;
        this.heightRP = height;
    }

}

