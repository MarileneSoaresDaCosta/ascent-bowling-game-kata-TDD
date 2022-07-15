package com.galvanize.bowling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    public void getScoreReturnsZero(){
        // set up
        Game newGame = new Game();

        // enact
        int expected = 0;
        int actual = newGame.getScore();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void newRollAcceptsNumOfPinsKnockedDown(){
        // set up
        Game newGame = new Game();

        // enact
        int expected = 5;
        int actual = newGame.newRoll(5);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void scoreOfZeroAfterRolling20Gutters(){
        // set up
        Game newGame = new Game();

        // enact
        int expected = 0;

        for (int i = 0; i < 20; i++) {
            newGame.newRoll(0);
        }

        int actual = newGame.getScore();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void scoreOfTwentyAfterRolling20Ones(){
        // set up
        Game newGame = new Game();

        // enact
        int expected = 20;

        for (int i = 0; i < 20; i++) {
            newGame.newRoll(1);
        }

        int actual = newGame.getScore();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void score16WithRollsFiveFiveThreeAndGutters(){
        // set up
        Game newGame = new Game();

        // enact
        int expected = 16;

        // first 3 rolls
        newGame.newRoll(5);
        newGame.newRoll(5);
        newGame.newRoll(3);

        for (int i = 0; i < 17; i++) {
            newGame.newRoll(0);
        }

        int actual = newGame.getScore();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void score22WithRollsTenThreeThreeAndGutters(){
        // set up
        Game newGame = new Game();

        // enact
        int expected = 22;

        // one strike
        newGame.newRoll(10);

        // first 3 rolls
        newGame.newRoll(3);
        newGame.newRoll(3); //change back to 3 after testing

        for (int i = 0; i < 16; i++) {
            newGame.newRoll(0);
        }

        int actual = newGame.getScore();

        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void score300WithPerfectGame(){
        // set up
        Game newGame = new Game();

        // enact
        int expected = 300;

        for (int i = 0; i < 12; i++) {
            newGame.newRoll(10);
        }

        int actual = newGame.getScore();

        // assert
        assertEquals(expected, actual);
    }

}