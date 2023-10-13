import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class TurnHandler implements KeyListener {

    public boolean pressed, pressedJump, pressedUp, pressedDown, pressedRight, pressedLeft;
    Player player;
    Grid grid;
    JFrame window;
    Timer timer;
    ActionHandler ah;

    public TurnHandler(Player player, Grid grid, JFrame window) {
        this.player = player;
        this.grid = grid;
        this.window = window;
        window.addKeyListener(this);
        ah = new ActionHandler();
        timer = new Timer(1000, ah);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        pressed = true;
        if (code == KeyEvent.VK_SPACE) {
            pressedJump = true;
        }
        if (code == KeyEvent.VK_W) {
            pressedUp = true;
        }
        if (code == KeyEvent.VK_S) {
            pressedDown = true;
        }
        if (code == KeyEvent.VK_D) {
            pressedRight = true;
        }
        if (code == KeyEvent.VK_A) {
            pressedLeft = true;
        }
        if (ah.timePassed) {
            timer.stop();
            playerTurn();
            grid.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        pressed = false;
        if (code == KeyEvent.VK_SPACE) {
            pressedJump = false;
        }
        if (code == KeyEvent.VK_W) {
            pressedUp = false;
        }
        if (code == KeyEvent.VK_S) {
            pressedDown = false;
        }
        if (code == KeyEvent.VK_D) {
            pressedRight = false;
        }
        if (code == KeyEvent.VK_A) {
            pressedLeft = false;
        }
    }

    private void playerTurn() {
        if (pressedRight) {
            if (!(player.x + Grid.TILE_SIZE > Grid.ROW_SIZE)) {
                player.moveRight();
                playerTurnOver();
            } else {
                playerNotMoved();
            }
        }
        if (pressedLeft) {
            if (!(player.x - Grid.TILE_SIZE < 0)) {
                player.moveLeft();
                playerTurnOver();
            } else {
                playerNotMoved();
            }
        }
        if (pressedUp) {
            if (!(player.y - Grid.TILE_SIZE < 0)) {
                player.moveUp();
                playerTurnOver();
            } else {
                playerNotMoved();
            }
        }
        if (pressedDown) {
            if (!(player.y + Grid.TILE_SIZE > Grid.ROW_SIZE)) {
                player.moveDown();
                playerTurnOver();
            } else {
                playerNotMoved();
            }
        }

    }

    private void playerNotMoved() {
        // Play a error sound
        System.out.println("cant move");
    }

    private void playerTurnOver() {
        ah.timePassed = false;
        enemyTurn();
        timer.restart();
    }

    private void enemyTurn() {

    }
}
