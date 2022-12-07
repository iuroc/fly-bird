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

    public class Config {
        /**
         * 柱子能够向左移动的极限位置，到达后柱子将移动到最右边，形成新的柱子
         */
        public static final int MINX = -100;
        /**
         * 第一根柱子的x值
         */
        public static final int FIRSTX = 400;
        /**
         * 柱子的间距
         */
        public static final int SPACING = 300;
        /**
         * 柱子的宽度
         */
        public static final int WIDTH = 76;
        /**
         * 柱子上部分高度
         */
        public static final int TOPHEIGHT = 525;
        /**
         * 柱子缺口高度
         */
        public static final int NOTCHHEIGHT = 78;
    }

    GamePane gamePane;

    /**
     * 初始化柱子
     * 
     * @param gamePane 游戏主体
     * @param x        柱子初始x值
     */
    public Column(GamePane gamePane, int x) {
        this.x = x;
        this.gamePane = gamePane;
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
        if (this.x <= Column.Config.MINX) {
            this.x = Column.Config.SPACING * 2 + Column.Config.MINX;
            this.changeY();
        }
    }
}
