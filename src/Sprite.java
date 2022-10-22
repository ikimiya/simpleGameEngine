import javax.swing.*;
import java.awt.*;

public class Sprite {

    Image image;

    int width;
    int height;

    int xPosition;
    int yPosition;

    int dx;
    int dy;

    int ddx;
    int ddy;

    int imgAngle = 0;
    int moveAngle = 0;

    int speed;

    public Sprite(String imagePath, int width, int height){
        this.image = new ImageIcon(imagePath).getImage();
        this.width = width;
        this.height = height;
    }

    public void setImage(String imagePath){
        this.image = new ImageIcon(imagePath).getImage();

    }

    // public void draw

    public void update(){
        this.xPosition += this.dx;
        this.yPosition += this.dy;
    }

    public void show(){

    }

    public void hide(){

    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void setImageAngle(int degree){

    }

    public void changeImageAngleBy(int degree){

    }

    public void setMoveAngle(int degree){

    }

    public void setMoveAngleBy(int degree){

    }

    public void setAngle(int degree){

    }

    public void changeAngleBy(int degree){

    }






}
