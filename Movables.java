import javax.swing.*;

public class Movables extends JPanel implements MoveInterface {
    int x = 24;
    int y = 24;
    int energy;
    int moved;

    @Override
    public boolean moveRight() {
        x += 48;
        return false;
    }

    @Override
    public boolean moveLeft() {
        x -= 48;
        return false;
    }

    @Override
    public boolean jumpRight() {
        x += 96;
        return false;
    }

    @Override
    public boolean jumpLeft() {
        x -= 96;
        return false;
    }
}
