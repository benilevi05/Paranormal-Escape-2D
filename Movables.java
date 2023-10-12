import javax.swing.*;

public class Movables extends JPanel implements MoveInterface {
    int x = 0;
    int y = 0;
    int energy;
    int moved;

    @Override
    public boolean moveRight() {
        System.out.println("Moved");
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
