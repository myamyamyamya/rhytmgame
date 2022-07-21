package com.Jongyeol.RhytmChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {
    private Image screenImage;
    private Graphics screenGraphics;
    private ImageIcon exitButton1 = new ImageIcon(Main.class.getResource("../../../resource/exit.jpg"));
    private ImageIcon exitButton2 = new ImageIcon(Main.class.getResource("../../../resource/exit2.jpg"));
    private ImageIcon startButton1 = new ImageIcon(Main.class.getResource("../../../resource/start.png"));
    private ImageIcon startButton2 = new ImageIcon(Main.class.getResource("../../../resource/start2.png"));
    private ImageIcon EasyButton1 = new ImageIcon(Main.class.getResource("../../../resource/Easy.png"));
    private ImageIcon EasyButton2 = new ImageIcon(Main.class.getResource("../../../resource/Easy2.png"));
    private ImageIcon HardButton1 = new ImageIcon(Main.class.getResource("../../../resource/Hard.png"));
    private ImageIcon HardButton2 = new ImageIcon(Main.class.getResource("../../../resource/Hard2.png"));
    private ImageIcon backButton1 = new ImageIcon(Main.class.getResource("../../../resource/back.png"));
    private ImageIcon backButton2 = new ImageIcon(Main.class.getResource("../../../resource/back2.png"));
    private ImageIcon EbackButton1 = new ImageIcon(Main.class.getResource("../../../resource/eback.png"));
    private ImageIcon EbackButton2 = new ImageIcon(Main.class.getResource("../../../resource/eback2.png"));
    private ImageIcon introBackGround = new ImageIcon(Main.class.getResource("../../../resource/Frhythmgame.jpg"));
    private Image BackGround = introBackGround.getImage();
    private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../../../resource/menubar.png")));
    private JButton exitButton = new JButton(exitButton1);
    private JButton startButton = new JButton(startButton1);
    private JButton EasyButton = new JButton(EasyButton1);
    private JButton HardButton = new JButton(HardButton1);
    private JButton backButton = new JButton(backButton1);
    JButton EbackButton = new JButton(new ImageIcon(Main.class.getResource("../../../resource/eback.png")));
    private boolean isMainScreen = false;
    private boolean isGameScreen = false;
    ArrayList<Track> tracklist = new ArrayList<Track>();
    private Image selectedImage;
    private Image titleImage;
    private Music selectedMusic;
    private int nowSelected = 0;
    public static Game game;
    private static KeyListener keyListener;
    public DynamicBeat() {
        tracklist.add(new Track("IcyxisT.png", "Icyxis.jpg", "IcyxisB.jpg", "Icyxis1", "Icyxis", "Raimukun - Icyxis"));
        tracklist.add(new Track("a secret puppet showT.png", "a secret puppet show.jpg", "a secret puppet show.jpg", "a secret puppet show1", "a secret puppet show", "plum - 비밀인형극"));
        tracklist.add(new Track("hello2021t.png", "hello2021.png", "hello2021B.png", "hello20211", "hello2021", "Camellia - Hello (bpm) 2021"));
        tracklist.add(new Track("200ccT.png", "200cc.jpg", "200cc.jpg", "200cc1", "200cc", "tanger - 200cc(200bpm)"));
        tracklist.add(new Track("windT.png", "wind.jpg", "windB.jpg", "wind1", "wind", "a_hisa - 風"));
        setUndecorated(true);
        setTitle("DynamicBeat Chart");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);
        keyListener = new KeyListener();
        addKeyListener(keyListener);
        Music intromusic = new Music("IntroMusic", true);
        intromusic.start();
        exitButton.setBounds(1560, 10, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButton2);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButton1);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(game !=null) { game.close(); }
                System.exit(0);
            }
        });
        add(exitButton);
        menubar.setBounds(0, 0, 1600, 50);
        add(menubar);
        startButton.setBounds(750, 600, 100, 50);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButton2);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButton1);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectTrack(0);
                startButton.setVisible(false);
                intromusic.close();
                MainScreenVisible(true);
            }
        });
        add(startButton);
        EasyButton.setVisible(false);
        EasyButton.setBounds(500, 740, 250, 67);
        EasyButton.setBorderPainted(false);
        EasyButton.setContentAreaFilled(false);
        EasyButton.setFocusPainted(false);
        EasyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EasyButton.setIcon(EasyButton2);
                EasyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                EasyButton.setIcon(EasyButton1);
                EasyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                gameStart(nowSelected, 1);
            }
        });
        add(EasyButton);
        HardButton.setVisible(false);
        HardButton.setBounds(870, 740, 250, 67);
        HardButton.setBorderPainted(false);
        HardButton.setContentAreaFilled(false);
        HardButton.setFocusPainted(false);
        HardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                HardButton.setIcon(HardButton2);
                HardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                HardButton.setIcon(HardButton1);
                HardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                gameStart(nowSelected, 2);
            }
        });
        add(HardButton);
        backButton.setVisible(false);
        backButton.setBounds(20, 60, 60, 60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setIcon(backButton2);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButton1);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                backMain();
            }
        });
        add(backButton);
        EbackButton.setVisible(false);
        EbackButton.setBounds(720, 500, 170, 78);
        EbackButton.setBorderPainted(false);
        EbackButton.setContentAreaFilled(false);
        EbackButton.setFocusPainted(false);
        EbackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EbackButton.setIcon(EbackButton2);
                EbackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                EbackButton.setIcon(EbackButton1);
                EbackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                EbackButton.setVisible(false);
                backMain();
            }
        });
        add(EbackButton);
    }
    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphics = screenImage.getGraphics();
        screenDraw((Graphics2D) screenGraphics);
        g.drawImage(screenImage, 0, 0, null);
    }
    public void screenDraw(Graphics2D g) {
        g.drawImage(BackGround, 0, 0, null);
        if(isMainScreen){
            g.drawImage(selectedImage, 450, 100, null);
            g.drawImage(titleImage, 500, 80, null);
        }
        if(isGameScreen){
            game.screenDraw(g);
        }
        paintComponents(g);
        try {
            Thread.sleep(5);
        } catch (Exception e){
            e.printStackTrace();
        }
        this.repaint();
    }
    public void selectTrack (int nowSelected) {
        if(selectedMusic != null){
            selectedMusic.close();
        }
        titleImage = new ImageIcon(Main.class.getResource("../../../resource/" + tracklist.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../../../resource/" + tracklist.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(tracklist.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }
    public void selectLeft() {
        if(nowSelected == 0) {
            nowSelected = tracklist.size() - 1;
        } else {
            nowSelected--;
        }
        selectTrack(nowSelected);
    }
    public void selectRight() {
        if(nowSelected == tracklist.size() - 1) {
            nowSelected = 0;
        } else {
            nowSelected++;
        }
        selectTrack(nowSelected);
    }
    public void gameStart(int nowSelected, int difficulty){
        if(selectedMusic != null) {
            selectedMusic.close();
        }
        BackGround = new ImageIcon("../../../resource/" + tracklist.get(nowSelected).getGameImage()).getImage();
        game = new Game(tracklist.get(nowSelected).getTitlename(), difficulty, tracklist.get(nowSelected).getGameMusic());
        game.start();
        MainScreenVisible(false);
        backButton.setVisible(true);
        isGameScreen = true;
        setFocusable(true);
    }
    public void backMain(){
        BackGround = introBackGround.getImage();
        MainScreenVisible(true);
        backButton.setVisible(false);
        selectTrack(nowSelected);
        isGameScreen = false;
        game.close();
    }
    public void MainScreenVisible(Boolean visible) {
        EasyButton.setVisible(visible);
        HardButton.setVisible(visible);
        isMainScreen = visible;
        keyListener.setLobby(visible);
    }
}
