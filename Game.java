import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
    public Player player;
    public Grid grid;
    public Thread gameThread;
    public KeyHandler keyH;
    public ActionHandler aH; 
    public Timer timer;
    int FPS = 60;

    public void start() {
        JFrame window = new JFrame("Paranormal Escape 2D");
        keyH = new KeyHandler();
        aH = new ActionHandler();
        player = new Player();
        grid = new Grid(player);
        window.addKeyListener(keyH);
        window.add(grid);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startGameThread();
        timer = new Timer(1000, aH);
        gameLoop();
    }

    public void gameLoop() {
        while(gameThread != null){
            while(!keyH.pressed) {
                System.out.println("Not Pressed");
        }
            playerTurn();
            grid.repaint();
            enemyTurn();
            grid.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    public void playerTurn(){
        player.moveRight(); 
    }
    
    public void enemyTurn(){

    }
    public void startGameThread(){
        gameThread = new Thread();
        gameThread.start();
    }
    public static void main(String[] args) {
        new Game().start();;
    }
}