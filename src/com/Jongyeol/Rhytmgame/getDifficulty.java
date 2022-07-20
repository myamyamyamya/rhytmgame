package com.Jongyeol.Rhytmgame;

public class getDifficulty {
    public static String getDifficulty(int difficulty) {
        if(difficulty == 1) {
            return "Easy";
        }
        if(difficulty == 2) {
            return "Hard";
        }
        return null;
    }
}
