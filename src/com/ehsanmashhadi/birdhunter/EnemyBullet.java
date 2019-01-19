package com.ehsanmashhadi.birdhunter;

import java.awt.*;

public class EnemyBullet extends ScreenObject implements Runnable {

    private int dy = 2;
    private int sleep;
    private ScreenManager screenManager;

    public EnemyBullet(int x, int y, int w, int h, Color cl, int sleep, ScreenManager screenManager) {
        super(x, y, w, h, cl);
        this.sleep = sleep;
        this.screenManager = screenManager;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillOval((int) x, y, w, h);
    }

    @Override
    public void run() {

        while (y < screenManager.getJApplet().getHeight()) {

            y += dy;
            try {
                Thread.sleep(sleep);

            } catch (InterruptedException ex) {
            }

        }

    }

}
