import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Grid extends JPanel {
    final static int ORIGINAL_TILE_SIZE = 16;
    final static int SCALE = 4;

    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; //48 x 48
    public final int rowAmount = 12;
    public final int columnAmount = 12;
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
         try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("Background.png"));
            g2.drawImage(image, 0, 0, null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Color myColor = new Color(211, 211, 211, 60);
        g2.setColor(myColor);

        for (int x = 6; x < rowSize; x = x + 64){
            for (int y = 6; y < columnSize; y= y + 64){
                g2.fillRect(x, y, 52, 52);
            }
        } 

       


        g2.dispose();

    
    }

}
