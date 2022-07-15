package com.galvanize.bowling;

public class Game {
    int frame = 1;
    int rollNumber = 1;
    int score = 0;
    int frameScore = 0;
    // bonusCounter keeps track of spares (or strikes) and of how many rolls get the 'bonus' applied (pins * 2)
    // max bonusCounter = 2
    int bonusCounter = 0;
    // "strikes" keeps track of strike and of how many rolls get the 'bonus' applied (pins * 2 Or pins * 3)
    // max strikes = 2
    int strikes = 0;

    public int getScore() {
        return score;
    }

    public int newRoll(int pins) {
//        System.out.println("frame: " + frame);
//        System.out.println("roll Number: " + rollNumber);

        // special case: last frame
        if (frame == 10 && pins == 10) {
            score += pins;
            if (rollNumber < 3) {
                score += pins;
            }
            rollNumber++;
        } else {
            // on first roll
            if (rollNumber == 1) {
                if (bonusCounter > 0) { // there was a spare; we used 1 or 0 bonus
                    this.frameScore = 2 * pins;
                    if (pins != 10) {
                        this.bonusCounter--;
                        rollNumber++;
                    } else { // there was a strike (pins == 10)
                        this.bonusCounter = 2;
                        if (strikes < 2) {
                            strikes++;
                        }
                        if (strikes == 1) {
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
                    // bonusCounter = 0, and we have a new strike
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
                    frame++;

                } else { // simple case, no strike
                    this.frameScore = pins;
                    this.rollNumber++;
                }
                // on second roll
            } else {
                if (bonusCounter > 0) {
                    this.frameScore += 2 * pins;
                    if (pins != 10) {
                        this.bonusCounter--;
                    }
                } else {
                    this.frameScore += pins;
                }
                rollNumber = 1;
                frame++;
                score += frameScore;
                if (frameScore == 10) { // got a spare
                    bonusCounter++;
                }
            }
        }

//        System.out.println("score: " + score);
//        System.out.println("frameScore: " + frameScore);
//
//        System.out.println("bonus Counter: " + bonusCounter);
//        System.out.println("strikes: " + strikes);
//        System.out.println("-------------------");
        return 5;
    }
}
