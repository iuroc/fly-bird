package top.apee.birdFly;

import java.awt.event.*;

public class BodyClick implements MouseListener {

    Body body;

    public BodyClick(Body body) {
        this.body = body;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.body.status = this.body.RUNNING;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}