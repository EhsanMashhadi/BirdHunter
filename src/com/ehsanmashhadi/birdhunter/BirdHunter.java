package com.ehsanmashhadi.birdhunter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class BirdHunter extends JApplet implements KeyListener {

    private ScreenManager screenManager;
    private Gun gun;

    private Image backgroundImage;
    private Image cloudImage;
    private Image gunImage;
    private Image birdImage;
    private Image enemyImage;

    private BirdGenerator birdGenerator;
    private CloudGenerator cloudGenerator;
    private EnemyGenerator enemyGenerator;

    public void init() {

        setSize(800, 600);
        this.addKeyListener(this);
        this.setMaximumSize(getMaximumSize());
        screenManager = new ScreenManager(this);
        ClassLoader classLoader = getClass().getClassLoader();

        backgroundImage = getImage(classLoader.getResource("grass.jpg"));

        BackGround backGround = new BackGround(0, 0, screenManager.getJApplet().getWidth(), screenManager.getJApplet().getHeight(), Color.white, backgroundImage, this);
        screenManager.addScreenObject(backGround);

        birdImage = getImage(classLoader.getResource("bird.gif"));
        birdGenerator = new BirdGenerator(screenManager, birdImage);

        Score score = new Score(750 - 80, 600 - 50, 80, 30, Color.white);
        screenManager.addScreenObject(score);

        gunImage = getImage(classLoader.getResource("space.png"));
        gun = new Gun(getWidth() / 2 - 15 / 2, getHeight() - 40, 15, 40, Color.red, gunImage, screenManager);
        screenManager.addScreenObject(gun);

        cloudImage = getImage(classLoader.getResource("cloud.png"));
        cloudGenerator = new CloudGenerator(screenManager, cloudImage);

        enemyImage = getImage(classLoader.getResource("enemy.gif"));
        enemyGenerator = new EnemyGenerator(screenManager, enemyImage);
    }

    public void start() {

        screenManager.start();
        birdGenerator.start();
        cloudGenerator.start();
        enemyGenerator.start();
    }

    public void stop() {

        screenManager.finish();
        birdGenerator.finish();
        cloudGenerator.finish();
        enemyGenerator.finish();
    }

    public void paint(Graphics g) {

        requestFocus();
        screenManager.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_RIGHT:
                gun.right();
                break;
            case KeyEvent.VK_LEFT:
                gun.left();
                break;
            case KeyEvent.VK_SPACE:
                gun.fire();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
