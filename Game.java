import javax.swing.*;
import java.awt.*;

public class Game {
    public Player player;
    public Ghost ghost;
    public Grid grid;
    public Thread gameThread;

    void start() {
        JFrame window = new JFrame("Paranormal Escape 2D");
        player = new Player();
        ghost = new Ghost();
        grid = new Grid(player);
        window.add(grid);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startGameThread();
        new TurnHandler(player, grid, window);
    }

    void startGameThread() {
        gameThread = new Thread();
        gameThread.start();
    }

    public static void main(String[] args) {
        new Game().start();
        ;
    }
}