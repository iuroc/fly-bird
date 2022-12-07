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
        public static final int NOTCHHEIGHT = 146;
    }

    GamePane gamePane;

    /**
     * 初始化柱子
     * 
     * @param gamePane 游戏主体
     * @param x        柱子初始x值
     */
    public Column(GamePane gamePane) {
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
        // 柱子到达最左边，将柱子移动到最右边，形成新的柱子
        if (this.x <= Column.Config.MINX) {
            this.x = Column.Config.SPACING * 2 + Column.Config.MINX;
            this.changeY();
        }
        // 开始判断小鸟撞击柱子
        // 判断小鸟进入柱子范围
        // 头部已经进入
        boolean headIn = this.x <= Bird.Config.X + Bird.Config.WIDTH;
        // 尾部没有离开
        boolean tailOut = this.x >= Bird.Config.X - Column.Config.WIDTH;
        if (headIn && tailOut) {
            // 判断小鸟撞上缺口上部或下部
            // 小鸟是否撞上柱子上部分
            boolean dumpTop = this.gamePane.bird.y <= Column.Config.TOPHEIGHT + this.y;
            // 小鸟通过缺口时，小鸟y值允许的最小值，即小鸟到达缺口下边缘时的小鸟y值
            int birdMinY = Column.Config.TOPHEIGHT + this.y + Column.Config.NOTCHHEIGHT - Bird.Config.HEIGHT;
            boolean dumpBottom = this.gamePane.bird.y >= birdMinY;
            if (dumpTop || dumpBottom) {
                this.gamePane.status = GamePane.Config.OVER;
            }
        }
    }
}
