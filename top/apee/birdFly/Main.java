package top.apee.birdFly;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.IOException;

/**
 * 飞翔的小鸟
 * 
 * @author 欧阳鹏
 * @version 2.0
 */
public class Main {

    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("飞翔的小鸟");
        // 设置窗口尺寸
        frame.setSize(446, 600);
        // 设置窗口居中
        frame.setLocationRelativeTo(null);
        // 设置窗口关闭动作
        frame.setDefaultCloseOperation(3);
        // 创建游戏界面主体
        Body body = new Body();
        // 添加游戏主体
        frame.setContentPane(body);
        // 设置可视化
        frame.setVisible(true);
        // 设置窗口不可缩放大小
        frame.setResizable(false);
        // 增加键盘事件, 用于通过空格键操作游戏
        frame.addKeyListener(new BodyKey(body));
        // 开始载入游戏系统, 循环开始
        body.start();
    }

    /**
     * 通过图片路径生成 BufferedImage 对象
     * 
     * @param name 图片路径
     * @return BufferedImage 对象
     */
    public static BufferedImage loadImage(String name) {
        try {
            BufferedImage image = ImageIO.read(Main.class.getResource(name));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
