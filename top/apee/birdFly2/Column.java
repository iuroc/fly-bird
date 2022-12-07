package top.apee.birdFly2;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 柱子类
 */
public class Column {
    /**
     * 柱子位置
     */
    int x, y;

    BufferedImage image;
    BufferedImage imageTemp = Tool.loadImage("image/column.png");

    public Column(int x) {
        this.x = x;
    }

    /**
     * 为y随机分配值，y取值范围 [-250, -450]
     */
    public void changeY() {
        this.y = new Random().nextInt(201) - 450;
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

    /**
     * 柱子移动
     */
    public void move() {
        this.x -= Ground.Config.MOVEPX;
        if (this.x <= -100) {
            this.x = 500;
        }
    }
}
