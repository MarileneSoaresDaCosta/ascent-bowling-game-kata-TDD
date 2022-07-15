package com.galvanize.bowling;

public class Game {
    int frame = 1;
    int rollNumber = 1;
    int score = 0;
    int frameScore = 0;
    //    boolean spare = false;
    int bonusCounter = 0;
    int strikes = 0;

    public int getScore() {

        return score;
    }

    public int newRoll(int pins) {

        if (frame == 10) {
            score += pins;
        } else {
            // on first roll
            if (rollNumber == 1) {
                if (bonusCounter > 0) {
                    this.frameScore = 2 * pins;
                    if (pins != 10) {
                        this.bonusCounter--;
                        rollNumber++;
                    } else { // all strikes
                        this.bonusCounter = 2;
                        if (strikes < 2) {
                            strikes++;
                        }
                        if (strikes == 1 || frame == 10) {
                            this.frameScore = 2 * pins;
                        } else if (strikes == 2) {
                            this.frameScore = 3 * pins;
                        } else {
                            this.frameScore = pins;
                        }

                        score += frameScore;
                        this.rollNumber = 1;
                        frame++;
                    }


                } else if (pins == 10) {
                    this.bonusCounter = 2;
                    if (strikes < 2) {
                        strikes++;
                    }
                    if (strikes == 1) {
                        this.frameScore = 1 * pins;
                    } else if (strikes == 2) {
                        this.frameScore = 3 * pins;
                    } else {
                        this.frameScore = pins;
                    }

                    score += frameScore;
                    this.rollNumber = 1;

                } else {
                    this.frameScore = pins;
                    this.rollNumber++;
                }
                // on second roll
            } else {
                if (bonusCounter > 0) {
                    this.frameScore = 2 * pins;
                    if (pins != 10) {
                        this.bonusCounter--;
                    }
                } else {
                    this.frameScore += pins;
                }
                rollNumber = 1;
                frame++;
                score += frameScore;
                if (frameScore == 10) {
                    bonusCounter++;
                }
            }

            System.out.println("frame: " + frame);
            System.out.println("score: " + score);
            System.out.println("frameScore: " + frameScore);
            System.out.println("roll Number: " + rollNumber);
            System.out.println("bonus Counter: " + bonusCounter);
            System.out.println("strikes: " + strikes);
            System.out.println("-------------------");

        }
        return 5;
    }
}
