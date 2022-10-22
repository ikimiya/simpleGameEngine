import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;


public class Snake extends Sprite{

    // set height


    boolean wPressed, aPressed, sPressed, dPressed;
    int maxSpeed = 10;
    int minSpeed = -10;

    int angular = 0;

    int value = 3;

    public Snake(Scene scene, String imagePath, int width, int height) {
        super(scene,imagePath, width, height);

        this.setLocation(200,200);


        this.dx = 0;
        this.dy = 0;

    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;

        AffineTransform original = g2.getTransform();
        AffineTransform test = AffineTransform.getRotateInstance(Math.toRadians(0),this.centerX,this.centerY);

        g2.setTransform(test);
        g2.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);



    }

    public void velocityDrag(){
        double newSpeed = this.speed;
        newSpeed *= 0.95;
        if(newSpeed < .25 && newSpeed >= 0){
            newSpeed = 0;
        }
        this.setSpeed(newSpeed);
    }

    public void touchEnemy(Sprite s){

        if(spriteCollide(s)){

        }


    }



    public void move(){
        // angle change for diagonal movement
        if(wPressed && dPressed){
            this.setAngle(-45);
            changeSpeedBy(value);
            if(this.speed > this.maxSpeed){
                this.setSpeed(maxSpeed);
            }
        }
        if(wPressed && aPressed){
            this.setAngle(-125);
            changeSpeedBy(value);
            if(this.speed > this.maxSpeed){
                this.setSpeed(maxSpeed);
            }
        }
        if(sPressed && dPressed){
            this.setAngle(45);
            changeSpeedBy(value);
            if(this.speed > this.maxSpeed){
                this.setSpeed(maxSpeed);
            }
        }
        if(sPressed && aPressed){
            this.setAngle(125);
            changeSpeedBy(value);
            if(this.speed > this.maxSpeed){
                this.setSpeed(maxSpeed);
            }
        }

        // WASD movement
        if (wPressed) {
            changeSpeedBy(value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(maxSpeed);
            }
        }else if (aPressed) {
            changeSpeedBy(value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(maxSpeed);
            }
        }else if (sPressed) {
            changeSpeedBy(value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(maxSpeed);
            }
        }else if (dPressed) {
             changeSpeedBy(value);
             if (this.speed > this.maxSpeed) {
                 this.setSpeed(maxSpeed);
             }
         }

    }
}
