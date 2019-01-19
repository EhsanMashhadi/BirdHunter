package com.ehsanmashhadi.birdhunter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScreenManager extends Thread {

    private CopyOnWriteArrayList<ScreenObject> screenObjectList;
    private JApplet jApplet;
    private Image image;
    private Graphics graphics;
    private boolean isFinished = false;

    public ScreenManager(JApplet parentApplet) {
        this.jApplet = parentApplet;
        this.screenObjectList = new CopyOnWriteArrayList<>();
        this.image = parentApplet.createImage(parentApplet.getWidth(), parentApplet.getHeight());
        this.graphics = image.getGraphics();
    }

    public void addScreenObject(ScreenObject sObj) {
        screenObjectList.add(sObj);
    }

    public void removeScreenObject(ScreenObject sObj) {
        screenObjectList.remove(sObj);
    }

    public void draw(Graphics g) {
        checkConflict();
        graphics.clearRect(0, 0, jApplet.getWidth(), jApplet.getHeight());
        for (ScreenObject scrObj : screenObjectList) {
            scrObj.draw(graphics);
        }
        g.drawImage(image, 0, 0, jApplet);
    }

    public void run() {
        while (!isFinished) {
            jApplet.repaint();
            try {
                sleep(20);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void finish() {
        isFinished = true;
    }

    public JApplet getJApplet() {
        return this.jApplet;
    }

    private void checkConflict() {

        ArrayList<Bullet> bulletArrayList = new ArrayList<Bullet>(10);
        ArrayList<Bird> birdArrayList = new ArrayList<Bird>(10);
        ArrayList<Cloud> cloudArrayList = new ArrayList<Cloud>(10);
        ArrayList<Enemy> enemyArrayList = new ArrayList<Enemy>(10);
        ArrayList<EnemyBullet> enemyBulletArrayList = new ArrayList<EnemyBullet>(10);

        Score score = null;

        for (ScreenObject screenObject : screenObjectList) {

            if (screenObject instanceof Bird) {

                birdArrayList.add((Bird) screenObject);
            } else if (screenObject instanceof Bullet) {

                bulletArrayList.add((Bullet) screenObject);
            } else if (screenObject instanceof Score) {

                score = (Score) screenObject;
            } else if (screenObject instanceof Cloud) {

                cloudArrayList.add((Cloud) screenObject);
            } else if (screenObject instanceof Enemy) {

                enemyArrayList.add((Enemy) screenObject);
            } else if (screenObject instanceof EnemyBullet) {

                enemyBulletArrayList.add((EnemyBullet) screenObject);
            }
        }

        for (Bird bird : birdArrayList)

            for (Bullet bullet : bulletArrayList) {

                int bx = (int) (bullet.x + bullet.w / 2);
                int by = bullet.y;

                if (bx <= bird.x + bird.w && bx >= bird.x && by <= bird.y + bird.h && by >= bird.y) {
                    removeScreenObject(bird);
                    removeScreenObject(bullet);
                    score.addScore(((bird.w) / 4) - bird.getSleep());
                }
            }

        for (Bird bird : birdArrayList) {

            int bx = (int) ((bird.x));
            if (bx >= jApplet.getWidth()) {
                removeScreenObject(bird);
            }
        }

        for (Cloud cloud : cloudArrayList) {

            int bx = (int) (cloud.x);
            if (bx >= jApplet.getWidth()) {
                removeScreenObject(cloud);
            }
        }

        for (Enemy enemy : enemyArrayList) {

            int bx = (int) (enemy.x);
            if (bx >= jApplet.getWidth()) {
                removeScreenObject(enemy);
            }
        }

        for (Bullet bullet : bulletArrayList) {

            int by = bullet.y;
            if (by <= 0) {
                removeScreenObject(bullet);
            }
        }

        for (EnemyBullet enemyBullet : enemyBulletArrayList) {
            if (enemyBullet.y >= jApplet.getHeight()) {
                removeScreenObject(enemyBullet);
            }
        }

        for (Bullet bullet : bulletArrayList)
            for (EnemyBullet enemyBullet : enemyBulletArrayList) {
                int bx = (int) (bullet.x - bullet.w / 2);
                int by = bullet.y;
                if (bx <= enemyBullet.x + enemyBullet.w + 5 && bx >= enemyBullet.x - 5 && by <= enemyBullet.y + enemyBullet.h + 5 && by >= enemyBullet.y - 5) {
                    removeScreenObject(enemyBullet);
                    removeScreenObject(bullet);
                }
            }

        for (EnemyBullet enemyBullet : enemyBulletArrayList) {

            if ((enemyBullet.x + enemyBullet.w / 2) >= 290 && (enemyBullet.x + enemyBullet.w / 2) <= 510 && enemyBullet.y + enemyBullet.h >= 454) {
                score.addScore(-50);
                removeScreenObject(enemyBullet);
            }
        }
    }
}