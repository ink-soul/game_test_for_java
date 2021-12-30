import javax.swing.ImageIcon;
import java.awt.Graphics;
public class Bullet {
    private ImageIcon bulletImage = new ImageIcon("img/bullet.png");

    private int width = bulletImage.getIconWidth();
    private int height = bulletImage.getIconHeight();

    private int x;
    private int y;


    
    public ImageIcon getBulletImage() {
        return bulletImage;
    }

    public void setBulletImage(ImageIcon bulletImage) {
        this.bulletImage = bulletImage;
    }

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



    public Bullet(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void drawImage(Graphics g){
        g.drawImage(bulletImage.getImage(), x, y, null);
    }

    public void move(){
        y -= 2;
    }
}
