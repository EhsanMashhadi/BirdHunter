package com.ehsanmashhadi.birdhunter;

import javax.swing.*;
import java.awt.*;

public class Bird extends ScreenObject implements Runnable {

    private int dx = 2;
    private int sleep;
    private ScreenManager screenManager;
    private Image birdImage;
    private JApplet jApplet;

    public Bird(int x, int y, int w, int h, Color cl, int sleep, ScreenManager screenManager, Image birdImage) {

        super(x, y, w, h, cl);
        this.sleep = sleep;
        this.screenManager = screenManager;
        this.birdImage = birdImage;
    }

    public int getSleep() {
        return this.sleep;
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.drawImage(birdImage, (int) x, y, w, h, color, jApplet);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void run() {
        while (x + dx - 5 < screenManager.getJApplet().getWidth()) {
            x += dx;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
            }
        }
    }
}
