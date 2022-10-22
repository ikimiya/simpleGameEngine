import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    private String filePath;
    private Clip clip;
    private AudioInputStream audio;
    private LineListener listener;


    public Sound(String path){
        filePath = path;
        try {
            audio = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();


        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        listener = new LineListener() {
            @Override
            public void update(LineEvent event) {
                if (event.getType() != LineEvent.Type.STOP) {
                    return;
                }

                if(clip == null) {
                    return;
                }

                clip.close();
            }
        };

    }

    public void changeSound(String path){
        filePath = path;
    }

    public void updateSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

    }

    public void playSound(){

        boolean playing = clip.isRunning();
        if(playing) {
            return;
        }

        boolean lineOpen = clip.isOpen();
        if(!lineOpen) {
            openLine();
        }

        clip.setFramePosition(0);
        clip.start();

        /*
        try {
            clip.open(audio);

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

        }

         */
    }

    public void openLine(){
        try {
            clip.open(audio);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }




}
