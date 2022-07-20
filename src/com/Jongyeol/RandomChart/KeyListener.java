package com.Jongyeol.RandomChart;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyListener extends KeyAdapter {
    ArrayList<String> list = new ArrayList<String>();
    int i;

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("1 " + list.get(i));
            i++;
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            System.out.println("2 " + list.get(i));
            i++;
        } else if (e.getKeyCode() == KeyEvent.VK_U) {
            System.out.println("3 " + list.get(i));
            i++;
        } else if (e.getKeyCode() == KeyEvent.VK_I) {
            System.out.println("4 " + list.get(i));
            i++;
        }
    }
    public KeyListener(ArrayList<String> list){
        this.list = list;
        i = 0;
    }
}
