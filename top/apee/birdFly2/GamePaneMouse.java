package top.apee.birdFly2;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * 鼠标事件类
 */
public class GamePaneMouse implements MouseListener {

    GamePane gamePane;

    public GamePaneMouse(GamePane gamePane) {
        this.gamePane = gamePane;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 鼠标点击屏幕事件
        int keyCode = e.getButton();
        // 鼠标左键点击
        if (keyCode == 1) {
            switch (this.gamePane.status) {
                case GamePane.Config.START:
                    this.gamePane.status = GamePane.Config.RUNNING;
                    break;
                case GamePane.Config.RUNNING:
                    // 小鸟开始上移，小鸟已经向上移动的距离归0
                    this.gamePane.bird.topNum = 0;
                    // 修改小鸟运动方向为向上
                    this.gamePane.bird.dir = -1;
                    break;
                case GamePane.Config.OVER:
                    this.gamePane.status = GamePane.Config.START;
                    break;
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
