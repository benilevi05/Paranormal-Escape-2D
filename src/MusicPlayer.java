import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class MusicPlayer {
    String gamefilePath;
    String menufilePath;
    Clip gameClip;
    Clip menuClip;

    MusicPlayer() {
        gamefilePath = "res/spookymusic.wav";
        menufilePath = "res/bonetrousle.wav";
    }

    public void playGameMusic() {
        try {
            File musicFile = new File(gamefilePath);

            if (musicFile.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
                gameClip = AudioSystem.getClip();
                gameClip.open(audioInput);
                FloatControl gainControl = (FloatControl) 
                    gameClip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-10.0f);
                gameClip.start();
                gameClip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Cant find file.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playMenuMusic() {
        try {
            File musicFile = new File(menufilePath);

            if (musicFile.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
                menuClip = AudioSystem.getClip();
                menuClip.open(audioInput);
                FloatControl gainControl = (FloatControl) 
                    menuClip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-20.0f);
                menuClip.start();
                menuClip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Cant find file.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stopGameMusic() {
        try {
            gameClip.stop();
        } catch(Exception e) {
            System.out.println(e);
        }
        
    }

    public void stopMenuMusic() {
        try {
            menuClip.stop();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}