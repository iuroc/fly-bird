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
        this.x = 0;
        this.y = 498;
        this.image = Main.loadImage("image/ground.png");
    }

    /**
     * 移动地板
     */
    public void move() {
        this.x--;
        if (this.x == -110) {
            this.x = 0;
        }
    }
}
