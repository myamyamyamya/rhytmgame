package com.Jongyeol.Rhytmgame;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game extends Thread{
    private Image gameInfo = new ImageIcon(Main.class.getResource("../../../resource/gameinfo.png")).getImage();
    private Image judgeline = new ImageIcon(Main.class.getResource("../../../resource/judgementline.png")).getImage();
    private ImageIcon noteRoute1 = new ImageIcon(Main.class.getResource("../../../resource/noteRoute.png"));
    private ImageIcon noteRoute2 = new ImageIcon(Main.class.getResource("../../../resource/noteRoute2.png"));
    private Image noteRoutew = noteRoute1.getImage();
    private Image noteRoutee = noteRoute1.getImage();
    private Image noteRouteu = noteRoute1.getImage();
    private Image noteRoutei = noteRoute1.getImage();
    private ImageIcon None = new ImageIcon(Main.class.getResource("../../../resource/none.png"));
    private ImageIcon Error1 = new ImageIcon(Main.class.getResource("../../../resource/Error.png"));
    private Image Error = None.getImage();
    private String titleName;
    private int difficulty;
    private String musicTitle;
    private Music gamemusic;
    private String ErrorMessage = "";
    private boolean game = false;
    int Miss = 0, Early = 0, VeryEarly = 0, LittleEarly = 0, Perfect = 0, LittleLate = 0, Late = 0, VeryLate = 0, score = 0;
    ArrayList<Note> noteList = new ArrayList<Note>();
    ArrayList<Beat> beatList = new ArrayList<Beat>();
    public Game(String titleName, int difficulty, String musicTitle) {
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gamemusic = new Music(this.musicTitle, false);
    }
    public void screenDraw(Graphics2D g) {
        g.drawImage(noteRoutew, 570, 50, null);
        g.drawImage(noteRoutee, 690, 50, null);
        g.drawImage(noteRouteu, 810, 50, null);
        g.drawImage(noteRoutei, 930, 50, null);
        g.drawImage(gameInfo, 0, 820, null);
        g.drawImage(judgeline, 0, 720, null);
        g.drawImage(Error, 504, 303, null);
        for(int i = 0; i < noteList.size(); i++){
            Note note = noteList.get(i);
            if(!note.isProceeded()){
                noteList.remove(i);
                i--;
            } else {
                note.screenDraw(g);
            }
        }
        g.setColor(Color.WHITE);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(titleName, 20, 880);
        g.drawString(getDifficulty.getDifficulty(difficulty), 1480, 880);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString(ErrorMessage, 520, 340);
        g.setFont(new Font("Elephant", Font.BOLD, 40));
        g.drawString(makenumber.makestring6number(score), 707, 880);
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.setColor(Color.DARK_GRAY);
        g.drawString("W", 600, 760);
        g.drawString("E", 725, 760);
        g.drawString("U", 845, 760);
        g.drawString("I", 975, 760);
    }
    public void pressw() {
        judge(1);
        noteRoutew = noteRoute2.getImage();
    }
    public void pressE() {
        judge(2);
        noteRoutee = noteRoute2.getImage();
    }
    public void pressU() {
        judge(3);
        noteRouteu = noteRoute2.getImage();
    }
    public void pressI() {
        judge(4);
        noteRoutei = noteRoute2.getImage();
    }
    public void releaseW() {
        noteRoutew = noteRoute1.getImage();
    }
    public void releaseE() {
        noteRoutee = noteRoute1.getImage();
    }
    public void releaseU() {
        noteRouteu = noteRoute1.getImage();
    }
    public void releaseI() {
        noteRoutei = noteRoute1.getImage();
    }
    @Override
    public void run() {
        dropNotes();
    }
    public void close() {
        if(game){
            gamemusic.close();
            System.out.println("Miss: " + Miss);
            System.out.println("VeryLate: " + VeryLate);
            System.out.println("Late: " + Late);
            System.out.println("LittleLate: " + LittleLate);
            System.out.println("Perfect: " + Perfect);
            System.out.println("LittleEarly: " + LittleEarly);
            System.out.println("Early: " + Early);
            System.out.println("VeryEarly: " + VeryEarly);
            System.out.println("Score: " + score);
            game = false;
            this.interrupt();
        }
    }
    public void dropNotes() {
        try {
            Scanner in = new Scanner(new File("C:/Rhytmgame/ChartData/" + musicTitle + "." + difficulty));
            String File = "";
            while (in.hasNextLine()) {
                File = File.concat(in.nextLine() + "\n");
            }
            String[] File2 = File.split("\n01000010 01100101 01100001 01110100 00100000 01010011 01110100 01100001 01110010 01110100\n");
            String[] File3 = File2[0].split("\n");
            Beat beat;
            int offset = -1;
            float bpm = -1;
            for(int i = 0; i < File3.length; i++) {
                if(File3[i].contains("offset: ")) {
                    offset = makenumber.makenumber(File3[i].replaceAll("offset: ", ""));
                    System.out.println("offset: " + offset);
                    if(offset < 0){
                        gamemusic.close();
                        Error = Error1.getImage();
                        ErrorMessage = "An error occurred in offset.";
                        Main.dynamicBeat.EbackButton.setVisible(true);
                    }
                }
                if(File3[i].contains("bpm: ")) {
                    bpm = makenumber.makefloat(File3[i].replaceAll("bpm: ", ""));
                    System.out.println("bpm : " + bpm);
                    if(bpm < 0){
                        gamemusic.close();
                        Error = Error1.getImage();
                        ErrorMessage = "An error occurred in bpm.";
                        Main.dynamicBeat.EbackButton.setVisible(true);
                    }
                }
            }
            if(offset == -1){
                gamemusic.close();
                Error = Error1.getImage();
                ErrorMessage = "An error occurred in offset.";
                Main.dynamicBeat.EbackButton.setVisible(true);
            }
            if(bpm == -1){
                gamemusic.close();
                Error = Error1.getImage();
                ErrorMessage = "An error occurred in bpm.";
                Main.dynamicBeat.EbackButton.setVisible(true);

            }
            double BEAT = 1 / (bpm / 60) * 4000;
            File3 = File2[1].split("\n");
            String[] File4;
            int X;
            double preTime = offset + 20 - ((double) 720 / Main.REAL_NOTE_SPPED);
            for(int i = 0; i < File3.length; i++) {
                if(File3[i].contains("bpm: ")) {
                    bpm = makenumber.makefloat(File3[i].replaceAll("bpm: ", ""));
                    System.out.println("bpm : " + bpm);
                    if(bpm < 0){
                        gamemusic.close();
                        Error = Error1.getImage();
                        ErrorMessage = "An error occurred in bpm.";
                        Main.dynamicBeat.EbackButton.setVisible(true);
                        break;
                    }
                    BEAT = 1 / (bpm / 60) * 4000;
                } else {
                    File4 = File3[i].split(" ");
                    X = makenumber.makenumber(File4[0]);
                    beat = new Beat(X, preTime);
                    beatList.add(beat);
                    double addtime = makenumber.makedouble(File4[1]);
                    if(addtime > 0){
                        preTime += BEAT / addtime;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
            gamemusic.close();
            Error = Error1.getImage();
            ErrorMessage = "File not found.";
            Main.dynamicBeat.EbackButton.setVisible(true);
        }
        int i = 0;
        game = true;
        gamemusic.start();
        while (i < beatList.size() && !isInterrupted()) {
            boolean dropped = false;
            if(beatList.get(i).getTime() <= gamemusic.getTime()) {
                Note note = new Note(beatList.get(i).getx());
                note.start();
                noteList.add(note);
                i++;
                dropped = true;
            }
            if(!dropped){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e){
                }
            }
        }
    }
    public void judge(int input){
        for(int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            Boolean notei = false;
            if(input == note.getNotex()) {
                if(!notei){
                    note.judge();
                    notei = true;
                }
            }
        }
    }
}
