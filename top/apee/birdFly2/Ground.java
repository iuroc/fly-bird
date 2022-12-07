package top.apee.birdFly2;

import java.awt.image.BufferedImage;

/**
 * 地面类
 */
public class Ground {
    /**
     * 地面位置
     */
    public int x = 0, y = 498;

    /**
     * 地面图片
     */
    BufferedImage image;

    public Ground() {

    }

    /**
     * 移动地面
     */
    public void move() {
        this.x--;
        if (x == -110) {
            this.x = 0;
        }
    }
    /**
     * 显示地面
     */
    public void show() {
        this.image = Tool.loadImage("image/ground.png");
    }

    /**
     * 移除地面
     */
    public void remove() {
        this.image = null;
    }
}
