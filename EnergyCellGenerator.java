import java.util.Random;

public class EnergyCellGenerator {
    EnergyCell Generate(){
        Random random = new Random();
        int cellProb = random.nextInt(4);
        if (cellProb != 0){
            return null;
        } else{

            EnergyCell cell = new EnergyCell(random.nextInt(Grid.ROW_AMOUNT)*Grid.TILE_SIZE + Grid.TILE_SIZE/2
                                            , random.nextInt(Grid.COLUMN_AMOUNT)*Grid.TILE_SIZE + Grid.TILE_SIZE/2);
            return cell;
        }

    }
}
