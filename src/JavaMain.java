import javax.swing.*;
import java.awt.*;

public class JavaMain extends JFrame{




    public static void main(String[] args){
        new JavaMain();

    }

    public JavaMain(){

        Keyboard k = new Keyboard();
        createGui();
    }

    public JavaMain(String s){
        setTitle(s);
    }

    public void createGui(){
        JavaMain jm = new JavaMain("Game Engine");
        Scene scene = new Scene();
        jm.add(scene);

        jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jm.setSize(800,600);
        jm.setVisible(true);
        jm.setResizable(true);
        jm.setLocationRelativeTo(null);

    }


}