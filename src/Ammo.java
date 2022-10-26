import java.awt.*;
import java.awt.geom.AffineTransform;

public class Ammo extends Sprite{

    String imagePath = "src/images/bullet.png";

    int maxSpeed = 5;


    public Ammo(Scene scene, int x, int y) {
        super(scene,x,y);
        this.setImage(imagePath);
        this.width = 20;
        this.height = 20;

        this.setSpeed(0);
        //this.hide();
    }

    public void weaponAttack (int playerAngle, int x, int y){
        this.x = x;
        this.y = y;
        this.setAngle(playerAngle);
        this.setSpeed(maxSpeed);
        this.changeSpeedBy(maxSpeed);
    }



    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform original = g2.getTransform();
        AffineTransform test = AffineTransform.getRotateInstance(this.moveAngle,this.centerX,this.centerY);
        g2.setTransform(test);
        g2.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);
    }



}
