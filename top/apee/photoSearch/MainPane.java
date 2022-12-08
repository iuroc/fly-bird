package top.apee.photoSearch;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.*;

public class MainPane extends JPanel {
    public MainPane() {
        this.setLayout(null);
        ImageList imageList = new ImageList();
        this.add(new SearchBox(imageList));
        this.add(imageList);
    }
}

/**
 * 搜索框组件
 */
class SearchBox extends JPanel {
    ImageList imageList;

    public SearchBox(ImageList imageList) {
        this.imageList = imageList;
        JTextField textField = new JTextField(18);
        textField.setFont(new Font("微软雅黑", Font.BOLD, 16));
        textField.setMargin(new Insets(4, 4, 4, 4));
        SearchButton button = new SearchButton("搜索");
        button.addActionListener(event -> {
            String url = "";
            try {
                String keyword = textField.getText();
                url = "https://vt.sm.cn/api/pic/list?query=" + URLEncoder.encode(keyword, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String result = Request.get(url);
            imageList.loadImgList(result);
        });
        this.add(textField);
        this.add(button);
        this.setBounds(0, 0, 386, 45);
    }
}

/**
 * 按钮
 */
class SearchButton extends JButton {
    public SearchButton(String title) {
        this.setText(title);
        this.setFont(new Font("微软雅黑", Font.BOLD, 16));
        this.setBackground(new Color(0, 105, 217));
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
    }
}

class ImageLable extends JLabel {
    public ImageLable(String url, int width, int height) {
        this.setText("<html><img src='" + url + "' width='" + width + "' height='" + height + "'></html>");
    }
}

/**
 * 图片列表
 */
class ImageList extends JScrollPane {

    JPanel panel;

    public ImageList() {
        this.setBounds(10, 50, 375, 600);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.panel.setBounds(0, 0, 300, 500);
        this.setViewportView(this.panel);
    }

    /**
     * 列表增加图片
     * 
     * @param url        图片URL
     * @param proportion 宽高比
     */
    public void addImage(String url, double proportion) {
        this.panel.add(new ImageLable(url, 355, (int) (355 / proportion)));
    }

    public void clearImage() {
        this.panel.removeAll();
    }

    /**
     * 加载图片列表
     * 
     * @param result 响应的 JSON 文本
     */
    public void loadImgList(String result) {
        this.clearImage();
        String[] list = result.split("\\{\"");
        for (int index = 5; index < list.length; index++) {
            String imgUrl = list[index].split("img\":\"")[1].split("\"")[0];
            String width = list[index].split("\"width\":\"")[1].split("\"")[0];
            String height = list[index].split("\"height\":\"")[1].split("\"")[0];
            this.addImage(imgUrl, Integer.valueOf(width) * 1.0 / Integer.valueOf(height));
        }
        revalidate();
    }
}

class Request {
    public static String get(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String result = response.body();
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
