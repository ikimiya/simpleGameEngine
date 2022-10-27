import javax.swing.*;
import java.awt.*;

public class JavaMain extends JFrame{

    public static void main(String[] args){
        new JavaMain();

    }

    public JavaMain(){
        createGui();
    }

    public JavaMain(String s){
        setTitle(s);
    }

    public void createGui(){
        JavaMain jm = new JavaMain("Game Engine");

        // create Scene and initalize values
        Scene scene = new Scene();
        scene.setBackground("src/images/background.png");
        scene.setPosition(0,0);
        scene.setSize(800,600);
        scene.init();

        // create top and bottom labels
        GameLabel gLabel = new GameLabel(scene,jm);
        jm.add(gLabel.getBot(),BorderLayout.SOUTH);
        jm.add(gLabel.getTop(),BorderLayout.NORTH);
        jm.add(scene,BorderLayout.CENTER);

        jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jm.setSize(800,600);
        jm.setVisible(true);
        jm.setResizable(true);
        jm.setLocationRelativeTo(null);
    }



}