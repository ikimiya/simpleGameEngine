import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class Slime extends Sprite{

    long seed;
    boolean boundary = false;
    int maxSpeed = 3;

    public Slime(Scene scene, String imagePath, int width, int height) {
        super(scene,imagePath, width, height);

        int xNum = (int) (Math.random() * (this.sceneWidth) + 20);
        int yNum = (int) (Math.random() * (this.sceneHeight) + 20);

        this.x = xNum;
        this.y = yNum;

    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;


        AffineTransform original = g2.getTransform();
        // since was facing backwards add pi
        AffineTransform test = AffineTransform.getRotateInstance(3.14 + this.moveAngle,this.centerX,this.centerY);

        g2.setTransform(test);
        g2.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);



    }

    // ai to move to player
    public void move(Sprite sprite){

        //System.out.println(distance(sprite));
        //System.out.println(findAngleTo(sprite));
        double playerAt = this.findAngleTo(sprite);

        this.setAngle(playerAt);


        speed = speed + 0.05;
        if(this.speed > this.maxSpeed){
            this.setSpeed(maxSpeed);
        }else{
            this.setSpeed(speed);
        }


    }

    public void collideWith(Sprite sprite){
        if( super.spriteCollide(sprite)){
            System.out.println("colided");
        }else{
        }
    }


    public void print(){
        System.out.println("CHeck scene : " + this.sceneHeight + " " + this.sceneWidth);
    }



    public void reset(){
        // left,right,top, bottom
        // 0,1,2,3
        int number = (int) (Math.random() * 4 - 0);
        int xNum = (int) (Math.random() * (this.sceneWidth - 20 - 20) + 20);
        int yNum = (int) (Math.random() * (this.sceneHeight - 20 - 20) + 20);
        //System.out.println("CHeck scene : " + xNum + " " + yNum);
        if(number == 0){
            this.x = 10;
            this.y = yNum;

        }else if (number == 1){
            this.x = this.sceneWidth - 5;
            this.y = yNum;
        }else if (number == 10){
            this.y = 50;
            this.x = xNum;

        }else if (number == 3){
            this.y = sceneHeight - 5;
            this.x = xNum;
        }

        // reset speed so it dont get stuck
        this.setSpeed(0);

    }


}
