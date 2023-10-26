import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Grid extends JPanel {
    final static int ORIGINAL_TILE_SIZE = 16;
    final static int SCALE = 4;

    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 64 x 64
    public static final int ROW_AMOUNT = 12;
    public static final int COLUMN_AMOUNT = 12;
    public static final int ROW_SIZE = TILE_SIZE * ROW_AMOUNT;
    public static final int COLUMN_SIZE = TILE_SIZE * COLUMN_AMOUNT;

    Player player;
    Ghost[] ghosts;
    public ArrayList<EnergyCell> cellArray;
    int[][] pos = new int[ROW_AMOUNT][COLUMN_AMOUNT];

    public Grid(Player player, Ghost[] ghosts) {
        this.player = player;
        this.ghosts = ghosts;
        this.setPreferredSize(new Dimension(ROW_SIZE, COLUMN_SIZE));
        this.setBackground(Color.PINK);
        this.setDoubleBuffered(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("Background.png"));
            g2.drawImage(image, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Color myColor = new Color(211, 211, 211, 60);
        g2.setColor(myColor);

        for (int x = 6; x < ROW_SIZE; x = x + 64) {
            for (int y = 6; y < COLUMN_SIZE; y = y + 64) {
                g2.fillRect(x, y, 52, 52);
            }
        }
        g2.setColor(Color.PINK);
        player.draw(g2);
        if (cellArray != null) {
            for (int i = 0; i < cellArray.size(); i++){
                EnergyCell cell = cellArray.get(i);
                cell.draw(g2);
            }
        }
        for (Ghost ghost: ghosts) {
            ghost.draw(g2);
        }
            
        g2.dispose();

        



    }

}
