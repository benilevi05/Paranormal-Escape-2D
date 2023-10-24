import java.awt.*;

import javax.swing.*;

public class Menu extends JPanel{
    public Menu(){
        this.setPreferredSize(new Dimension(Grid.ROW_SIZE+(2*Grid.TILE_SIZE), Grid.COLUMN_SIZE));
        this.setDoubleBuffered(true);
    }

    @Override
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawString("The Paranormal Escape",200,200);
        
    }
}