import javax.swing.ImageIcon;
import java.awt.Graphics;
public class heroDead {
    private ImageIcon heroImage = new ImageIcon("img/hero_destory.png");
    private int width= heroImage.getIconWidth();
    private int height = heroImage.getIconHeight();
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
    

    public heroDead(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void drawImage(Graphics g){
        g.drawImage(heroImage.getImage(), x, y, null);
    }
}
