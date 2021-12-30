import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Graphics;
import java.awt.*;




public  class MyJPanel extends JPanel implements KeyListener{


    private ImageIcon heroImage = new ImageIcon("img/hero.gif");
    private int width = heroImage.getIconWidth();
    private int height = heroImage.getIconHeight();
    private int heroX=275;
    private int heroY=100;
    int Number;

    
    List<Enemy> enemies = new ArrayList<Enemy>();
    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Bomb> bombs = new ArrayList<Bomb>();
    List<heroDead> heroDeads=new ArrayList<heroDead>();
    List<Skill> fireballs=new ArrayList<Skill>();
    

    public  MyJPanel(){

        for(int i = 0;i<10;i++){
        enemies.add(new Enemy());
        
        }

    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        ImageIcon bg = new ImageIcon("img/background.jpg");
        g.drawImage(bg.getImage(), 0, 0, null);
        g.drawImage(heroImage.getImage(),heroX,heroY,null);
        g.setFont(new Font("宋体",Font.BOLD,30));
        g.drawString("当前得分:"+Number, 5,30);

        for(int i=0;i<enemies.size();i++){
            Enemy enemy = enemies.get(i);
            enemy.drawImage(g);
            
            /*if(enemies.size()>Number/10+3){
                enemies.remove(enemy);
                }
            else if(enemies.size()>1000){  
                enemies.remove(enemy);
            }*/

        }
        for(int i = 0;i<bullets.size();i++){
            Bullet bullet = bullets.get(i);
                bullet.drawImage(g);
        }

        for(int i = 0;i<bombs.size();i++){
            Bomb bomb =bombs.get(i);
            bomb.drawImage(g);
        }
        for(int i =0;i<heroDeads.size();i++){
            heroDead heroDead=heroDeads.get(i);
            heroDead.drawImage(g);

        }

        for(int i =0;i<fireballs.size();i++){
            Skill fireball=fireballs.get(i);
            fireball.drawImage(g);
        }


    }

    
    /*@Override
    public void mouseMoved(MouseEvent e){
        
        int x = e.getX();
        int y = e.getY();
        heroX = x-heroImage.getIconWidth()/2;
        heroY = y-heroImage.getIconHeight()/2;
        repaint();
    
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        heroX = x-heroImage.getIconWidth()/2;
        heroY = y-heroImage.getIconHeight()/2;
        repaint();
        
    }*/

    public void init() {

        int flag = 0;
        while(true){
            flag++;
            if(flag==50){
               bullets.add(new Bullet(heroX+width/2, heroY)); 
               
               flag = 0;
               System.out.println(/*enemies.size()+fireballs.size()+*/bullets.size());
            }
            
            for(int i = 0;i<bullets.size();i++){
                Bullet bullet = bullets.get(i);
                bullet.move();

                if(bullet.getX()>900){
                    bullets.remove(bullet);
                    
                }
            }

            for(int i = 0;i<fireballs.size();i++){
                Skill fireball = fireballs.get(i);
                    fireball.move();

                if(fireball.getX()>900){
                    fireballs.remove(fireball);
                    
                }
            }
            

        for(int i = 0;i<enemies.size();i++){
           Enemy en = enemies.get(i);
            en.move();
            //超出屏幕范围后移除对象
            if(en.getEnemyX()<0){
                enemies.remove(en);

                enemies.add(new Enemy());
            }

            //碰撞判定，碰撞则移除敌机与子弹，添加爆炸
            for(int j = 0;j<bullets.size();j++){
                Bullet bu = bullets.get(j);
                //敌机与子弹的碰撞判定
                if(isHit(en,bu)){
                    enemies.remove(en);
                    if(enemies.size()<10){
                    enemies.add(new Enemy());}

                    bullets.remove(bu);

                    bombs.add(new Bomb(en.getEnemyX(), en.getEnemyY()));
                    Number += 10;

                }


                for(int m = 0;m<fireballs.size();m++){
                    Skill fireba = fireballs.get(m);
                    //敌机与子弹的碰撞判定
                    if(isHit(fireba,en)){
                        enemies.remove(en);
                        if(enemies.size()<10){
                        enemies.add(new Enemy());}
                        
                        bombs.add(new Bomb(en.getEnemyX(), en.getEnemyY()));
                        Number += 10;
    
                    }
                }
                //敌机与英雄机碰撞判定
                if(isHit(en)){
                    //敌机的对象移除
                    enemies.remove(new Enemy());
                    heroDeads.add(new heroDead(heroX,heroY));
                    
                    return;
                }

                
                    
                
            }
            //间隔时间消除对象
            for(int j = 0;j<bombs.size();j++){
                Bomb bomb=bombs.get(j);
                bomb.move();//计算次数，循环固定次数后消除对象

                if(bomb.getCount()>6){
                    bombs.remove(bomb);
                }
            }

            
            //每次的移动都需要停顿一下
            try {
                Thread.sleep(6);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }  //单位是ms
            repaint();
        }}
}
    //敌机与英雄机
    private boolean isHit(Enemy en) {
        Rectangle rect=new Rectangle(heroX,heroY,width,height);
        Point point = new Point(en.getEnemyX()+en.getWidth()/2,en.getEnemyY()+en.getHeight()/2);
        return rect.contains(point);
    }

    private boolean isHit(Enemy en, Bullet bu) {
        //敌机碰撞面积
        Rectangle rect = new Rectangle(en.getEnemyX(),en.getEnemyY(),en.getWidth(),en.getHeight());
        //子弹位置在中间
        Point point = new Point(bu.getX()+bu.getWidth()/2,bu.getY()+bu.getHeight()/2);


        return rect.contains(point);
    }

    private boolean isHit(Skill fireba,Enemy en) {
        //敌机碰撞面积
        Point point = new Point(en.getEnemyX()+en.getWidth()/2,en.getEnemyY()+en.getHeight()/2);
        Rectangle rect2 = new Rectangle(fireba.getX(),fireba.getY(),fireba.getWidth(),fireba.getHeight());
        //Point point = new Point(fireba.getX()+fireba.getWidth()/2,fireba.getY()+fireba.getHeight()/2);


        return rect2.contains(point);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyChar()=='w')
		{
			
			if(heroY>100){
                heroY=heroY-100;
            }
			repaint();
		}
		if(e.getKeyChar()=='s')
		{
			if(heroY<=500){
                heroY=heroY+100;
            }
			repaint();
		}
		
		if(e.getKeyChar()=='a')
		{
			if(heroX>=325){
                heroX=heroX-80;
            }
			repaint();
		}
		if(e.getKeyChar()=='d')
		{
			if(heroX<=900){
                heroX=heroX+80;
            }
			repaint();
		}
        if(e.getKeyChar()=='j'){
            int i,Y;
            Random random = new  Random();
            int X = 300;
            
            i=random.nextInt(5);
            switch (i){
                case 1:Y=100;
                        break;
                case 2:Y=200;
                        break;
                case 3:Y=300;
                        break;
                case 4:Y=400;
                        break;
                case 5:Y=500;
                        break;
                default:Y=100;
            };
            fireballs.add(new Skill(X,Y));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
