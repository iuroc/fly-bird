package top.apee.birdFly;

import java.awt.image.*;

public class Bird {
    /**
     * 小鸟位置
     */
    int x, y;
    /**
     * 方向，-1上，1下
     */
    int dir;
    /**
     * 小鸟图片序号
     */
    int index;
    /**
     * 小鸟振翅速度，即每经过多少单位更换小鸟形态图片，数值越大，振翅越慢
     */
    int changeSpeed;
    /**
     * 临时数字，用于辅助实现小鸟振翅速度
     */
    int temp;
    /**
     * 向上计数
     */
    int topNum;

    /**
     * 每次向上移动的单位数
     */
    int topAll;

    /**
     * 每单位的像素数
     */
    int pxPerMum;
    /**
     * 小鸟图片对象，56x48
     */
    BufferedImage image;

    public Bird() {
        // 小鸟x轴位置
        this.x = 120;
        // 小鸟y轴位置
        this.y = 220;
        // 小鸟向下运动
        this.dir = 1;
        // 点击屏幕后，已经向上运动的单位数，超过某个固定值回落
        this.topNum = 0;
        // 每单位像素数量
        this.pxPerMum = 3;
        // 向上的单位数
        this.topAll = 10;
        // 小鸟振翅速度
        this.changeSpeed = 10;
        // 临时数字
        this.temp = 0;
    }

    /**
     * 小鸟摆动翅膀
     * 
     * @param body
     */
    public void changeIndex(Body body) {
        // 更新小鸟形态对应的图片文件名
        this.temp++;
        if (this.temp % this.changeSpeed == 0) {
            this.index++;
            // 如果序号达到8，回0重新开始
            if (this.index == 8) {
                this.index = 0;
            }
        }
        this.image = Main.loadImage("image/" + this.index + ".png");
    }

    /**
     * 小鸟移动（上/下）
     * 
     * @param body
     */
    public void move(Body body) {
        // 小鸟向上移动1单位，每单位pxPerMum像素
        this.y += this.pxPerMum * this.dir;
        // 判断掉地上了，或者头顶出去了，游戏结束
        if (this.y > 460 || this.y < 0) {
            body.status = body.OVER;
        }
    }
}
