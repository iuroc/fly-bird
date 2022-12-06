package top.apee.birdFly;

import java.awt.image.*;
import java.util.Random;

/**
 * 柱子
 */
public class Column {
    /**
     * 柱子位置
     */
    int x, y;
    Body body;
    /*
     * 柱子图片
     */
    BufferedImage image;

    public Column(Body body) {
        this.body = body;
        // y轴位置，-250, -450
        this.setY();
        // 显示图片
        this.showImage();
    }

    /**
     * 设置y的随机值
     */
    public void setY() {
        this.y = new Random().nextInt(201) - 450;
    }

    /**
     * 显示图片
     */
    public void showImage() {
        this.image = Main.loadImage("image/column.png");
    }

    /**
     * 隐藏图片
     */
    public void hideImage() {
        this.image = null;
    }

    /**
     * 柱子移动
     */
    public void move(Bird bird) {
        this.x--;
        if (this.x == -100) {
            this.x = 650;
            this.setY();
        }
        // 判断是否进入管道
        // 柱子的x属于区间 [120-柱宽78, 120+鸟宽56]
        if (this.x < 120 + 56 && this.x > 120 - 78) {
            // 柱子高度组成：530 + 150 + 530
            if (this.y + 525 > bird.y || bird.y > this.y + 530 + 150 - 48) {
                this.body.status = this.body.OVER;
            }
        }
    }
}
