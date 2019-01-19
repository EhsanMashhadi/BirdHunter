package com.ehsanmashhadi.birdhunter;

import javax.swing.*;
import java.awt.*;

public class BackGround extends ScreenObject {

    private Image image;
    private JApplet jApplet;

    public BackGround(int x, int y, int w, int h, Color cl, Image image, JApplet jApplet) {
        super(x, y, w, h, cl);
        this.jApplet = jApplet;
        this.image = image;
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, 0, 0, jApplet.getWidth(), jApplet.getHeight(), jApplet);
    }
}
