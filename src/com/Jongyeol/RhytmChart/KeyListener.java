package com.Jongyeol.RhytmChart;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private boolean Lobby = false;
    @Override
    public void keyPressed(KeyEvent e) {
        if(Lobby){
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                Main.dynamicBeat.selectLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Main.dynamicBeat.selectRight();
            }
            return;
        }
        if(DynamicBeat.game == null){
            return;
        }
        if(e.getKeyCode() == KeyEvent.VK_W) {
            DynamicBeat.game.pressW();
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

    public void setLobby(boolean lobby) {
        Lobby = lobby;
    }
}
