package top.apee.birdFly;

import java.awt.event.*;

public class BodyClick implements MouseListener {

    Body body;

    public BodyClick(Body body) {
        this.body = body;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (this.body.status == this.body.START) {
            // 游戏开始页面，点 击开始游戏
            this.body.status = this.body.RUNNING;
        } else if (this.body.status == this.body.OVER) {
            // 游戏结束，点击回到开始页
            this.body.status = this.body.START;
        } else if (this.body.status == this.body.RUNNING) {
            // 游戏进行中，点击让小鸟往上飞
            this.body.bird.topNum = 0;
            if (this.body.bird.dir == -1 && this.body.bird.topNum == 20) {
                this.body.bird.dir = 1;
            } else {
                this.body.bird.dir = -1;
            }
        }
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