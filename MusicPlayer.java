import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicPlayer {
    String filePath;
    Clip clip;
    MusicPlayer(){
        filePath = "spookymusic.wav";
    }

    public void playMusic(){
        try{
            File musicFile = new File(filePath);

            if (musicFile.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Cant find file.");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void stopMusic(){
        clip.stop();
    }
}
