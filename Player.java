import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends Movables {
    public Player() {
        x = 16;
        y = 16;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.PINK);
        g2.fillRect(x, y, Grid.TILE_SIZE / 2, Grid.TILE_SIZE / 2);
    }
}
