import java.util.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;


public class Enemy {
    private ImageIcon enemyImage = new ImageIcon("img/enemy.png");
    

    private int width = enemyImage.getIconWidth();
    private int height = enemyImage.getIconHeight();

    private int enemyX;
    private int enemyY;

    


    public ImageIcon getEnemyImage() {
        return enemyImage;
    }

    public void setEnemyImage(ImageIcon enemyImage) {
        this.enemyImage = enemyImage;
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

    public int getEnemyX() {
        return enemyX;
    }

    public void setEnemyX(int enemyX) {
        this.enemyX = enemyX;
    }

    public int getEnemyY() {
        return enemyY;
    }

    public void setEnemyY(int enemyY) {
        this.enemyY = enemyY;
    }

    public Enemy(){
    Random random = new  Random();
    enemyX = random.nextInt(GameMain.WIDTH-width/2);
    enemyY = -random.nextInt(GameMain.HEIGHT-height/2);
    }
    
    public void drawImage(Graphics g){
        g.drawImage(enemyImage.getImage(), enemyX, enemyY, null);
        
        
    }

    public void move() {
        enemyY += 2;//速度控制
    }


    
    

   
}
