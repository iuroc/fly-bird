package top.apee.birdFly;

import java.awt.event.*;

/**
 * 屏幕鼠标事件
 */
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
            // 将小鸟从上一次点击屏幕以来上移的单位数归0，将重新开始计算向上的数量
            this.body.bird.topNum = 0;
            if (this.body.bird.dir == -1 && this.body.bird.topNum == this.body.bird.topAll) {
                // 判断到小鸟运动方向向上，并且小鸟已经向上移动了20，此时改变方向为向下
                this.body.bird.dir = 1;
            } else {
                // 小鸟在向下移动，或者小鸟还未完成向上移动20，此时直接让小鸟向上飞
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