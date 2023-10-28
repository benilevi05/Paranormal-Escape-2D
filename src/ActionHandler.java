import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
    public boolean timePassed = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        timePassed = true;
    }

}
