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
        int i;
    Random random = new  Random();
    enemyX = 1600;
    i=random.nextInt(5);
    switch (i){
        case 1:enemyY=100;
                break;
        case 2:enemyY=200;
                break;
        case 3:enemyY=300;
                break;
        case 4:enemyY=400;
                break;
        case 5:enemyY=500;
                break;
        default:enemyY=100;
    }
    }
    
    public void drawImage(Graphics g){
        g.drawImage(enemyImage.getImage(), enemyX, enemyY, null);
        
        
    }

    public void move() {
        enemyX -= 2;
        //enemyY+=2;//速度控制
    }


    
    

   
}
