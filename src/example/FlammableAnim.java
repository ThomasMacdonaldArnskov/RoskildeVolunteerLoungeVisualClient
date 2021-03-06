package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**************************************
 * Class that handles the animation pulse for
 * flammable garbage collected.
 * Created by Thomas Macdonald on 03-05-2016.
 *************************************/

class FlammableAnim {

    private static final Color flamred = new Color(198, 55, 32, 255);

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
    private float xRacePos, yRacePos, widthRace, heightRace;

    //Overlay elements
    private float pX, pY, radius;
    private float pX2, pY2, radius2;
    private float pXr, pYr, widthRP, heightRP;


    private int alpha = 255;
    private int alphaOverlay = 255;
    private int alphaOverlayDeux = 255;
    private int alphaOverlayR = 255;


    FlammableAnim() {

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

        g.setColor(flamred);

        if (running) {

            counter++;

            if (counter < 10) {

                yPos -= 7.54f;

                g.fillRect(xPos, yPos, width, height);

            } else if (counter >= 10 && counter < 24) {

                yPos -= 8.207f;
                height2 += 7.5;
                y2Pos -= 7.5f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);

            } else if (counter >= 24 && counter < 90) {

                g.fillRect(x2Pos, y2Pos, width2, height2);

            } else if (counter >= 90 && counter < 94) {

                y2Pos -= 6.3f;

                g.fillRect(x2Pos, y2Pos, width2, height2);

                width = 14f;
                height = 10f;
                xPos = 952.6f;
                yPos = 855.6f;

            } else if (counter >= 94 && counter < 99) {

                height2 -= 22.6f;
                width += 20.2f;
                xPos -= 10.1f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(xPos, yPos, width, height);

            } else if (counter >= 99 && counter < 110) {

                width += 11.4f;
                xPos -= 5.7f;

                g.fillRect(xPos, yPos, width, height);

                x2Pos = 844.65f;
                y2Pos = 860.45f;
                width2 = 115f;
                height2 = 5.5f;

            } else if (counter >= 110 && counter < 117) {

                x2Pos -= 22.37f;
                x3Pos += 24.05f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);

                xPos = 1295.75f;
                yPos = 806.6f;
                width = 7f;
                height = 58.8f;

            } else if (counter >= 117 && counter < 120) {

                yPos += 15.2f;
                x2Pos -= 22.37f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);

