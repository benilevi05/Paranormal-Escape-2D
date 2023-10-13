import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
    public Player player;
    public Grid grid;
    public Thread gameThread;

    public void start() {
        JFrame window = new JFrame("Paranormal Escape 2D");
        player = new Player();
        grid = new Grid(player);
        window.add(grid);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new TurnHandler(player, grid, window);
        startGameThread();
    }

    public void startGameThread() {
        gameThread = new Thread();
        gameThread.start();
    }

    public static void main(String[] args) {
        new Game().start();
        ;
    }
}