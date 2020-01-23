import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    Board board;
    boolean spacePressed, rightPressed, leftPressed;

    public Game(){

         setTitle("SPACE THING");
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         board = new Board(this);
         add(board);
         addKeyListener(this);
         pack();

         board.setup();
         setLocationRelativeTo(null);

    }

    public static void main(String[] args){

        new Game();

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
    }

    public boolean isSpacePressed(){
        return spacePressed;
    }
}
