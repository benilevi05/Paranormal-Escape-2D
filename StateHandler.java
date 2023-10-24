import javax.swing.*;
import java.awt.*;


public class StateHandler {
    JFrame window;
    Menu menu;
    Grid grid;
    DisplayPanel display;
    MusicPlayer musicPlayer;

    public StateHandler(JFrame window) {
        this.window = window;
        

    }
    void gameStart(){
        menu.setVisible(false);
        window.remove(menu);

        Player player = new Player();
        Ghost[] ghosts = new Ghost[Game.GHOST_AMOUNT];
        for (int i = 0; i < Game.GHOST_AMOUNT; i++) {
            Ghost ghost = new Ghost();
            ghosts[i] = ghost;
        }
        grid = new Grid(player, ghosts);
        ScoreHandler sh = new ScoreHandler();
        sh.readCSV();
        display = new DisplayPanel(sh.highScore());
        window.add(grid);
        window.add(display, BorderLayout.EAST);
        window.pack();
        musicPlayer = new MusicPlayer();
        musicPlayer.playMusic();
        TurnHandler th = new TurnHandler(player, grid, window, ghosts, display, sh, this);
        grid.requestFocusInWindow();
        grid.addKeyListener(th);
    }
    public void createMenu(){

        try {
            window.remove(grid);
            window.remove(display);
            grid.setVisible(false);
            display.setVisible(false);
            musicPlayer.stopMusic();
        } catch (Exception e) {
            //Ignore
        }

        menu = new Menu();

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Paranormal Escape 2D");
        titlePanel.add(titleLabel);

        JButton startButton = new JButton("Start");
        JPanel startPanel = new JPanel();
        startPanel.add(startButton);

        startButton.addActionListener(e -> { //Lambda function.
            gameStart();
        });

        JButton exitButton = new JButton("Exit Game");
        JPanel exitPanel = new JPanel();
        exitPanel.add(exitButton);

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        menu.add(titlePanel, c);
        c.gridx = 0;
        c.gridy = 1;
        menu.add(startPanel, c);
        c.gridx = 0;
        c.gridy = 2;
        menu.add(exitPanel, c);


        window.add(menu);
        window.pack();
    }
}
