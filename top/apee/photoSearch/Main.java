package top.apee.photoSearch;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("图片搜索工具");
        frame.setSize(400, 700);
        MainPane mainPane = new MainPane();
        frame.setContentPane(mainPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
    }
}