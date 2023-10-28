import javax.swing.*;

public class Game {
    public static final int GHOST_AMOUNT = 2;
    public Player player;
    public Ghost[] ghosts;
    public Grid grid;
    public DisplayPanel display;
    public Thread gameThread;
    JFrame window;

    void start() {
        SwingUtilities.invokeLater(() -> {
            window = new JFrame("Paranormal Escape 2D");
            window.setResizable(false);
            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            startGameThread();
            StateHandler sh = new StateHandler(window);
            sh.createMenu();
        });
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