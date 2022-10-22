import javax.swing.*;
import java.awt.event.*;
import java.beans.JavaBean;

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






        jm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jm.setSize(800,600);
        jm.setResizable(false);
        jm.setLocationRelativeTo(null);

    }


}