                x3Pos = 617.45f;
                y3Pos = 803.25f;
                width3 = 7f;
                height3 = 62.2f;

            } else if (counter >= 120 && counter < 125) {

                x2Pos -= 29.975;
                yPos += 21.275;
                y3Pos += 10.2f;
                width4 += 22.7375f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);

            } else if (counter >= 125 && counter < 133) {

                y3Pos += 10.2f;
                x4Pos += 25.1625f;
                x5Pos -= 13.0;
                width5 += 12.99f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x4Pos, y4Pos, width4, height4);

            } else if (counter >= 133 && counter < 143) {

                x5Pos -= 14.25;
                x4Pos += 20.1625f;

                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x4Pos, y4Pos, width4, height4);

            } else if (counter >= 143 && counter < 147) {

                x5Pos -= 14.25;
                x4Pos += 25.1625f;
                y6Pos -= 14.17f;

                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x6Pos, y6Pos, width6, height6);


                xPos = 108.85f;
                yPos = 895.95f;
                width = 7f;
                height = 115f;

            } else if (counter >= 147 && counter < 162) {

                x5Pos -= 14.25;
                y6Pos -= 14.17f;
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);

            } else if (counter >= 162 && counter < 182) {

                yPos -= 12.78f;
                x5Pos -= 9.62;
                y6Pos -= 14.17f;
                xWeightPos -= 24.61f;
                widthWeight += 23.755f;

                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                x2Pos = 0.75f;
                y2Pos = 198.25f;
                width2 = 115f;
                height2 = 5.25f;

                x4Pos = 1805.55f;
                y4Pos = 198.25f;
                width4 = 115f;
                height4 = 5.25f;

                x3Pos = 1341.45f;
                y3Pos = 631.55f;
                width3 = 7f;
                height3 = 69.3f;

            } else if (counter >= 182 && counter < 183) {

                yPos -= 28.78f;
                y3Pos -= 8.27f;
                x5Pos -= 13.62;
                y6Pos -= 14.17f;
                widthRace += 14.85f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

                updateWeight();

            } else if (counter >= 183 && counter < 193) {

                yPos -= 28.78f;
                y3Pos -= 8.27f;
                x5Pos -= 13.62;
                y6Pos -= 14.17f;
                widthRace += 14.85f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

                updateWeight = false;

            } else if (counter >= 193 && counter < 200) {

                yPos -= 18.78f;
                y3Pos -= 8.27f;
                x4Pos -= 17.5f;
                x5Pos -= 13.62f;
                y6Pos -= 14.17f;
                width7 += 10.02f;
                xRacePos += 0.52f;
                widthRace += 14.85f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

            } else if (counter >= 200 && counter < 205) {

                yPos -= 18.78f;
                x2Pos += 20.925f;
                x4Pos -= 17.5f;
                width7 += 10.02f;
                xRacePos += 0.52f;
                widthRace += 14.85f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

            } else if (counter >= 205 && counter < 214) {

                x2Pos += 20.925f;
                x4Pos -= 18.6f;
                width7 += 10.02f;
                xRacePos += 1.1f;
                widthRace += 14.85f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

                xPos = 945.6f;
                yPos = 88.5f;
                width = 7;
                height = 115;

            } else if (counter >= 214 && counter < 215) { //HERE IT GOES UP THE WEIGHTS

                x2Pos += 20.925f;
                x4Pos -= 18.6f;
                x7Pos += 8.44f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

                updateTrashRace();

            } else if (counter >= 215 && counter < 240) {

                x2Pos += 20.925f;
                x4Pos -= 18.6f;
                x7Pos += 8.44f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                updateTrashRace = false;

            } else if (counter >= 240 && counter < 252) {

                x2Pos += 10.55f;
                width2 -= 9.73f;
                yPos += 10.03f;
                width4 -= 9.95f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect((xPos + 19.35f), yPos, width, height);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

                x3Pos = 762.3f;
                y3Pos = 310.2f;
                width3 = 402.05f;
                height3 = 2.4f;

            } else if (counter >= 252 && counter < 266) {

                yPos += 10.03f;
                height3 += 11.2f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect((xPos + 19.35f), yPos, width, height);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

            } else if (counter >= 266 && counter < 280) {

                height3 += 11.2f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                x4Pos = 762.3f;
                y4Pos = 310.2f;
                width4 = 402.05f;
                height4 = 298.4f;

            } else if (counter >= 280 && counter < 281) {

                x4Pos -= 12.86;
                y4Pos -= 12.86;
                width4 += 25.92;
                height4 += 25.92;

                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);


                updatePieChart();

            } else if (counter >= 281 && counter < 297) {

                x4Pos -= 12.86;
                y4Pos -= 12.86;
                width4 += 25.92;
                height4 += 25.92;

                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);


                updatePie = false;

            } else if (counter >= 297 && counter < 312) {

                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);


            } else if (counter >= 312 && counter < 323) {

                Color alphacontrol = new Color(198, 55, 32, alpha);
                g.setColor(alphacontrol);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);


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
                elipseReset(903.85f, 892.85f, 110.6f);
            } else if (counter >= 64 && counter < 84) {
                elipsePulse(g);
            } else if (counter >= 84 && counter < 104) {
                elipseReset(524.95f, 919.35f, 38);
            } else if (counter >= 126 && counter < 132) {
                elipsePulseDeux(g);
            } else if (counter >= 132 && counter < 140) {
                elipsePulse(g);
                elipseResetDeux(1611.15f, 907.15f, 62.15f);
            } else if (counter >= 140 && counter < 143) {
                elipsePulse(g);
                elipsePulseDeux(g);
            } else if (counter >= 143 && counter < 150) {
                elipsePulseDeux(g);
                elipseReset(246.15f, 907.15f, 62.15f);
            } else if (counter >= 153 && counter < 163) {
                elipsePulse(g);
            } else if (counter >= 163 && counter < 165) {
                elipseReset(1370.85f, 512.85f, 88.6f);
                elipseResetDeux(1498.45f, 536.2f, 38.1f);
            } else if (counter >= 183 && counter < 193) {
                rectPulse(g);
            } else if (counter >= 205 && counter < 210) {
                elipsePulse(g);
                rectReset(134.1f, 630.05f, 488.9f, 40.55f);
            } else if (counter >= 210 && counter < 213) {
                elipsePulse(g);
                elipsePulseDeux(g);
            } else if (counter >= 213 && counter < 220) {
                elipsePulse(g);
                elipsePulseDeux(g);
                rectPulse(g);
            } else if (counter >= 220 && counter < 222) {
                elipseReset(811.05f, 309f, 298.6f);
                rectReset(1570.35f, 515.3f, 216.35f, 89.4f);
            } else if (counter >= 240 && counter < 247) {
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

        x2Pos = 902.6f;
        y2Pos = 996.35f;
        width2 = 115.0f;
        height2 = 9.5f;

        x3Pos = 1015f;
        y3Pos = 860.7f;
        width3 = 115.0f;
        height3 = 5.5f;

        x4Pos = 1302.4f;
        y4Pos = 902.35f;
        width4 = 3.95f;
        height4 = 72.25f;

        x5Pos = 606.55f;
        y5Pos = 897.1f;
        width5 = 11.05f;
        height5 = 78.25f;

        x6Pos = 1804.15f;
        y6Pos = 915.05f;
        width6 = 7f;
        height6 = 115f;

        x7Pos = 1348.2f;
        y7Pos = 507.2f;
        width7 = 20.4f;
        height7 = 98.3f;

        xWeightPos = 1788.4f;
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

        pX2 = 1356.65f;
        pY2 = 919.35f;
        radius2 = 38f;

        pXr = 1297.75f;
        pYr = 630.05f;
        widthRP = 488.9f;
        heightRP = 40.55f;
    }

    private void elipsePulse(Graphics g) {
        Color overLayColor = new Color(198, 55, 32, alphaOverlay);

        pX -= 1.75f;
        pY -= 1.75f;
        radius += 3.5f;
        g.setLineWidth(10);
        g.setColor(overLayColor);
        g.drawOval(pX, pY, radius, radius);
        alphaOverlay -= 25.37f;
    }

    private void elipsePulseDeux(Graphics g) {
        Color overLayColor2 = new Color(198, 55, 32, alphaOverlayDeux);

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
        Color overLayColorR = new Color(198, 55, 32, alphaOverlayR);

        pXr -= 1.75;
        pYr -= 1.75;
        widthRP += 3.5;
        heightRP += 3.5;
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
