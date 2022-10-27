import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    // Class for audio
    private Clip clip;
    private AudioInputStream audio;

    public Sound(String path) {
        // get audio from file and check if compatible
        try {
            audio = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }

    }

    public void playSound(){

        // check if clip is running
        boolean clipRunning = clip.isRunning();
        if(clipRunning) {
            return;
        }

        // check is not open
        boolean clipOpen = clip.isOpen();
        if(!clipOpen) {
            openClip();
        }

        // reset clip set wav to 0 and start
        clip.setFramePosition(0);
        clip.start();
    }

    public void openClip(){
        try {
            clip.open(audio);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

}
