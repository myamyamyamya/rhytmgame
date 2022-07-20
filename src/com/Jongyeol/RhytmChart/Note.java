package com.Jongyeol.RhytmChart;

import javax.swing.*;
import java.awt.*;

public class Note extends Thread {
    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../../../resource/noteBasic.png")).getImage();
    private int notex, x, y = 0;
    private boolean proceeded = true;
    public int getNotex() {
        return notex;
    }
    public boolean isProceeded() {
        return proceeded;
    }
    public void close() {
        proceeded = false;
    }

    public double Beat;
    public Note(int x) {
        notex = x;
        if(x==1) {
            this.x = 570;
        } else if (x==2) {
            this.x = 690;
        } else if (x==3) {
            this.x = 810;
        } else if (x==4) {
            this.x = 930;
        }
    }
    public void screenDraw(Graphics2D g) {
        g.drawImage(noteBasicImage, x, y, null);
    }
    public void drop() {
        y += Main.NOTE_SPEED;
    }
    @Override
    public void run() {
        try {
            while (true){
                drop();
                if(proceeded) {
                    Thread.sleep(Main.SLEEP_TIME);
                } else {
                    interrupt();
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void judge(int input) {
        System.out.println(input + " " + Beat);
        close();
    }
}
