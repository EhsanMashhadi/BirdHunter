package com.ehsanmashhadi.birdhunter;

import java.awt.*;

public class BirdGenerator extends Thread {

    private boolean isFinished = false;
    private ScreenManager screenManager;
    private Image birdImage;

    public BirdGenerator(ScreenManager screenManager, Image birdImage) {

        this.screenManager = screenManager;
        this.birdImage = birdImage;
    }

    public void run() {

        while (!isFinished) {

            Bird bird = randomBird();
            screenManager.addScreenObject(bird);

            Thread t = new Thread(bird);
            t.start();

            try {
                sleep(900);
            } catch (InterruptedException ex) {
            }
        }
    }

    public int random(int m) {
        return (int) (m * Math.random());
    }

    private Bird randomBird() {

        int w = 80 + random(70);
        int h = 50 + random(35);
        int x = -w;
        int y = 30 + random(120);
        int sleep = 5 + random(20);
        Color cl = null;
        return new Bird(x, y, w, h, cl, sleep, screenManager, birdImage);
    }

    void finish() {
        isFinished = true;
    }

}
