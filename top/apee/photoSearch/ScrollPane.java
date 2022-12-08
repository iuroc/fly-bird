package top.apee.photoSearch;

import javax.swing.*;

public class ScrollPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("滚动条测试");
        JScrollPane scrollPane = new JScrollPane();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 0; i < 30; i++) {
            panel.add(new JButton("按钮"));
        }
        scrollPane.setViewportView(panel);
        frame.setContentPane(scrollPane);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}
