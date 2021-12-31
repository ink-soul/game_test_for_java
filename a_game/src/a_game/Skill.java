package a_game;
import javax.swing.ImageIcon;
import java.awt.Graphics;
public class Skill {
    private ImageIcon fireballImage = new ImageIcon("img/fireball.png");

    private int width = fireballImage.getIconWidth();
    private int height = fireballImage.getIconHeight();

    private int x;
    private int y;


    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Skill(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void drawImage(Graphics g){
        g.drawImage(fireballImage.getImage(), x, y, null);
    }

    public void move(){
        x += 20;
    }
}
