import javax.swing.*;

public class GameMain {
    static final int WIDTH=1440;
    static final int HEIGHT=1280;
public static void main(String[] args) {
    
    JFrame jFrame = new JFrame();
    jFrame.setSize(WIDTH,HEIGHT);
    jFrame.setTitle("飞机大战");
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLocationRelativeTo(null);

    MyJPanel pl = new MyJPanel();
    jFrame.add(pl);
    jFrame.addMouseMotionListener(pl);

    jFrame.setVisible(true);
    
    pl.init();
    }

}





