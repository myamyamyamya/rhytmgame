package com.Jongyeol.RandomChart;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends JFrame{
    ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) throws FileNotFoundException {
        new Main();
    }
    public Main() throws FileNotFoundException {
        setTitle("DynamicBeat");
        setSize(com.Jongyeol.Rhytmgame.Main.SCREEN_WIDTH, com.Jongyeol.Rhytmgame.Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Scanner in = new Scanner(new File("C:/Rhytmgame/ChartData/wind.txt"));
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
        addKeyListener(new KeyListener(list));
    }
}
