import javax.swing.*;

public class Movables extends JPanel implements MoveInterface {
    int x;
    int y;
    int energy;
    int moved;

    @Override
    public boolean moveRight() {
        x += Grid.TILE_SIZE;
        return false;
    }

    @Override
    public boolean moveLeft() {
        x -= Grid.TILE_SIZE;
        return false;
    }

    @Override
    public boolean moveUp() {
        y -= Grid.TILE_SIZE;
        return false;
    }

    @Override
    public boolean moveDown() {
        y += Grid.TILE_SIZE;
        return false;
    }

    @Override
    public boolean jumpRight() {
        x += Grid.TILE_SIZE * 2;
        energy -= 1;
        return false;
    }

    @Override
    public boolean jumpLeft() {
        x -= Grid.TILE_SIZE * 2;
        energy -= 1;
        return false;
    }

    @Override
    public boolean jumpUp() {
        y -= Grid.TILE_SIZE * 2;
        energy -= 1;
        return false;
    }

    @Override
    public boolean jumpDown() {
        y += Grid.TILE_SIZE * 2;
        energy -= 1;
        return false;
    }
}
