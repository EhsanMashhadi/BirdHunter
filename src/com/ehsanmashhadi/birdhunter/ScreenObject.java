package com.ehsanmashhadi.birdhunter;

import java.awt.*;

public abstract class ScreenObject {

    protected double x;
    protected int y;
    protected int w;
    protected int h;
    protected Color color;

    public ScreenObject(int x, int y, int w, int h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }
    public abstract void draw(Graphics graphics);
}