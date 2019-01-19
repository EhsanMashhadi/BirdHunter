package com.ehsanmashhadi.birdhunter;

import java.awt.*;

public class CloudGenerator extends Thread {

    private boolean isFinished = false;
    private ScreenManager screenManager;
    private Image image;

    public CloudGenerator(ScreenManager screenManager, Image cloudImage) {

        this.screenManager = screenManager;
        this.image = cloudImage;
    }

    public void run() {

        while (!isFinished) {

            Cloud cloud = randomCloud();
            screenManager.addScreenObject(cloud);

            Thread t = new Thread(cloud);
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

    private Cloud randomCloud() {

        int w = 50 + random(70);
        int h = 50 + random(35);
        int x = -w;
        int y = 10 + random(30);
        int sleep = 35 + random(5);
        Color cl = null;
        return new Cloud(x, y, w, h, cl, sleep, screenManager, image);
    }

    void finish() {
        isFinished = true;
    }

}
