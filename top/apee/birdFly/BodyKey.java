package top.apee.birdFly;

import java.awt.event.*;

public class BodyKey implements KeyListener {

    Body body;

    public BodyKey(Body body) {
        this.body = body;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 32) {
            new MyEvent().click(this.body);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
