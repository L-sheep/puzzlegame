package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GameJframe extends JFrame implements KeyListener, ActionListener {
    int[][] b = new int[4][4];
    //记录数组中0的坐标
    int x = 0;
    int y = 0;
    String path = "D:\\IdeaProject\\puzzlegame\\image\\animal\\animal2\\";
    int [][]win = new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0}
    };
    //设置最小菜单
    JMenuItem replayjMenuItem = new JMenuItem("重新游戏");
    JMenuItem reloginjMenuItem = new JMenuItem("重新登录");
    JMenuItem colsejMenuItem = new JMenuItem("关闭游戏");
    JMenuItem accountjMenuItem = new JMenuItem("公众号");
    JMenuItem girlitem = new JMenuItem("美女");
    JMenuItem animalsitem = new JMenuItem("动物");
    JMenuItem sportitem = new JMenuItem("运动");
    int step = 0;
    public GameJframe(){
        //初始化界面
        initJFrame();

        //初始化菜单
        initJmenubar();

        //打乱数据
        initData();


        //初始化图片
        initimage();

        //显示
        this.setVisible(true);
    }

    private void initData() {

        //打乱一维数组，按照四个一组添加到二维数组中
        int[] temp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        int t;
        //打乱数组
        for (int i = 0; i < temp.length; i++) {
            int r1 = r.nextInt(temp.length);
            t = temp[i];
            temp[i] = temp[r1];
            temp[r1] = t;
        }

        //放于二维数组中
        for (int i = 0; i < temp.length; i++) {
            if(temp [i] == 0)
            {
                x = i / 4;
                y = i % 4;
            }
              b[i / 4][i % 4] = temp[i];
        }


    }
    private void initimage() {
        //清空画面
        this.getContentPane().removeAll();

        //设置胜利图标
        if(Victory()){
            JLabel vic = new JLabel(new ImageIcon("D:\\IdeaProject\\puzzlegame\\image\\win.png"));
            vic.setBounds(203,283,197,73);
            this.getContentPane().add(vic);
        }
        //添加计步器
        JLabel Jstep = new JLabel("步数："+step);
        Jstep.setBounds(50,30,100,20);
        this.getContentPane().add(Jstep);

        //循环添加15张图片
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = b[i][j];
                //创建JLabel容器对象,创建Imageicon对象
                JLabel jLabel = new JLabel(new ImageIcon(path+number+".jpg"));
                //设置容器对象坐标
                jLabel.setBounds(105 * j +83,105 * i + 134,105,105);
                //添加管理容器对象
                this.getContentPane().add(jLabel);

            }
        }

        //添加背景图片\
        JLabel bg = new JLabel(new ImageIcon("D:\\IdeaProject\\puzzlegame\\image\\background.png"));
        bg.setBounds(40,40,508,560);
        this.getContentPane().add(bg);

        //刷新界面
        this.getContentPane().repaint();

    }

    private void initJmenubar() {
        //设置菜单
        JMenuBar jMenuBar = new JMenuBar();

        //设置两个小菜单
        JMenu functionjMenu = new JMenu("功能");
        JMenu aboutjMenu = new JMenu("关于我们");
        JMenu changejMenu = new JMenu("更换图片");


        functionjMenu.add(changejMenu);
        functionjMenu.add(replayjMenuItem);
        functionjMenu.add(reloginjMenuItem);
        functionjMenu.add(colsejMenuItem);
        aboutjMenu.add(accountjMenuItem);

        changejMenu.add(girlitem);
        changejMenu.add(animalsitem);
        changejMenu.add(sportitem);

        //按键添加事件事件监听
        replayjMenuItem.addActionListener(this);
        reloginjMenuItem.addActionListener(this);
        colsejMenuItem.addActionListener(this);
        accountjMenuItem.addActionListener(this);
        girlitem.addActionListener(this);
        animalsitem.addActionListener(this);
        sportitem.addActionListener(this);

        jMenuBar.add(functionjMenu);
        jMenuBar.add(aboutjMenu);
        this.setJMenuBar(jMenuBar);

    }


    private void initJFrame() {
        //设置宽高
        this.setSize(603,680);
        //居中
         this.setLocationRelativeTo(null);
        //永远处于上方
        this.setAlwaysOnTop(true);
        //设置界面标题
        this.setTitle("拼图小游戏 v1.0");
        //设置窗体布局
        this.setLayout(null);
        //结束jvm虚拟机
        this.setDefaultCloseOperation(3);
        //添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65){
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            JLabel bg = new JLabel(new ImageIcon("D:\\IdeaProject\\puzzlegame\\image\\background.png"));
            bg.setBounds(40,40,508,560);
            this.getContentPane().add(bg);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(Victory()){
            return;
        }
        int code = e.getKeyCode();
        if(code == 37){
            if(y != 3){
                b[x][y] = b[x][y + 1];
                b[x][y + 1] = 0;
                y++;
                initimage();
                step ++;
                System.out.println("向左");
            }

        } else if (code == 38) {
            if(x != 3){
                b[x][y] = b[x + 1][y];
                b[x + 1][y] = 0;
                x ++;
                initimage();
                step ++;
                System.out.println("向上");
            }

        }else if (code == 39) {

            if(y != 0){
                b[x][y] = b[x][y - 1];
                b[x][y - 1] = 0;
                y--;
                initimage();
                step ++;
                System.out.println("向右");
            }
        }else if (code == 40) {

            if(x != 0){
                b[x][y] = b[x - 1][y];
                b[x - 1][y] = 0;
                x --;
                initimage();
                step ++;
                System.out.println("向下");
            }
        }else if (code == 65){
            initimage();
        }else if(code == 87){
            //直接胜利
           b = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initimage();
        }
    }
    public boolean Victory(){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if(b[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        if(replayjMenuItem == ob){
            //打乱
            initData();
            //计步器清零
            step = 0;
            //重新加图片
            initimage();

        }else if(reloginjMenuItem == ob){
           this.setVisible(false);
           new LoginJFrame();
        } else if(colsejMenuItem == ob){
            System.exit(0);
        } else if(accountjMenuItem == ob){
            System.out.println("公众号");
            //创建弹窗
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("D:\\IdeaProject\\puzzlegame\\image\\about.png"));
            jDialog.setBounds(0,0,258,258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(314,314);
            jDialog.setLocationRelativeTo(null);
            jDialog.setAlwaysOnTop(true);
            //不关闭当前弹窗无法执行下一步
            //  jDialog.setModal(true);
            jDialog.setVisible(true);
        } else if ( ob == girlitem) {
            Random r = new Random();
            int number1 = r.nextInt(14);
            path = "D:\\IdeaProject\\puzzlegame\\image\\girl\\girl" + number1 + "\\";
            initimage();
        }else if ( ob == animalsitem) {
            Random r = new Random();
            int number2 = r.nextInt(9);
            path = "D:\\IdeaProject\\puzzlegame\\image\\animal\\animal" + number2 + "\\";
            initimage();
        } else if ( ob == sportitem) {
            Random r = new Random();
            int number3 = r.nextInt(11);
            System.out.println(number3);
            path = "D:\\IdeaProject\\puzzlegame\\image\\sport\\sport" + number3 + "\\";
            initimage();
        }
    }
}
