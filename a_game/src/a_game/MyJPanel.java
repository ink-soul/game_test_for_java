package a_game;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    static int contral = 0;

    
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
        g.drawString("得分"+Number, 5,30);

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
            if(flag==10){
               bullets.add(new Bullet(heroX+width/2, heroY)); 
               
               flag = 0;
               //System.out.println(enemies.size()/*+fireballs.size()+bullets.size()*/);
            }
            
            for(int i = 0;i<bullets.size();i++){
                Bullet bullet = bullets.get(i);
                bullet.move();

                if(bullet.getX()>GameMain.WIDTH){
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
            //瓒呭嚭灞忓箷鑼冨洿鍚庣Щ闄ゅ璞�
            if(en.getEnemyX()<248){
                enemies.remove(en);
                Number -=10;

                enemies.add(new Enemy());
            }

            //纰版挒鍒ゅ畾锛岀鎾炲垯绉婚櫎鏁屾満涓庡瓙寮癸紝娣诲姞鐖嗙偢
            for(int j = 0;j<bullets.size();j++){
                Bullet bu = bullets.get(j);
                //鏁屾満涓庡瓙寮圭殑纰版挒鍒ゅ畾
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
                    //鏁屾満涓庡瓙寮圭殑纰版挒鍒ゅ畾
                    if(isHit(fireba,en)){
                        enemies.remove(en);
                        if(enemies.size()<10){
                        enemies.add(new Enemy());
                        }
                        
                        bombs.add(new Bomb(en.getEnemyX(), en.getEnemyY()));
                        Number += 10;
    
                    }
                }
                //鏁屾満涓庤嫳闆勬満纰版挒鍒ゅ畾
                if(isHit(en)){
                    //鏁屾満鐨勫璞＄Щ闄�
                    enemies.remove(new Enemy());
                    heroDeads.add(new heroDead(heroX,heroY));
                    
                    contral =1;
                    repaint();
                  
                    return;
                 
                }

                
                    
                
            }
            //闂撮殧鏃堕棿娑堥櫎瀵硅薄
            for(int j = 0;j<bombs.size();j++){
                Bomb bomb=bombs.get(j);
                bomb.move();//璁＄畻娆℃暟锛屽惊鐜浐瀹氭鏁板悗娑堥櫎瀵硅薄

                if(bomb.getCount()>6){
                    bombs.remove(bomb);
                }
            }

            
            //姣忔鐨勭Щ鍔ㄩ兘闇�瑕佸仠椤夸竴涓�
            try {
                Thread.sleep(6);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }  //鍗曚綅鏄痬s
            repaint();
        }}
}
    //鏁屾満涓庤嫳闆勬満
    private boolean isHit(Enemy en) {
        Rectangle rect=new Rectangle(heroX,heroY,width,height);
        Point point = new Point(en.getEnemyX()+en.getWidth()/2,en.getEnemyY()+en.getHeight()/2);
        return rect.contains(point);
    }

    private boolean isHit(Enemy en, Bullet bu) {
        //鏁屾満纰版挒闈㈢Н
        Rectangle rect = new Rectangle(en.getEnemyX(),en.getEnemyY(),en.getWidth(),en.getHeight());
        //瀛愬脊浣嶇疆鍦ㄤ腑闂�
        Point point = new Point(bu.getX()+bu.getWidth()/2,bu.getY()+bu.getHeight()/2);


        return rect.contains(point);
    }

    private boolean isHit(Skill fireba,Enemy en) {
        //鏁屾満纰版挒闈㈢Н
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
    	 if(contral==0) {
    		 
    	 
        if(e.getKeyChar()=='w')
		{
			
			if(heroY>100){
                heroY=heroY-100;
            }
			repaint();
		}
		if(e.getKeyChar()=='s')
		{
			if(heroY+100>500){
                heroY=500;
            }else
            {
            	heroY = heroY+100;
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
            int i;
            Random random = new  Random();
            int X =heroX;
            int Y=heroY-height;
            
//            i=random.nextInt(5);
            
//            switch (i){
//                case 1:Y=100;
//                        break;
//                case 2:Y=200;
//                        break;
//                case 3:Y=300;
//                        break;
//                case 4:Y=400;
//                        break;
//                case 5:Y=500;
//                        break;
//                default:Y=100;
//            };
    if(Number>=300){
        Number-=300;
            fireballs.add(new Skill(X,Y));
    }
        }
    	 }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
