import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class JavaMain extends JFrame{

   // Scene scene = new Scene();

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
        bottomLabel bm = new bottomLabel(scene);
        jm.add(bm.getBot(),BorderLayout.SOUTH);
        jm.add(bm.getTop(),BorderLayout.NORTH);
        jm.add(scene);

        jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jm.setSize(800,600);
        jm.setVisible(true);
        jm.setResizable(true);
        jm.setLocationRelativeTo(null);

    }



}