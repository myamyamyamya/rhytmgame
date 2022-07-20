package com.Jongyeol.RhytmChart;

public class Beat {
    private int x;
    private double time;

    public double getBeat() {
        return beat;
    }

    public void setBeat(double beat) {
        this.beat = beat;
    }

    private double beat;

    public int getx() {
        return x;
    }

    public void setx(int x) {
        this.x = x;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Beat(int x, double time) {
        super();
        this.x = x;
        this.time = time;
    }
}
