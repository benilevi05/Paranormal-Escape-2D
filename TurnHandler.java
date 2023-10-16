import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class TurnHandler implements KeyListener {

    public boolean pressedUp, pressedDown, pressedRight, pressedLeft, pressedJup, pressedJdown, pressedJright,
            pressedJleft;
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
        if (code == KeyEvent.VK_W) {
            pressedUp = true;
        }
        if (code == KeyEvent.VK_UP) {
            pressedJup = true;
        }
        if (code == KeyEvent.VK_S) {
            pressedDown = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            pressedJdown = true;
        }
        if (code == KeyEvent.VK_D) {
            pressedRight = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            pressedJright = true;
        }
        if (code == KeyEvent.VK_A) {
            pressedLeft = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            pressedJleft = true;
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
        if (code == KeyEvent.VK_W) {
            pressedUp = false;
        }
        if (code == KeyEvent.VK_UP) {
            pressedJup = false;
        }
        if (code == KeyEvent.VK_S) {
            pressedDown = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            pressedJdown = false;
        }
        if (code == KeyEvent.VK_D) {
            pressedRight = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            pressedJright = false;
        }
        if (code == KeyEvent.VK_A) {
            pressedLeft = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            pressedJleft = false;
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
        if (pressedJup) {
            if (!(player.y - (2 * Grid.TILE_SIZE) < 0) && !(player.energy < 1)) {
                player.jumpUp();
                playerTurnOver();
            } else {
                playerNotMoved();
            }
        }
        if (pressedJdown) {
            if (!(player.y + 2 * Grid.TILE_SIZE > Grid.ROW_SIZE) && !(player.energy < 1)) {
                player.jumpDown();
                playerTurnOver();
            } else {
                playerNotMoved();
            }
        }
        if (pressedJright) {
            if (!(player.x + 2 * Grid.TILE_SIZE > Grid.ROW_SIZE) && !(player.energy < 1)) {
                player.jumpRight();
                playerTurnOver();
            } else {
                playerNotMoved();
            }
        }
        if (pressedJleft) {
            if (!(player.x - 2 * Grid.TILE_SIZE < 0) && !(player.energy < 1)) {
                player.jumpLeft();
                playerTurnOver();
            } else {
                playerNotMoved();
            }
        }

    }

    private void playerNotMoved() {
        // Play a error sound
        System.out.println("cant move");
        ah.timePassed = false;
        timer.restart();
    }

    private void playerTurnOver() {
        ah.timePassed = false;
        enemyTurn();
        timer.restart();
    }

    private void enemyTurn() {

    }
}
