package top.apee.birdFly2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 工具类
 */
public class Tool {
    /**
     * 根据图片路径，返回BufferedImage对象
     * 
     * @param name 图片路径
     * @return
     */
    public static BufferedImage loadImage(String name) {
        try {
            BufferedImage image = ImageIO.read(Tool.class.getResource(name));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}