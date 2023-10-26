import javax.swing.*;
import java.awt.*;

public class StateHandler {
    JFrame window;
    Menu menu;
    Grid grid;
    DisplayPanel display;
    MusicPlayer musicPlayer;
    Ghost[] ghosts;
    boolean ghostVisibility;

    public StateHandler(JFrame window) {
        this.window = window;
        musicPlayer = new MusicPlayer();
    }

    void gameStart() {
        menu.setVisible(false);
        window.remove(menu);
        musicPlayer.stopMenuMusic();

        Player player = new Player();
        ghosts = new Ghost[Game.GHOST_AMOUNT];
        for (int i = 0; i < Game.GHOST_AMOUNT; i++) {
            Ghost ghost = new Ghost(ghostVisibility);
            ghosts[i] = ghost;
        }
        grid = new Grid(player, ghosts);
        ScoreHandler sh = new ScoreHandler();
        sh.readCSV();
        display = new DisplayPanel(sh.highScore());
        window.add(grid);
        window.add(display, BorderLayout.EAST);
        window.pack();
        musicPlayer.playGameMusic();
        TurnHandler th = new TurnHandler(player, grid, window, ghosts, display, sh, this);
        grid.requestFocusInWindow();
        grid.addKeyListener(th);
    }

    public void createMenu() {

        try {
            window.remove(grid);
            window.remove(display);
            grid.setVisible(false);
            display.setVisible(false);
            musicPlayer.stopGameMusic();
        } catch (Exception e) {
            // Ignore
        }

        menu = new Menu();

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Paranormal Escape 2D");
        titlePanel.add(titleLabel);

        JButton startButton = new JButton("Start");
        JCheckBox ghostCheckbox = new JCheckBox("Ënemies Visibility");
        JPanel startPanel = new JPanel();
        startPanel.add(startButton);
        startPanel.add(ghostCheckbox);

        startButton.addActionListener(e -> { // Lambda function.
            gameStart();
        });

        ghostCheckbox.addItemListener(e -> {
        if (e.getStateChange() == 1){
            ghostVisibility = true;
        } else {
            ghostVisibility = false;
            }
        });
        

        JButton exitButton = new JButton("Exit Game");
        JPanel exitPanel = new JPanel();
        exitPanel.add(exitButton);

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
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

        musicPlayer.playMenuMusic();
    }
}
