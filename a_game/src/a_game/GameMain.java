package a_game;
import javax.swing.*;
import java.awt.*;

public class GameMain {
    static final int WIDTH=1400;
    static final int HEIGHT=600;
public static void main(String[] args) {
    
    JFrame jFrame = new JFrame();
    jFrame.setSize(WIDTH,HEIGHT);
    jFrame.setTitle("神仙豌豆大战僵尸珍贵影像");
    
    MyJPanel pl = new MyJPanel();
    jFrame.add(pl,0);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLocationRelativeTo(null);
    jFrame.addKeyListener(pl);

    jFrame.setVisible(true);
    pl.init();
    }



}





