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
        // y 轴位置, -250, -450
        this.setY();
        // 显示图片
        this.showImage();
    }

    /**
     * 设置 y 的随机值, [-250, -450]
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
        // 柱子超出屏幕左边 100 像素
        if (this.x == -100) {
            // 将柱子移动到 x = 650 位置, 实现柱子的无限生成
            this.x = 650;
            // 设置新生成的柱子的 y 轴位置
            this.setY();
        }
        // 柱子高度组成: 525 + 150 + 525
        // 柱子宽度: 70
        // 小鸟宽高: 56 x 48
        // 判断小鸟进入管道, 此时柱子的 x 属于区间 [120-柱宽70, 120+鸟宽56]
        // 小鸟刚进入之后 && 小鸟刚离开之前
        if (this.x < 120 + 56 && this.x > 120 - 70) {
            // 缺口上边缘 y 值
            int entTop = this.y + 525;
            // 小鸟处于缺口最底部时, 小鸟上边缘 y 值
            int birdTopMin = this.y + 525 + 150 - 48;
            // 小鸟撞上了缺口上边缘 && 小鸟撞上了缺口下边缘
            if (bird.y < entTop || bird.y > birdTopMin) {
                // 游戏结束
                this.body.status = this.body.OVER;
            }
        }
        // 小鸟刚好离开柱子
        if (this.x == 120 - 70) {
            // 分数增加
            this.body.score++;
        }
    }
}
