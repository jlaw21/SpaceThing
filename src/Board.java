import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {

   Player player;
   Enemy enemy;
   ArrayList<Bullet> bullets = new ArrayList<Bullet>();
   Enemy[][] enemies = new Enemy[5][10];
   Timer timer;
   Long timeDelay;
   Game game;

   public Board(Game game){
       this.game = game;
       setPreferredSize(new Dimension(1024,900));
       setBackground(Color.BLACK);
       timer = new Timer(1000/60, this);
       timer.start();
   }

   //Gives objects starting positions
   public void setup(){
       player = new Player(this);
       for(int row = 0; row < 5; row++){
           for(int col = 0; col < 10; col++){
               enemies[row][col] = new Enemy(getWidth()/4 + (col*50), row*50);
           }
       }
       timeDelay = System.currentTimeMillis();
   }

   public void checkCollisions(){

   }

   @Override
    public void actionPerformed(ActionEvent e) {
       long currentTime = System.currentTimeMillis();
       //player.moveLeft();
       if(game.isSpacePressed()){
           bullets.add(new Bullet(player));
       }

       for(Bullet bullet: bullets){
           bullet.move();
       }
       if(currentTime - timeDelay >= 1000){
           for(int row = 0; row < 5; row++){
               for(int col = 0; col < 10; col++){
                   enemies[row][col].move();
               }
           }
           timeDelay = System.currentTimeMillis();
       }
       repaint();
    }

   public void paintComponent(Graphics g){
       super.paintComponent(g);

       player.paint(g);
       for(int row = 0; row < 5; row++){
           for(int col = 0; col < 10; col++){
               enemies[row][col].paint(g);
           }
       }
       for(Bullet bullet: bullets){
           bullet.paint(g);
       }

   }


}
