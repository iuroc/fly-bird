package top.apee.birdFly2;

import java.awt.image.BufferedImage;

/**
 * 地面类
 */
public class Ground {
    /**
     * 配置类
     */
    public class Config {
        /**
         * 每个循环单位移动的像素
         */
        public static final int MOVEPX = 1;
        /**
         * 地面能够向左移动的极限位置，到达后地面将回到原点
         */
        public static final int MINX = -363;
    }

    /**
     * 地面位置
     */
    public int x = 0, y = 498;

    /**
     * 地面图片
     */
    public BufferedImage image;

    /**
     * 临时图片，该图片用于赋值给image
     */
    public BufferedImage imageTemp = Tool.loadImage("image/ground.png");

    public Ground() {

    }

    /**
     * 移动地面
     */
    public void move() {
        this.x -= Ground.Config.MOVEPX;
        if (x <= Ground.Config.MINX) {
            this.x = 0;
        }
    }

    /**
     * 显示地面
     */
    public void show() {
        this.image = this.imageTemp;
    }

    /**
     * 移除地面
     */
    public void remove() {
        this.image = null;
    }
}
