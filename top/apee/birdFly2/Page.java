package top.apee.birdFly2;

import java.awt.image.BufferedImage;

/**
 * 图片页面类，用于创建开始页面、结束页面
 */
public class Page {
    BufferedImage image;
    BufferedImage imageTemp;

    public Page(String name) {
        this.imageTemp = Tool.loadImage(name);
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
}