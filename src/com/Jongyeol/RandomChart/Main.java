package com.Jongyeol.RandomChart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:/Rhytmgame/ChartData/wind.txt"));
        Random random = new Random();
        while (in.hasNextLine()) {
            int i = random.nextInt(4)+1;
            System.out.println(i + " " + in.nextLine());
        }

    }
}
