package UI;

import javax.swing.*;

public class Text {
    public static void main(String[] args) {
        //主界面
        JFrame gameJframe = new JFrame();
        gameJframe.setVisible(true);
        gameJframe.setSize(603,680);
        gameJframe.setDefaultCloseOperation(3);
        //登录界面
        JFrame loginJframe = new JFrame();
        loginJframe.setVisible(true);
        loginJframe.setSize(488,430);
        loginJframe.setDefaultCloseOperation(3);
        //注册界面
        JFrame registerJframe = new JFrame();
        registerJframe.setVisible(true);
        registerJframe.setSize(488,500);
        registerJframe.setDefaultCloseOperation(3);
    }
}
