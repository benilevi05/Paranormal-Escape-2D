import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class EnergyCell extends JPanel{
    BufferedImage cellImage;
    public int x,y;
    
    public EnergyCell(int x, int y){
        this.x = x;
        this.y = y;
        getCellImage();
        System.out.println(x+","+y);
    }

    public void destroy(){
        this.x = 0;
        this.y = 0;
        this.setVisible(false);
    }

    public void getCellImage(){
        try {
            cellImage = ImageIO.read(getClass().getResourceAsStream("Cell.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        long num = Math.round(Grid.TILE_SIZE * (3.0 / 4.0));
        int num2 = (int) num;
        g2.drawImage(cellImage, x - 24, y - 24, num2, num2, null);
    }
}
