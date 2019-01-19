package com.ehsanmashhadi.birdhunter;

import java.awt.*;

public class EnemyGenerator extends Thread {

    private boolean isFinished = false;
    private ScreenManager screenManager;
    private Image enemyImage;

    public EnemyGenerator(ScreenManager screenManager, Image enemyImage) {
        this.screenManager = screenManager;
        this.enemyImage = enemyImage;
    }

    public void run() {

        while (!isFinished) {

            Enemy enemy = randomEnemy();
            screenManager.addScreenObject(enemy);

            Thread t = new Thread(enemy);
            t.start();
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public int random(int m) {
        return (int) (m * Math.random());
    }

    private Enemy randomEnemy() {

        int w = 100;
        int h = 70;
        int x = -w;
        int y = 10 + random(30);
        int sleep = 25 + random(5);
        Color cl = null;
        return new Enemy(x, y, w, h, cl, sleep, screenManager, enemyImage);
    }

    void finish() {
        isFinished = true;
    }

}
