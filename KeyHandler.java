import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean pressed, pressedJump, pressedUp, pressedDown, pressedRight, pressedLeft;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        pressed = true;
        if(code == KeyEvent.VK_SPACE) {
            pressedJump = true;
        }
        if(code == KeyEvent.VK_W) {
            pressedUp = true;
        }
        if(code == KeyEvent.VK_S) {
            pressedDown = true;
        }
        if(code == KeyEvent.VK_D) {
            System.out.println("Pressed D");
            pressedRight = true;
        }
        if(code == KeyEvent.VK_A) {
            pressedLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        pressed = false;
        if(code == KeyEvent.VK_SPACE) {
            pressedJump = false;
        }
        if(code == KeyEvent.VK_W) {
            pressedUp = false;
        }
        if(code == KeyEvent.VK_S) {
            pressedDown = false;
        }
        if(code == KeyEvent.VK_D) {
            pressedRight = false;
        }
        if(code == KeyEvent.VK_A) {
            pressedLeft = false;
        }
    }
    
}
