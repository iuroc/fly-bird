package top.apee.birdFly;

import java.awt.image.*;

public class Bird {
    /**
     * 小鸟位置
     */
    int x, y;
    /**
     * 小鸟图片序号
     */
    int index;
    /**
     * 小鸟图片对象，56x48
     */
    BufferedImage image;

    public Bird() {
        this.x = 188;
        this.y = 220;
    }

    public void changeIndex(Body body) {
        this.index++;
        if (this.index == 8) {
            this.index = 0;
        }
        this.y += 2;
        // 判断掉地上了
        if (this.y > 460 || this.y < 0) {
            body.status = body.OVER;
        }
    }
}
