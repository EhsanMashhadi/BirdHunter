package com.ehsanmashhadi.birdhunter;

import javax.swing.*;
import java.awt.*;

public class Bullet extends ScreenObject implements Runnable {

    private int dy = 2;
    private int sleep;
    private int r;
    private JApplet jApplet;

    public Bullet(int x, int y, int w, int h, Color cl, int sleep, int r) {
        super(x, y, w, h, cl);
        this.sleep = sleep;
        this.r = r;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval((int) x, y, w, h);
    }

    @Override
    public void run() {

        while (y + h >= 0) {
            switch (r) {
                case 0: {
                    y -= dy;
                    break;
                }
                case 10: {
                    y -= dy;
                    x += 0.35;
                    break;
                }
                case 20: {
                    y -= dy;
                    x += 0.7;
                    break;
                }
                case 30: {
                    y -= dy;
                    x += 0.9;
                    break;
                }
                case 40: {
                    y -= dy;
                    x += 1.4;
                    break;
                }
                case 50: {
                    y -= dy;
                    x += 1.6;
                    break;
                }
                case -10: {
                    y -= dy;
                    x -= 0.35;
                    break;
                }
                case -20: {
                    y -= dy;
                    x -= 0.7;
                    break;
                }
                case -30: {
                    y -= dy;
                    x -= 0.9;
                    break;
                }
                case -40: {
                    y -= dy;
                    x -= 1.4;
                    break;
                }
                case -50: {
                    y -= dy;
                    x -= 1.6;
                    break;
                }
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {

            }
        }
    }
}
