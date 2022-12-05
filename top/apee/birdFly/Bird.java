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
     * 向上计数
     */
    int topNum;
    /**
     * 每次点击上移的单位数
     */
    int topAllNum;
    /**
     * 小鸟图片对象，56x48
     */
    BufferedImage image;

    public Bird() {
        // 小鸟x轴位置
        this.x = 188;
        // 小鸟y轴位置
        this.y = 220;
        // 小鸟向下运动
        this.dir = 1;
        // 点击屏幕后，已经向上运动的单位数，超过某个固定值回落
        this.topNum = 0;
    }

    public void changeIndex(Body body) {
        // 更新小鸟形态对应的图片文件名
        this.index++;
        // 如果序号达到8，回0重新开始
        if (this.index == 8) {
            this.index = 0;
        }

        /**
         * 小鸟每个移动单位为3像素，数值越大移动速度越快
         */
        this.y += 3 * this.dir;
        // 判断掉地上了，或者头顶出去了，游戏结束
        if (this.y > 460 || this.y < 0) {
            body.status = body.OVER;
        }
    }
}
