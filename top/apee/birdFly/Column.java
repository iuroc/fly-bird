package top.apee.birdFly;

import java.awt.image.*;

/**
 * 柱子
 */
public class Column {
    /**
     * 柱子位置
     */
    int x, y;

    /*
     * 柱子图片
     */
    BufferedImage image;

    public Column() {
        // 设置位置
        this.x = 100;
        this.y = -350;
        // 显示图片
        this.showImage();
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
}
