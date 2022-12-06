package top.apee.birdFly;

import java.awt.image.*;

/**
 * 地板
 */
public class Ground {
    /**
     * 地板位置
     */
    int x, y;
    /**
     * 地板图片对象
     */
    BufferedImage image;

    public Ground() {
        // 地板 x 轴位置
        this.x = 0;
        // 地板 y 轴位置
        this.y = 498;
        // 载入地板图片对象
        this.image = Main.loadImage("image/ground.png");
    }

    /**
     * 移动地板
     */
    public void move() {
        // 地板左移
        this.x--;
        // 如果地板左移了 110, 回到原点重新移动
        if (this.x == -110) {
            this.x = 0;
        }
    }
}
