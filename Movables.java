public class Movables implements MoveInterface {
    int x;
    int y;
    int energy;
    int moved;

    @Override
    public boolean moveRight(){
        return false;
    }
    @Override
    public boolean moveLeft(){
        return false;
    }
    public boolean jumpRight(){
        return false;
    }
    public boolean jumpLeft(){
        return false;
    }
}
