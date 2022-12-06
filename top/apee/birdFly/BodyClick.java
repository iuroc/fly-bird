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
        new MyEvent().click(this.body);
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

class MyEvent {
    public void click(Body body) {
        if (body.status == body.START) {
            // 游戏开始页面，点 击开始游戏
            body.status = body.RUNNING;
        } else if (body.status == body.OVER) {
            // 游戏结束，点击回到开始页
            body.status = body.START;
        } else if (body.status == body.RUNNING) {
            // 游戏进行中，点击让小鸟往上飞
            // 将小鸟从上一次点击屏幕以来上移的单位数归0，将重新开始计算向上的数量
            body.bird.topNum = 0;
            if (body.bird.dir == -1 && body.bird.topNum == body.bird.topAll) {
                // 判断到小鸟运动方向向上，并且小鸟已经到达可向上的最大高度，此时改变方向为向下
                body.bird.dir = 1;
            } else {
                // 小鸟在向下移动，或者小鸟还未完成向上移动20，此时直接让小鸟向上飞
                body.bird.dir = -1;
            }
        }
    }
}