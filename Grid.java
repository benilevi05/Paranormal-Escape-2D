import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    final static int ORIGINAL_TILE_SIZE = 16;
    final static int SCALE = 3;

    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; //48 x 48
    public final int rowAmount = 16;
    public final int columnAmount = 16;
    final int rowSize = TILE_SIZE * rowAmount; 
    final int columnSize = TILE_SIZE * columnAmount;
    
    Player player;
    int[][] pos = new int[rowAmount][columnAmount];

    public Grid(Player player) {
        this.player = player;
        this.setPreferredSize(new Dimension(rowSize, columnSize));
        this.setBackground(Color.PINK);
        this.setDoubleBuffered(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }
}
