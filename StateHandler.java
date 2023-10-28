import java.awt.*;
import javax.swing.*;

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
        window.add(display, BorderLayout.EAST);
        window.add(grid);
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
        menu.setLayout(new BorderLayout());

        JPanel subMenu = new JPanel();
        subMenu.setLayout(new GridBagLayout());

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Paranormal Escape 2D");
        titlePanel.add(titleLabel);
        
        Font titleFont = new Font(Font.SERIF, Font.BOLD, 50);
        titleLabel.setFont(titleFont);

        JButton startButton = new JButton("Start");
        JLabel checkboxDesc = new JLabel("Enemy Visibility");
        JCheckBox ghostCheckbox = new JCheckBox();
        JPanel startPanel = new JPanel();
        checkboxDesc.setForeground(Color.WHITE);
        startPanel.add(startButton);
        startPanel.add(ghostCheckbox);
        startPanel.add(checkboxDesc);

        startButton.addActionListener(e -> { // Lambda function.
            gameStart();
        });

        ghostCheckbox.addItemListener(e -> {
            if (e.getStateChange() == 1) {
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

        JLabel controlsDesc1 = new JLabel("WASD to move.");
        JLabel controlsDesc2 = new JLabel("Arrow keys to jump.");
        JLabel controlsDesc3 = new JLabel("-1 Energy to Jump, Energy Cells give +2 energy.");

        JPanel controlPanel1 = new JPanel();
        JPanel controlPanel2 = new JPanel();
        JPanel controlPanel3 = new JPanel();


        controlPanel1.add(controlsDesc1);
        controlPanel2.add(controlsDesc2);
        controlPanel3.add(controlsDesc3);

        titleLabel.setForeground(Color.WHITE);
        ghostCheckbox.setForeground(Color.WHITE);
        controlsDesc1.setForeground(Color.WHITE);
        controlsDesc2.setForeground(Color.WHITE);
        controlsDesc3.setForeground(Color.WHITE);

        titlePanel.setBackground(new Color(0, 0, 0, 0));
        startPanel.setBackground(new Color(0, 0, 0, 0));
        exitPanel.setBackground(new Color(0, 0, 0, 0));
        controlPanel1.setBackground(new Color(0, 0, 0, 0));
        controlPanel2.setBackground(new Color(0, 0, 0, 0));
        controlPanel3.setBackground(new Color(0, 0, 0, 0));
        ghostCheckbox.setBackground(new Color(0, 0, 0, 0));

        subMenu.setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.ipady = 200;
        c.gridx = 0;
        c.gridy = 0;
        subMenu.add(titlePanel, c);
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 1;
        subMenu.add(startPanel, c);
        c.gridx = 0;
        c.gridy = 2;
        subMenu.add(exitPanel, c);
        c.gridx = 0;
        c.gridy = 3;
        subMenu.add(controlPanel1, c);
        c.gridx = 0;
        c.gridy = 4;
        subMenu.add(controlPanel2, c);
        c.gridx = 0;
        c.gridy = 5;
        subMenu.add(controlPanel3, c);

        menu.add(subMenu, BorderLayout.NORTH);
        menu.setBackground(Color.BLACK);
        window.add(menu); 
        window.pack();

        musicPlayer.playMenuMusic();
    }
}
