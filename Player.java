import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Player extends Movables {
    BufferedImage playerImage;
    Random random = new Random();
    public Player() {
        int ranx = random.nextInt(2);
        int rany = random.nextInt(2);
        //Random spawn in a 2x2 area.
        x = (Grid.ROW_SIZE / 2) - (Grid.TILE_SIZE * ranx) + 32; 
        y = (Grid.COLUMN_SIZE / 2) - (Grid.TILE_SIZE  * rany) + 32;


        energy = 5;
        getPlayerImage();
    }

    public void getPlayerImage(){
        try {
            playerImage = ImageIO.read(getClass().getResourceAsStream("Player.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        long num = Math.round(Grid.TILE_SIZE * (3.0 / 4.0));
        int num2 = (int) num;
        g2.drawImage(playerImage, x - 24, y - 24, num2, num2, null);
    }
}
