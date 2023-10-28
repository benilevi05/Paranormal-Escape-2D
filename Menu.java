import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu extends JPanel{
    public Menu(){
        this.setPreferredSize(new Dimension(Grid.ROW_SIZE + (2*Grid.TILE_SIZE) , Grid.COLUMN_SIZE));
        this.setDoubleBuffered(true);
        this.setLayout(new GridBagLayout());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("Background.png"));
            g2.drawImage(image, 0, 0, Grid.COLUMN_SIZE + 2 * Grid.TILE_SIZE, Grid.ROW_SIZE, null);
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}