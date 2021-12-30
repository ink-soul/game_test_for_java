import javax.swing.ImageIcon;
import java.awt.Graphics;
public class Bomb {
    private ImageIcon bombImage = new ImageIcon("img/bomb.png");
    private int width=bombImage.getIconWidth();
    private int height = bombImage.getIconHeight();
    private int x;
    private int y;
    private  int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Bomb(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void drawImage(Graphics g){
        g.drawImage(bombImage.getImage(), x, y, null);
    }


    

    public void move() {
        count++;
    }
}
