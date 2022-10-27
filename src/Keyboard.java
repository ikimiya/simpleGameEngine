import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {

    // create Array of boolean null
    boolean[] keyDown = new boolean[256];

    // -1 = null int
    int currentKey = -1;

    // initals keys as false
    public void createKeys(){
        for(int i = 0; i < 256; i++){
            keyDown[i] = false;
        }
        //System.out.println(keyDown[0]);
    }

    // when release set keys to false
    public void clearKeys(KeyEvent e){
        currentKey = -1;
        keyDown[e.getKeyCode()] = false;
    }

    // if press check keys
    public void checkKeys(KeyEvent e){
        currentKey = e.getKeyCode();
        keyDown[e.getKeyCode()] = true;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

}
