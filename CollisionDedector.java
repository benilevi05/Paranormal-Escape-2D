public class CollisionDedector {

    public boolean detectCollision(Player player, Ghost[] ghosts){
        for (Ghost ghost: ghosts) {
            if (player.x == ghost.x) {
                return true;
            }
        }
        return false;
    }
}
