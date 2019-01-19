package com.ehsanmashhadi.birdhunter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;

public class Enemy extends ScreenObject implements Runnable {

    private int dx = 4;
    private int sleep;
    private ScreenManager screenManager;
    private Image enemyImage;
    private JApplet jApplet;
    private int random;

    public Enemy(int x, int y, int w, int h, Color cl, int sleep, ScreenManager screenManager, Image enemyImage) {
        super(x, y, w, h, cl);
        this.sleep = sleep;
        this.enemyImage = enemyImage;
        this.screenManager = screenManager;
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.drawImage(enemyImage, (int) x, y, w, h, color, jApplet);
    }

    public int generateRandomNumber(int m) {

        return (int) (Math.random() * m);
    }

    public void run() {

        while (x + dx - 5 < screenManager.getJApplet().getWidth()) {
            random = generateRandomNumber(799);
            x += dx;
            try {
                Thread.currentThread().sleep(sleep);

            } catch (InterruptedException ex) {

            }
            if (x == random) {
                fire();
            }
        }
    }

    private void fire() {

        EnemyBullet enemyBullet = new EnemyBullet((int) (x), y, 20, 30, Color.black, 15, screenManager);
        screenManager.addScreenObject(enemyBullet);
        Thread t = new Thread(enemyBullet);
        t.start();
    }
}