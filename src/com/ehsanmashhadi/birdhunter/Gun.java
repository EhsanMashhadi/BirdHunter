package com.ehsanmashhadi.birdhunter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;


public class Gun extends ScreenObject {

    private ScreenManager screenManager;
    private Image gunImage;
    private JApplet jApplet;
    private int r = 0;

    public Gun(int x, int y, int w, int h, Color color, Image gunImage, ScreenManager screenManager) {
        super(x, y, w, h, color);
        this.screenManager = screenManager;
        this.gunImage = gunImage;
    }

    @Override
    public void draw(Graphics graphics) {

        Graphics2D g2d = (Graphics2D) graphics;

        Rectangle rect = (screenManager.getJApplet().getBounds());
        AffineTransform affineTransform = new AffineTransform();

        affineTransform.setToTranslation((rect.width - gunImage.getWidth(jApplet)) / 2, 450);
        //Rotate with the anchor point as the mid of the image
        affineTransform.rotate(Math.toRadians(r), gunImage.getWidth(jApplet) / 2, gunImage.getWidth(jApplet) / 2);
        //Draw the image using the AffineTransform
        g2d.drawImage(gunImage, affineTransform, jApplet);

    }

    public void right() {
        if (r < 50)
            r += 10;
    }

    public void left() {
        if (r > -50)
            r -= 10;
    }

    public void fire() {

        Bullet bullet;

        double newX = x;
        int newY = y;

        switch (r) {
            case 0: {
                newY -= 116;
                break;
            }

            case 10: {
                newX += 21;
                newY -= 110;
                break;
            }

            case 20: {
                newX += 33;
                newY -= 110;
                break;
            }

            case 30: {
                newX += 48;
                newY -= 100;
                break;
            }

            case 40: {
                newX += 59;
                newY -= 90;
                break;
            }

            case 50: {
                newX += 69;
                newY -= 82;
                break;
            }

            case -10: {
                newX -= 16;
                newY -= 109;
                break;
            }
            case -20: {
                newX -= 33;
                newY -= 110;
                break;
            }

            case -30: {
                newX -= 48;
                newY -= 100;
                break;
            }

            case -40: {
                newX -= 59;
                newY -= 90;
                break;
            }

            case -50: {
                newX -= 69;
                newY -= 89;
                break;
            }
        }

        bullet = new Bullet((int) newX, newY, 10, 20, Color.black, 2, r);
        screenManager.addScreenObject(bullet);
        Thread thread = new Thread(bullet);
        thread.start();
    }
}
