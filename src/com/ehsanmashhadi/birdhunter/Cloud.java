package com.ehsanmashhadi.birdhunter;

import javax.swing.*;
import java.awt.*;

public class Cloud extends ScreenObject implements Runnable {

    private int dx = 4;
    private int sleep;
    private ScreenManager screenManager;
    private Image image;
    private JApplet jApplet;

    public Cloud(int x, int y, int w, int h, Color cl, int sleep, ScreenManager screenManager, Image cloudImage) {
        super(x, y, w, h, cl);
        this.sleep = sleep;
        this.image = cloudImage;
        this.screenManager = screenManager;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image, (int) x, y, w, h, color, jApplet);
    }

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
