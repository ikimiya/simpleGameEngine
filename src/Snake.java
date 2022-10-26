import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;



public class Snake extends Sprite{

    // set height

    int maxSpeed = 5;
    int value = 3;

    int delay = 500;
    long currentTime;
    long startShoot;
    long lastShoot;

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

    public void checkKeys(){

        if(scene.keys.keyDown[KeyEvent.VK_W]){
            this.imageDegree = 270;
            this.setAngle(imageDegree);
            this.changeSpeedBy(this.value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(this.maxSpeed);
            }
        }
        if(scene.keys.keyDown[KeyEvent.VK_D]){
            this.imageDegree = 360;
            this.setAngle(imageDegree);
            this.changeSpeedBy(this.value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(this.maxSpeed);
            }
        }
        if(scene.keys.keyDown[KeyEvent.VK_A]){
            this.imageDegree = 180;
            this.setAngle(imageDegree);
            this.changeSpeedBy(this.value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(this.maxSpeed);
            }
        }
        if(scene.keys.keyDown[KeyEvent.VK_S]){
            this.imageDegree = 90;
            this.setAngle(imageDegree);
            this.changeSpeedBy(this.value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(this.maxSpeed);
            }
        }
        if(scene.keys.keyDown[KeyEvent.VK_W] && scene.keys.keyDown[KeyEvent.VK_D]){
            this.imageDegree = 315;
            this.setAngle(imageDegree);
            this.changeSpeedBy(this.value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(this.maxSpeed);
            }
        }
        if(scene.keys.keyDown[KeyEvent.VK_W] && scene.keys.keyDown[KeyEvent.VK_A]){
            this.imageDegree = 225;
            this.setAngle(imageDegree);
            this.changeSpeedBy(this.value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(this.maxSpeed);
            }
        }
        if(scene.keys.keyDown[KeyEvent.VK_S] && scene.keys.keyDown[KeyEvent.VK_D]){
            this.imageDegree = 45;
            this.setAngle(imageDegree);
            this.changeSpeedBy(this.value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(this.maxSpeed);
            }
        }
        if(scene.keys.keyDown[KeyEvent.VK_S] && scene.keys.keyDown[KeyEvent.VK_A]){
            this.imageDegree = 135;
            this.setAngle(imageDegree);
            this.changeSpeedBy(this.value);
            if (this.speed > this.maxSpeed) {
                this.setSpeed(this.maxSpeed);
            }
        }
        if(scene.keys.keyDown[KeyEvent.VK_SPACE]){

                currentTime = System.currentTimeMillis();

                startShoot = currentTime - lastShoot;
                if (startShoot > delay) {
                    lastShoot = currentTime;
                    scene.hit.playSound();
                    scene.tempAmmo = new Ammo(scene, 0,0);
                    scene.tempAmmo.weaponAttack(this.imageDegree,this.centerX, this.centerY);
                    scene.ammo.addBullet(scene.tempAmmo);
                }
        }

    }

}
