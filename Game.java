import javax.swing.*;
import java.awt.*;

public class Game {
    public void run(){
        JFrame window = new JFrame("Paranormal Escape 2D");
        Player player = new Player();
        Grid grid = new Grid(player);
        window.add(grid);

        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public static void main(String[] args) {
        new Game().run();;
    }
}