package top.apee.birdFly2;

import java.awt.image.BufferedImage;

/**
 * 小鸟类
 */
public class Bird {
    /**
     * 配置类
     */
    public class Config {
        /**
         * 小鸟尺寸
         */
        public static int width = 51, height = 48;
    }

    /**
     * 小鸟位置
     */
    public int x = 120, y = 220;
    /**
     * 当前小鸟图片文件下标
     */
    public int index = 0;
    /**
     * 用于计数
     */
    public int number = 0;
    /**
     * 小鸟图片
     */
    public BufferedImage image;
    /**
     * 临时图片，该图片用于赋值给image
     */
    public BufferedImage[] imageTemp = new BufferedImage[8];

    public Bird() {
        this.loadImages();
    }

    /**
     * 将图片列表加载到imageTemp
     */
    public void loadImages() {
        for (int index = 0; index < 8; index++) {
            BufferedImage image = Tool.loadImage("image/" + index + ".png");
            imageTemp[index] = image;
        }
    }

    /**
     * 显示小鸟
     */
    public void show() {
        this.number++;
        if (this.number % 10 == 0) {
            this.index++;
            if (this.index == 8) {
                this.index = 0;
            }
            this.image = imageTemp[this.index];
        }
    }

    /**
     * 移除小鸟
     */
    public void remove() {
        this.image = null;
    }
}
