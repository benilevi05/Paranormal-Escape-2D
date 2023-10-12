import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends Movables {

    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.fillRect(100, 100, Grid.TILE_SIZE, Grid.TILE_SIZE);
    }
}
