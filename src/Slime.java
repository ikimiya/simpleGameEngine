import java.awt.*;
import java.awt.geom.AffineTransform;

public class Slime extends Sprite{

    // max speed of slime
    int maxSpeed = 3;

    public Slime(Scene scene, String imagePath, int width, int height) {
        super(scene,imagePath, width, height);

        // random x and y starting points
        // copy reset to avoid sometimes same as player
        int number = (int) (Math.random() * 4 - 0);
        int xNum = (int) (Math.random() * (this.sceneWidth) + 0);
        int yNum = (int) (Math.random() * (this.sceneHeight) + 0);

        if(number == 0){
            this.x = -40;
            this.y = yNum;
        }else if (number == 1){
            this.x = this.sceneWidth + 40;
            this.y = yNum;
        }else if (number == 2){
            this.y = -40;
            this.x = xNum;
        }else if (number == 3){
            this.y = sceneHeight + 40;
            this.x = xNum;
        }
        //disable warp
        boundWarp = false;

    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        // flip angle to face toward player
        AffineTransform test = AffineTransform.getRotateInstance(3.14 + this.moveAngle,this.centerX,this.centerY);
        g2.setTransform(test);
        g2.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);

    }

    // ai to move to player
    public void move(Sprite sprite){

        // find angle to player
        double playerAt = this.findAngleTo(sprite);

        // set angle
        this.setAngle(playerAt);

        // increase speed
        speed = speed + 0.05;
        if(this.speed > this.maxSpeed){
            this.setSpeed(maxSpeed);
        }else{
            this.setSpeed(speed);
        }
    }

    // error checker
    public void print(){
        System.out.println("CHeck scene : " + this.x + " " + this.y);
    }

    // mob reset function
    public void reset(){
        // left,right,top, bottom
        // 0,1,2,3
        int number = (int) (Math.random() * 4 - 0);
        int xNum = (int) (Math.random() * (this.sceneWidth) + 0);
        int yNum = (int) (Math.random() * (this.sceneHeight) + 0);
        //System.out.println("CHeck scene : " + xNum + " " + yNum);
        if(number == 0){
            this.x = -40;
            this.y = yNum;
            //this.setSpeed(0);
        }else if (number == 1){
            this.x = this.sceneWidth + 40;
            this.y = yNum;
            //this.setSpeed(0);
        }else if (number == 2){
            this.y = -40;
            this.x = xNum;
            //this.setSpeed(0);
        }else if (number == 3){
            this.y = sceneHeight + 40;
            this.x = xNum;
            //this.setSpeed(0);
        }

        // reset speed back to zero
        this.setSpeed(0);
    }
}
