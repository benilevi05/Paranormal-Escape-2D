import java.util.ArrayList;

public class CollisionDedector {

    public boolean detectGhostCollision(Player player, Ghost[] ghosts){
        for (Ghost ghost: ghosts) {
            if (player.x == ghost.x && player.y == ghost.y) {
                return true;
            }
        }
        return false;
    }
    public boolean detectEnergyCollision(Movables movable, ArrayList<EnergyCell> CellArray){
        if (CellArray != null){
            for (int i = 0; i < CellArray.size(); i++){
                EnergyCell cell = CellArray.get(i);
                if (movable.x == cell.x && movable.y == cell.y){
                    CellArray.remove(i);
                    return true;
                }
            }
        }
        return false;
    }


}
