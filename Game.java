import javax.swing.*;
import java.awt.*;

public class Game {
        Player player;
        Grid grid;

    public void start(){
        JFrame window = new JFrame("Paranormal Escape 2D");
        player = new Player();
        grid = new Grid(player);
        window.add(grid);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameLoop();
    }

    public void gameLoop() {
    }
    
    public static void main(String[] args) {
        new Game().start();;
    }
}