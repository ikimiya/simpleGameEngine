import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel{

    Scene scene;

    JButton playButton = new JButton("Play Game");



    public GameMenu(Scene scene){
        this.scene = scene;

        setLayout(new GridLayout(1,1));
        setSize(scene.width,scene.height);
        add(playButton);
        this.add(playButton);
    }


    public void draw(Graphics g){

        g.setColor((Color.magenta));
        g.fillRect(0,0,scene.width,scene.height);
        g.setFont(new Font("Verdana",Font.BOLD,30));
        g.setColor(Color.green);
        g.drawString("Menu",scene.width/2 - 50, 100);

    }



}
