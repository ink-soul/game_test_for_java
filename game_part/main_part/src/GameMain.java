import javax.swing.*;
import java.awt.*;

public class GameMain {
    static final int WIDTH=1400;
    static final int HEIGHT=600;
public static void main(String[] args) {
    
    JFrame jFrame = new JFrame();
    jFrame.setSize(WIDTH,HEIGHT);
    jFrame.setTitle("飞机大战");
    ImageIcon bg = new ImageIcon("img/background.jpg");
    JLabel label = new JLabel(bg);
    label.setSize(bg.getIconWidth(),bg.getIconHeight());
    jFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
    JPanel pan =(JPanel)jFrame.getContentPane();
    pan.setOpaque(false);
    
    MyJPanel pl = new MyJPanel();
    
    
    
    pan.add(pl,0);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLocationRelativeTo(null);
    jFrame.addMouseMotionListener(pl);
    jFrame.setVisible(true);
    pl.init();
    }



}





