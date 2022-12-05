package top.apee.birdGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 会飞的小鸟游戏
 * 
 * @author 欧阳鹏
 * @version 1.0
 */
public class BirdGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("会飞的小鸟");
        frame.setSize(446, 650);
        frame.setLocationRelativeTo(null);
        Body body = new Body();
        frame.setVisible(true);
        frame.setContentPane(body);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
        body.start();
    }
}

/**
 * 游戏主体
 */
class Body extends JPanel {

    /**
     * 游戏状态
     */
    public int status;
    public final int START = 0;
    public final int RUNNING = 1;
    public final int OVER = 2;
    /**
     * 地板
     */
    Ground ground;

    public Body() {
        this.status = START;
        this.ground = new Ground();
    }

    /**
     * 加载图片到图片缓冲区
     * 
     * @param name 文件路径 * @return 图片对象
     */
    public static BufferedImage loadImage(String name) {
        try {
            return ImageIO.read(Body.class.getResource(name));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage image = loadImage("image/bg.png");
        g.drawImage(image, 0, 0, null);
        g.drawImage(this.ground.image, this.ground.x, this.ground.y, null);
        if (this.status == START) {
            BufferedImage imageStart = loadImage("image/start.png");
            g.drawImage(imageStart, 0, 0, null);
        }
    }

    /**
     * 开始游戏
     */
    public void start() {
        while (true) {
            if (this.status == START) {
                this.ground.step();
            } else if (this.status == RUNNING) {
                this.ground.step();
            } else if (this.status == OVER) {
            }
            repaint();
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 地板
 */
class Ground {
    /**
     * 地板位置
     */
    public int x, y;
    /**
     * 地板图片
     */
    public BufferedImage image;

    public Ground() {
        this.x = 0;
        this.y = 498;
        this.image = Body.loadImage("image/ground.png");
    }

    /**
     * 地板移动一步，即更新x坐标的值
     */
    public void step() {
        this.x--;
        if (this.x == -100) {
            this.x = 0;
        }
    }
}