import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
    JLabel playerEnergy;
    JLabel enemyDistance1;
    JLabel enemyDistance2;

    DisplayPanel(int highScore){

        this.setPreferredSize(new Dimension(Grid.TILE_SIZE * 2, Grid.COLUMN_SIZE));
        this.setBackground(Color.BLACK);

        JLabel playerName = new JLabel("Player");
        playerEnergy = new JLabel("Energy: " + 5);
        JLabel enemyName1 = new JLabel("Ghost");
        enemyDistance1 = new JLabel("Distance: ?");
        JLabel enemyName2 = new JLabel("Jinn");
        enemyDistance2 = new JLabel("Distance: ?");

        JLabel highScoreLabel = new JLabel("High Score: " + highScore);

        playerName.setForeground(Color.WHITE);
        playerEnergy.setForeground(Color.WHITE);
        enemyName1.setForeground(Color.WHITE);
        enemyDistance1.setForeground(Color.WHITE);
        enemyName2.setForeground(Color.WHITE);
        enemyDistance2.setForeground(Color.WHITE);
        highScoreLabel.setForeground(Color.WHITE);

        this.add(playerName);
        this.add(playerEnergy);
        this.add(enemyName1);
        this.add(enemyDistance1);
        this.add(enemyName2);
        this.add(enemyDistance2);
        this.add(highScoreLabel);
    }

    public void calculateDisplay(Player player, Ghost[] ghosts){
        playerEnergy.setText("Energy: " + player.energy);
        int dist1 = Math.abs((player.x - ghosts[0].x) / Grid.TILE_SIZE) + Math.abs((player.y - ghosts[0].y) / Grid.TILE_SIZE);
        int dist2 = Math.abs((player.x - ghosts[1].x) / Grid.TILE_SIZE) + Math.abs((player.y - ghosts[1].y) / Grid.TILE_SIZE);

        enemyDistance1.setText("Distance: " + dist1);
        enemyDistance2.setText("Distance: " + dist2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream("Background.png"));
            g2.drawImage(image, -768, 0, Grid.COLUMN_SIZE + 2 * Grid.TILE_SIZE, Grid.ROW_SIZE, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
