import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Test {
    void run(){
        JFrame frame = new JFrame("Test");
        JPanel panel = new JPanel();
        JLabel testLabel = new JLabel("Test");

        KeyHandler kh = new KeyHandler();
        MouseHandler mh = new MouseHandler();

        frame.addKeyListener(kh);
        panel.add(testLabel);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }

    //public static void main(String[] args) {
     //   new Test().run();
    //}
}

class MouseHandler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
