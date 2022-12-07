package top.apee.birdFly2;

import javax.swing.JFrame;

/**
 * 像素鸟游戏
 * 
 * @author 欧阳鹏
 * @author 2.0
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("像素鸟");
        frame.setSize(446, 630);
        frame.setLocationRelativeTo(null);
        GamePane panel = new GamePane();
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
        panel.startLoop();
    }
}
