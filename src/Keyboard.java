import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Keyboard implements KeyListener {


    Boolean[] keyDown;
    int currentkey = -1;

    public Keyboard(){

    }

    public void createKeys(){
        for(int i = 0; i < 256; i++){
            keyDown[i] = false;
        }
    }

    public void clearKeys(KeyEvent e){
        currentkey = -1;
        keyDown[e.getKeyCode()] = false;
    }

    public void checkKeys(KeyEvent e){
        currentkey = e.getKeyCode();
        keyDown[e.getKeyCode()] = true;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
