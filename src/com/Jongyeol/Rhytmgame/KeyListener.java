package com.Jongyeol.Rhytmgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if(!DynamicBeat.isMainScreen){
            return;
        }
        System.out.println("d");
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Main.dynamicBeat.selectLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Main.dynamicBeat.selectRight();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Main.dynamicBeat.selectSpace();
        }
        if(DynamicBeat.game == null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
            DynamicBeat.game.pressw();
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            DynamicBeat.game.pressE();
        } else if (e.getKeyCode() == KeyEvent.VK_U) {
            DynamicBeat.game.pressU();
        } else if (e.getKeyCode() == KeyEvent.VK_I) {
            DynamicBeat.game.pressI();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(DynamicBeat.game == null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
            DynamicBeat.game.releaseW();
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            DynamicBeat.game.releaseE();
        } else if (e.getKeyCode() == KeyEvent.VK_U) {
            DynamicBeat.game.releaseU();
        } else if (e.getKeyCode() == KeyEvent.VK_I) {
            DynamicBeat.game.releaseI();

        }
    }
}
