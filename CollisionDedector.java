import java.util.ArrayList;

public class CollisionDedector {

    public boolean detectGhostCollision(Player player, Ghost[] ghosts) {
        for (Ghost ghost: ghosts) {
            if (player.x == ghost.x && player.y == ghost.y) {
                return true;
            }
        }
        return false;
    }

    public boolean detectEnergyCollision(Movables movable, ArrayList<EnergyCell> cellArray) {
        if (cellArray != null) {
            for (int i = 0; i < cellArray.size(); i++) {
                EnergyCell cell = cellArray.get(i);
                if (movable.x == cell.x && movable.y == cell.y) {
                    cellArray.remove(i);
                    return true;
                }
            }
        }
        return false;
    }


}
