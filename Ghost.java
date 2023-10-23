import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Ghost extends Movables {

    Random random = new Random();
    BufferedImage ghostImage;

    public Ghost() {
        spawn();

        getGhostImage();
    }   

    void spawn() {
        int rowPos = random.nextInt(Grid.ROW_AMOUNT);
        int colPos = random.nextInt(Grid.COLUMN_AMOUNT);

        x = (rowPos * Grid.TILE_SIZE) + (Grid.TILE_SIZE / 2);
        y = (colPos * Grid.TILE_SIZE) + (Grid.TILE_SIZE / 2);
        if ((Grid.ROW_AMOUNT / 2.0) - 2 < rowPos || rowPos >  (Grid.ROW_AMOUNT / 2.0) + 2
        && (Grid.COLUMN_AMOUNT / 2.0) - 2 < colPos || colPos >  (Grid.COLUMN_AMOUNT / 2.0) + 2) {
            System.out.println("X:" + x + "Y:" + y);
        } else {
            spawn();
        }
    }

    public void ghostAI(Player player, EnergyCell cell){
        String moveToX;
        String moveToY;
        //x movement
        if (player.x == this.x) { //if the player and ghost is in the same x, it doesnt get a chance to move towards X.
            moveToX = "0";
        } else if (player.x > this.x) {
            moveToX = "+";
        } else {
            moveToX = "-";
        }  
        
        if (energy == 0 && !(Math.abs(player.x - this.x) < 2)) {
            if (cell.x - this.x < 3 * Grid.TILE_SIZE) {
                moveToX = "+";
            } else if (this.x - cell.x < 3 * Grid.TILE_SIZE) {
                moveToX= "-";
            }
        }

        if (player.y == this.y) { //if the player and ghost is in the same y, it doesnt get a chance to move towards Y.
            moveToY = "0";
        } else if (player.y > this.y) {
            moveToY = "+";
        } else {
            moveToY = "-";
        }

        if (energy == 0 && !(Math.abs(player.y - this.y) < 2)) {
            if (cell.y - this.y < 3 * Grid.TILE_SIZE) {
                moveToY = "+";
            } else if (this.y - cell.y < 3 * Grid.TILE_SIZE) {
                moveToY= "-";
            }
        }
        
        

        if (!(moveToX.equals("0")) && !(moveToY.equals("0"))) { //if both x and y are different, pick random.
            if (random.nextInt(2) == 0) {
                ghostAIMoveTowardsX(moveToX);
            } else {
                ghostAIMoveTowardsY(moveToY);
            }
        } else if (moveToX.equals("0")) { //if x's are same, go to y.
            ghostAIMoveTowardsY(moveToY);
        } else if (moveToY.equals("0")) { //if y's are same, go to x.
            ghostAIMoveTowardsX(moveToX); 
        } 

    }

    public void ghostAI(Player player){
        String moveToX;
        String moveToY;
        //x movement
        if (player.x == this.x) { //if the player and ghost is in the same x, it doesnt get a chance to move towards X.
            moveToX = "0";
        } else if (player.x > this.x) {
            moveToX = "+";
        } else {
            moveToX = "-";
        }  
        
        if (player.y == this.y) { //if the player and ghost is in the same y, it doesnt get a chance to move towards Y.
            moveToY = "0";
        } else if (player.y > this.y) {
            moveToY = "+";
        } else {
            moveToY = "-";
        }


        
        

        if (!(moveToX.equals("0")) && !(moveToY.equals("0"))) { //if both x and y are different, pick random.
            if (random.nextInt(2) == 0) {
                ghostAIMoveTowardsX(moveToX);
            } else {
                ghostAIMoveTowardsY(moveToY);
            }
        } else if (moveToX.equals("0")) { //if x's are same, go to y.
            ghostAIMoveTowardsY(moveToY);
        } else if (moveToY.equals("0")) { //if y's are same, go to x.
            ghostAIMoveTowardsX(moveToX); 
        } 

    }


    void ghostAIMoveTowardsX(String moveToX){
        if (energy > 0) {
            if (moveToX.equals("+")) {
                if (random.nextInt(energy + 1) == 0) {
                    moveRight();
                } else {
                    jumpRight();
                }
            } else {
                if (random.nextInt(energy + 1) == 0) {
                    moveLeft();
                } else {
                    jumpLeft();
                }
            }
        } else { //if energy = 0
            if (moveToX.equals("+")) {
                moveRight();
            } else {
                moveLeft();
            }
        }
    }
    
    void ghostAIMoveTowardsY(String moveToY){
        if (energy > 0) {
            if (moveToY.equals("+")) {
                if (random.nextInt(energy) == 0) {
                    moveDown();
                } else {
                    jumpDown();
                }
            } else {
                if (random.nextInt(energy) == 0) {
                    moveUp();
                } else {
                    jumpUp();
                }
            }
        } else {
            if (moveToY.equals("+")) {
                moveDown();
            } else {
                moveUp();
            }
        }
    }

    public void getGhostImage(){
        try {
            ghostImage = ImageIO.read(getClass().getResourceAsStream("Player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        long num = Math.round(Grid.TILE_SIZE * (3.0 / 4.0));
        int num2 = (int) num;
        g2.drawImage(ghostImage, x - 24, y - 24, num2, num2, null);
    }
}
