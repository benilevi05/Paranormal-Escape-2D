import javax.swing.*;

public class Movables extends JPanel implements MoveInterface {
    int x;
    int y;
    int energy;
    int moved;

    @Override
    public boolean moveRight() {
        return false;
    }

    @Override
    public boolean moveLeft() {
        return false;
    }

    @Override
    public boolean jumpRight() {
        return false;
    }

    @Override
    public boolean jumpLeft() {
        return false;
    }
}
