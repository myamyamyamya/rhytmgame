package com.Jongyeol.Rhytmgame;

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
        if(y>=720 + Main.REAL_NOTE_SPPED * 82 - Main.REAL_NOTE_SPPED * 12) {
        //if(y>=680) {
            //new Music("Key", false).start();
            System.out.println("Miss");
            DynamicBeat.game.Miss++;
            close();
        }
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
    public void judge() {
        if(y>=720 + Main.REAL_NOTE_SPPED * 62 - Main.REAL_NOTE_SPPED * 12) {
            System.out.println("Very Late");
            DynamicBeat.game.score += 10;
            DynamicBeat.game.VeryLate++;
            close();
        } else if(y >= 720 + Main.REAL_NOTE_SPPED * 42 - Main.REAL_NOTE_SPPED * 12) {
            System.out.println("Late");
            DynamicBeat.game.score += 30;
            DynamicBeat.game.Late++;
            close();
        } else if(y >= 720 + Main.REAL_NOTE_SPPED * 21 - Main.REAL_NOTE_SPPED * 12) {
            System.out.println("Little Late");
            DynamicBeat.game.score += 60;
            DynamicBeat.game.LittleLate++;
            close();
        } else if(y >= 720 - Main.REAL_NOTE_SPPED * 12) {
            System.out.println("Perfect");
            DynamicBeat.game.score += 100;
            DynamicBeat.game.Perfect++;
            close();
        } else if(y >= 720 - Main.REAL_NOTE_SPPED * 21 - Main.REAL_NOTE_SPPED * 12) {
            System.out.println("Little Early");
            DynamicBeat.game.score += 60;
            DynamicBeat.game.LittleEarly++;
            close();
        } else if(y >= 720 - Main.REAL_NOTE_SPPED * 42 - Main.REAL_NOTE_SPPED * 12) {
            System.out.println("Early");
            DynamicBeat.game.score += 30;
            DynamicBeat.game.Early++;
            close();
        } else if(y >= 720 - Main.REAL_NOTE_SPPED * 62 - Main.REAL_NOTE_SPPED * 12) {
            System.out.println("Very Early");
            DynamicBeat.game.score += 10;
            DynamicBeat.game.VeryEarly++;
            close();
        }
    }
}
