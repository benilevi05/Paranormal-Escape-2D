import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Movables {
    BufferedImage playerImage;
    public Player() {
        x = 8;
        y = 8;
        getPlayerImage();

    }

    public void getPlayerImage(){
        try{

            playerImage = ImageIO.read(getClass().getResourceAsStream("Player.PNG"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        long num = Math.round(Grid.TILE_SIZE * (3.0/4.0));
        int num2 = (int)num;
        g2.drawImage(playerImage, x, y, num2, num2, null);
    }
}
