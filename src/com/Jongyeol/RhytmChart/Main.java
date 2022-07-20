package com.Jongyeol.RhytmChart;

public class Main {
    public static final int SCREEN_WIDTH = 1600;
    public static final int SCREEN_HEIGHT = 900;
    public static final int NOTE_SPEED = 10;
    public static final int SLEEP_TIME = 5;
    public static final double REAL_NOTE_SPPED = (double) NOTE_SPEED / SLEEP_TIME;
    public static DynamicBeat dynamicBeat;
    public static void main(String[] args){
        System.out.println(REAL_NOTE_SPPED);
        dynamicBeat = new DynamicBeat();
    }
}
