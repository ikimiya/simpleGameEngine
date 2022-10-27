import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class Snake extends Sprite{

    // speed
    int maxSpeed = 7;

    // rate speed change
    int value = 2;

    // bullet delay
    int delay = 450;
    long currentTime;
    long startShoot;
    long lastShoot;

    public Snake(Scene scene, String imagePath, int width, int height) {
        super(scene,imagePath, width, height);

        this.setLocation(scene.width/2,scene.height/2);
        this.setCenter(this.x,this.y);
        this.dx = 0;
        this.dy = 0;

    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        // java rotate
        AffineTransform test = AffineTransform.getRotateInstance(Math.toRadians(0),this.centerX,this.centerY);

        // simeple shadow
        g2.fillArc(this.x,this.centerY,this.width,this.height/2,0,360);
        g2.setTransform(test);
        g2.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);

    }

    // function to slowly reduce speed
    public void velocityDrag(){
        double newSpeed = this.speed;
        newSpeed *= 0.95;
        if(newSpeed < .25 && newSpeed >= 0){
            newSpeed = 0;
        }
        this.setSpeed(newSpeed);
    }

    @Override
    public void update(){
        super.update();
        if(warped){
            scene.woosh.playSound();
        }
    }

    // checks if the keys are down
    public void checkKeys(){

        // WASD movements angle preset to move in direction
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

        // Diagonal movements
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

        // Spacebar is shoot
        if(scene.keys.keyDown[KeyEvent.VK_SPACE]){

                // java system time
                currentTime = System.currentTimeMillis();

                // time where first start shooting
                startShoot = currentTime - lastShoot;

                // only can shoot if greater than delay
                if (startShoot > delay) {

                    // set last shoot values
                    lastShoot = currentTime;

                    // play shoot sound
                    scene.hit.playSound();

                    // create bullets and set angle of shoot
                    scene.tempAmmo = new Ammo(scene, 0,0);
                    scene.tempAmmo.weaponAttack(this.imageDegree,this.centerX, this.centerY);

                    // add into linklist of bullets
                    scene.ammo.addBullet(scene.tempAmmo);
                }
        }

    }

}
