package top.apee.birdFly2;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 游戏主体
 */
public class GamePane extends JPanel {
    /**
     * 配置类
     */
    public class Config {
        /**
         * 每个循环单位的时间间隔
         */
        public static final int LOOPTIME = 15;
        /**
         * 游戏开始
         */
        public static final int START = 0;
        /**
         * 游戏进行中
         */
        public static final int RUNNING = 1;
        /**
         * 游戏结束
         */
        public static final int OVER = 2;
    }

    /**
     * 地面
     */
    public Ground ground = new Ground();

    /**
     * 小鸟
     */
    public Bird bird = new Bird(this);
    /**
     * 开始页面
     */
    public Page startImage = new Page("image/start.png");
    /**
     * 游戏结束页面
     */
    public Page overPage = new Page("image/gameover.png");
    /**
     * 柱子1
     */
    public Column column1 = new Column(400);
    /**
     * 柱子2
     */

    public Column column2 = new Column(700);
    /**
     * 游戏状态，开始、进行中、结束
     */
    public int status = 0;

    public GamePane() {
        this.addMouseListener(new GamePaneMouse(this));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.loadBackgroundImage(g);
        this.ground.show();
        switch (this.status) {
            case GamePane.Config.START:
                // 开始页面显示
                this.startImage.show();
                // 小鸟显示
                this.bird.show();
                // 小鸟运动方向向下
                this.bird.dir = 1;
                // 小鸟回到初始位置
                this.bird.y = Bird.Config.Y;
                // 地面移动
                this.ground.move();
                // 游戏结束页面隐藏
                this.overPage.remove();
                // 柱子隐藏
                this.column1.remove();
                this.column2.remove();
                // 随机生成柱子缺口高度
                this.column1.changeY();
                this.column2.changeY();
                break;
            case GamePane.Config.RUNNING:
                // 开始页面隐藏
                this.startImage.remove();
                // 小鸟显示
                this.bird.show();
                // 小鸟移动
                this.bird.move();
                // 地面移动
                this.ground.move();
                // 游戏结束页面隐藏
                this.overPage.remove();
                // 柱子显示
                this.column1.show();
                this.column2.show();
                // 柱子移动
                this.column1.move();
                this.column2.move();
                // 如果从最后一次点击屏幕开始，小鸟已经向上移动的距离超过了允许向上的距离，设置小鸟回落
                if (this.bird.topNum >= Bird.Config.TOPALL) {
                    this.bird.dir = 1;
                    this.bird.topNum = 0;
                }
                break;
            case GamePane.Config.OVER:
                // 开始页面隐藏
                this.startImage.remove();
                // 游戏结束页面隐藏
                this.overPage.show();
                // 柱子显示
                this.column1.show();
                this.column2.show();
                break;
        }
        // 绘制柱子1
        g.drawImage(this.column1.image, this.column1.x, this.column1.y, null);
        // 绘制柱子2
        g.drawImage(this.column2.image, this.column2.x, this.column2.y, null);
        // 绘制开始页面
        g.drawImage(this.startImage.image, 0, 0, null);
        // 绘制结束页面
        g.drawImage(this.overPage.image, 0, 0, null);
        // 绘制地面
        g.drawImage(this.ground.image, this.ground.x, this.ground.y, null);
        // 绘制小鸟
        g.drawImage(this.bird.image, this.bird.x, this.bird.y, null);
    }

    /**
     * 绘制背景图片
     * 
     * @param g
     */
    public void loadBackgroundImage(Graphics g) {
        BufferedImage image = Tool.loadImage("image/bg.png");
        g.drawImage(image, 0, 0, null);
    }

    /**
     * 启用游戏
     */
    public void startLoop() {
        while (true) {
            try {
                Thread.sleep(GamePane.Config.LOOPTIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}

/**
 * 鼠标事件类
 */
class GamePaneMouse implements MouseListener {

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

/**
 * 图片页面类，用于创建开始页面、结束页面
 */
class Page {
    BufferedImage image;
    BufferedImage imageTemp;

    public Page(String name) {
        this.imageTemp = Tool.loadImage(name);
    }

    /**
     * 显示图片
     */
    public void show() {
        this.image = this.imageTemp;
    }

    /**
     * 移除图片
     */
    public void remove() {
        this.image = null;
    }
}