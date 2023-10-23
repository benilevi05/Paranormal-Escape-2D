import javax.swing.*;
import java.awt.*;


public class Game {
    public static final int GHOST_AMOUNT = 2;
    public Player player;
    public Ghost[] ghosts;
    public Grid grid;
    public DisplayPanel display;
    public Thread gameThread;

    void start() {
        JFrame window = new JFrame("Paranormal Escape 2D");

        player = new Player();
        ghosts = new Ghost[GHOST_AMOUNT];
        for (int i = 0; i < GHOST_AMOUNT; i++) {
            Ghost ghost = new Ghost();
            ghosts[i] = ghost;
        }
        grid = new Grid(player, ghosts);
        display = new DisplayPanel();
        window.add(grid);
        window.add(display, BorderLayout.EAST);
        window.pack();
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playMusic();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startGameThread();
        new TurnHandler(player, grid, window, ghosts, display);
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