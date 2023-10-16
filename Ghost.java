import java.util.Random;

public class Ghost extends Movables {

    Random random = new Random();

    public Ghost() {
        spawn();
    }   

    void spawn() {
        int rowPos = random.nextInt(Grid.ROW_AMOUNT);
        int colPos = random.nextInt(Grid.COLUMN_AMOUNT);

        x = (rowPos * Grid.TILE_SIZE) + (Grid.TILE_SIZE / 2);
        y = (colPos * Grid.TILE_SIZE) + (Grid.TILE_SIZE / 2);
        if ((Grid.ROW_AMOUNT / 2.0) - 1 < rowPos || rowPos >  (Grid.ROW_AMOUNT / 2.0) + 1
        && (Grid.COLUMN_AMOUNT / 2.0) - 1 < colPos || colPos >  (Grid.COLUMN_AMOUNT / 2.0) + 1) {
            System.out.println("X:" + x + "Y:" + y);
        } else {
            spawn();
        }
    }
    
}
