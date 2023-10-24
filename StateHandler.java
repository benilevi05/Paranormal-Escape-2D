import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;


public class StateHandler {
    JFrame window;
    public StateHandler(JFrame window) {
        this.window = window;
        

    }
    void gameStart(){
        Player player = new Player();
        Ghost[] ghosts = new Ghost[Game.GHOST_AMOUNT];
        for (int i = 0; i < Game.GHOST_AMOUNT; i++) {
            Ghost ghost = new Ghost();
            ghosts[i] = ghost;
        }
        Grid grid = new Grid(player, ghosts);
        ScoreHandler sh = new ScoreHandler();
        sh.readCSV();
        DisplayPanel display = new DisplayPanel(sh.highScore());
        window.add(grid);
        window.add(display, BorderLayout.EAST);
        window.pack();
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playMusic();
        new TurnHandler(player, grid, window, ghosts, display, sh);
    }
    public void createMenu(){
        Menu menu = new Menu();
        window.add(menu);
        window.pack();
        System.out.println("created");

    }
}
