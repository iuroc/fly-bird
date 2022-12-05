package top.apee.birdFly;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.image.*;

/**
 * 游戏界面主体
 * 
 * @author 欧阳鹏
 */
public class Body extends JPanel {
    /**
     * 地板
     */
    public Ground ground;
    /**
     * 小鸟
     */
    public Bird bird;
    /**
     * 游戏状态
     */
    public int status;
    /**
     * 准备开始
     */
    public final int START = 0;
    /**
     * 游戏进行中
     */
    public final int RUNNING = 1;
    /**
     * 游戏结束
     */
    public final int OVER = 2;

    public Body() {
        // 创建地板
        this.ground = new Ground();
        this.bird = new Bird();
        this.addMouseListener(new BodyClick(this));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 载入背景图片
        g.drawImage(Main.loadImage("image/bg.png"), 0, 0, null);
        // 载入地板图片
        g.drawImage(this.ground.image, this.ground.x, this.ground.y, null);
        // 判断游戏状态
        BufferedImage startImage = Main.loadImage("image/start.png");
        BufferedImage overImage = Main.loadImage("image/gameover.png");
        switch (this.status) {
            case START:
                this.ground.move();
                this.bird.image = null;
                this.bird.y = 220;
                overImage = null;
                break;
            case RUNNING:
                this.ground.move();
                startImage = null;
                this.bird.changeIndex(this);
                this.bird.image = Main.loadImage("image/" + this.bird.index + ".png");
                overImage = null;
                break;
            case OVER:
                startImage = null;
                this.bird.image = null;
                break;
        }
        g.drawImage(startImage, 0, 0, null);
        g.drawImage(overImage, 0, 0, null);
        g.drawImage(this.bird.image, this.bird.x, this.bird.y, null);
    }

    /**
     * 开始游戏
     */
    public void start() {
        while (true) {
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
