package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Class for Cardboard Animation
 * Created by Thomas Macdonald on 04-05-2016.
 */
class CardboardAnim {


    private static final Color cardblue = new Color(73, 73, 163, 255);

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

    private int alpha = 255;


    CardboardAnim() {

        //STARTING POSITION
        reset();

    }

    public void updateTrashRace() {
        System.out.println("*MODEM SOUND* updated the race parameters");
    }

    public void updateWeight() {
        System.out.println("*MODEM SOUND* updated the weight parameters");
    }

    public void updatePieChart() {
        System.out.println("*MODEM SOUND* updated the pie chart");
    }

    /**************************************
     * Hope You Like Pasta!
     * Animation Control for the visual impulse for the flammable garbage
     *
     * @param g Slick Graphics Element
     **************************************/

    void animation(Graphics g) {

        g.setColor(cardblue);

        if (running) {

            counter++;

            if (counter < 6) {

                yPos -= 10.62f;

                g.fillRect(xPos, yPos, width, height);

            } else if (counter >= 6 && counter < 9) {

                height -= 36.93f;
                width2 += 36.77f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);

            } else if (counter >= 9 && counter < 17) {

                x2Pos += 26.67f;
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

                x5Pos += 24.52f;

                g.fillRect(x5Pos, y5Pos, width5, height5);

            } else if (counter >= 109 && counter < 116) {

                x5Pos += 24.52f;
                y5Pos = 787.45f;
                g.fillRect(x5Pos, y5Pos, width5, height5);

            } else if (counter >= 116 && counter < 126) {
                x5Pos += 24.52f;
                y5Pos = 767.3f;
                g.fillRect(x5Pos, y5Pos, width5, height5);

            } else if (counter >= 126 && counter < 130) {

                x5Pos += 25.52f;
                y6Pos -= 37.03f;


                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);


            } else if (counter >= 130 && counter < 135) {

                y6Pos -= 7f;
                height6 -= 13.08f;
                x7Pos -= 22.39f;
                width7 += 22.39f;

                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);

            } else if (counter >= 135 && counter < 151) {

                width7 += 21.1f;
                x7Pos -= 21.1f;

                g.fillRect(x7Pos, y7Pos, width7, height7);

                xPos = 1318.05f;
                yPos = 628.2f;
                width = 7f;
                height = 44.2f;

                x2Pos = 1441.7f;
                y2Pos = 632.9f;
                width2 = 7f;
                height2 = 39.05f;

            } else if (counter >= 151 && counter < 155) {

                yPos -= 32.08f;
                height += 7.95f;
                height2 += 15.43f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);

                g.fillRect(x7Pos, y7Pos, width7, height7);

                x3Pos = 1435.9f;
                y3Pos = 721.3f;
                width3 = 6.8f;
                height3 = 41.7f;

                updateWeight();

            } else if (counter >= 155 && counter < 160) {

                yPos -= 32.08f;
                height += 7.95f;
                y2Pos += 29.475f;
                height2 -= 29.475f;
                x3Pos -= 11.94f;
                width3 += 11.94f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x7Pos, y7Pos, width7, height7);

            } else if (counter >= 160 && counter < 163) {

                yPos -= 32.08f;
                height += 7.95f;
                x3Pos -= 11.94f;
                width3 += 11.94f;
                widthWeight += 14.31f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

            } else if (counter >= 163 && counter < 175) {

                x3Pos -= 71.93f;
                widthWeight += 14.31f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                x4Pos = 471.7f;
                y4Pos = 735.25f;
                width4 = 7f;
                height4 = 12.45f;
            } else if (counter >= 175 && counter < 179) {

                width3 -= 19f;
                y4Pos -= 16.7f;
                height4 += 16.7;
                xWeightPos += 9.01f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                x5Pos = 452.15f;
                y5Pos = 662.75f;
                width5 = 47.2f;
                height5 = 10.85f;

            } else if (counter >= 179 && counter < 184) {

                height4 -= 14.61;
                width5 += 55.63f;
                x5Pos -= 40.15f;
                y5Pos -= 3.8375f;
                height5 += 3.8375f;
                xWeightPos += 9.01f;

                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                x6Pos = 131.75f;
                y6Pos = 624.4f;
                width6 = 5;
                height6 = 49f;

            } else if (counter >= 184 && counter < 187) {

                width5 += 55.63f;
                x5Pos -= 40.15f;
                height5 += 3.8375f;
                y5Pos -= 3.8375f;
                xWeightPos += 9.01f;

                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

            } else if (counter >= 187 && counter < 194) {

                width6 += 69.53f;
                xWeightPos += 9.01f;

                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);


                x2Pos = 1289f;
                y2Pos = 653.8f;
                width2 = 86.8f;
                height2 = 5.25f;


                x3Pos = 508.7f;
                y3Pos = 652.55f;
                width3 = 115f;
                height3 = 8.2f;

            } else if (counter >= 194 && counter < 197) {

                xWeightPos += 9.01f;
                x2Pos -= 8.85f;
                x3Pos += 8.85f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);

                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                x4Pos = 1254.55f;
                y4Pos = 653.35f;
                width4 = 7f;
                height4 = 5.95f;

                xRacePos = 657.35f;
                yRacePos = 653.35f;
                widthRace = 7;
                heightRace = 21.4f;

                updateTrashRace();

            } else if (counter >= 197 && counter < 202) {

                xWeightPos += 9.01f;
                width2 -= 7.75f;
                width3 -= 7.75f;
                x3Pos += 11f;
                height4 += 7.79f;
                y4Pos -= 7.79f;
                heightRace += 7.79f;
                yRacePos -= 7.79f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);


                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

            } else if (counter >= 202 && counter < 212) {

                width2 -= 7.75f;
                width3 -= 7.75f;
                x3Pos += 7.75f;
                height4 += 7.79f;
                y4Pos -= 7.79f;
                heightRace += 7.79f;
                yRacePos -= 7.79f;

                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
            } else if (counter >= 212 && counter < 229) {

                y4Pos -= 14.78f;
                yRacePos -= 14.78f;

                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                xPos = 1254.75f;
                yPos = 288.6f;
                width = 7.65f;
                height = 5.25f;

                x2Pos = 657f;
                y2Pos = 288.6f;
                width2 = 7.65f;
                height2 = 5.25f;

            } else if (counter >= 229 && counter < 240) {

                height4 -= 10f;
                heightRace -= 10f;
                xPos -= 6.97f;
                width += 6.97f;
                width2 += 6.97;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

            } else if (counter >= 240 && counter < 245) {

                xPos -= 34.11f;
                x2Pos += 34.11f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);

                x4Pos = 1016.4f;
                y4Pos = 286.3f;
                width4 = 7f;
                height4 = 8.9f;

                xRacePos = 895.3f;
                yRacePos = 285f;
                widthRace = 7;
                heightRace = 8.9f;

            } else if (counter >= 245 && counter < 249) {

                width -= 15.44f;
                width2 -=15.44f;
                x2Pos += 15.44f;
                height4 += 6.71f;
                heightRace += 6.71f;

                g.fillRect(xPos, yPos, width, height);
                g.fillRect(x2Pos, y2Pos, width2, height2);
                g.fillRect(x5Pos, y5Pos, width5, height5);
                g.fillRect(x6Pos, y6Pos, width6, height6);
                g.fillRect(x7Pos, y7Pos, width7, height7);
                g.fillRect(xWeightPos, yWeightPos, widthWeight, heightWeight);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);


                x3Pos = 802.3f;
                y3Pos = 307.2f;
                width3 = 312.05f;
                height3 = 2.4f;

            } else if (counter >= 249 && counter < 252) {

                height3 += 11.2f;
                height4 += 6.71f;
                heightRace += 6.71f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);



            } else if (counter >= 252 && counter < 277) {

                y4Pos +=3.63f;
                yRacePos += 3.63f;
                height3 += 11.2f;

                g.fillRect(x3Pos, y3Pos, width3, height3);
                g.fillRect(x4Pos, y4Pos, width4, height4);
                g.fillRect(xRacePos, yRacePos, widthRace, heightRace);

                xPos = 811.15f;
                yPos = 309f;
                width = 298.4f;
                height = 298.4f;

            } else if (counter >= 277 && counter < 292) {

                xPos -= 12.87;
                yPos -= 12.87;
                width += 25.92;
                height += 25.92;

                g.fillOval(xPos, yPos, width, height);

                updatePieChart();

            } else if (counter >= 292 && counter < 305) {

                g.fillOval(xPos, yPos, width, height);

            } else if (counter >= 305 && counter < 315) {

                Color alphacontrol = new Color(73, 73, 163, alpha);
                g.setColor(alphacontrol);
                g.fillOval(xPos, yPos, width, height);
                alpha -= 23;


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

        x3Pos = 1190.6f;
        y3Pos = 1093.35f;
        width3 = 7f;
        height3 = 115f;

        x4Pos = 1135f;
        y4Pos = 996.35f;
        width4 = 115f;
        height4 = 9.5f;

        x5Pos = 1161.65f;
        y5Pos = 851.4f;
        width5 = 61.75f;
        height5 = 9.3f;

        x6Pos = 1728.25f;
        y6Pos = 838.45f;
        width6 = 7f;
        height6 = 78.45f;

        x7Pos = 1744.7f;
        y7Pos = 625.9f;
        width7 = 44.4f;
        height7 = 48.1f;

        xWeightPos = 1324.55f;
        yWeightPos = 306f;
        widthWeight = 20.5f;
        heightWeight = 98.05f;

        xRacePos = 114.75f;
        yRacePos = 627.45f;
        widthRace = 16.85f;
        heightRace = 45.9f;

    }
}



