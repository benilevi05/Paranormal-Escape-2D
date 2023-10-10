import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48 x 48
    final int rowAmount = 16;
    final int columnAmount = 16;
    final int rowSize = tileSize * rowAmount; 
    final int columnSize = tileSize * columnAmount;

    public Grid(){
        this.setPreferredSize(new Dimension(rowSize, columnSize));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }
}
