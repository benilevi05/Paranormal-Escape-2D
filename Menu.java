import java.awt.*;

import javax.swing.*;

public class Menu extends JPanel{
    public Menu(){
        this.setPreferredSize(new Dimension(Grid.ROW_SIZE + (2*Grid.TILE_SIZE) , Grid.COLUMN_SIZE));
        this.setDoubleBuffered(true);
        this.setLayout(new GridBagLayout());
    }
}