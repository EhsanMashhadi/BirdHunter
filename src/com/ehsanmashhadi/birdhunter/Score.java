package com.ehsanmashhadi.birdhunter;

import java.awt.*;


public class Score extends ScreenObject {

    private int score = 0;

    public Score(int x, int y, int w, int h, Color cl) {
        super(x, y, w, h, cl);
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.setColor(color);
        graphics.setFont(new Font("Arial", Font.BOLD, (int) (h / 1.5)));
        graphics.drawString("Score: " + score + "", (int) x, y + h / 2);
    }

    public void addScore(int diff) {
        score += diff;
    }
}
