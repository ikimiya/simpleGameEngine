import java.awt.*;
import java.awt.geom.AffineTransform;

public class Ammo extends Sprite{

    // image of bullets
    String imagePath = "src/images/bullet.png";

    // speed of bullets
    int maxSpeed = 7;

    public Ammo(Scene scene, int x, int y) {
        super(scene,x,y);
        this.setImage(imagePath);
        this.width = 25;
        this.height = 5;
    }

    // player calls function with attack to shoot a direction player face
    public void weaponAttack (int playerAngle, int x, int y){
        this.x = x;
        this.y = y;
        this.setAngle(playerAngle);
        this.setSpeed(maxSpeed);
        this.changeSpeedBy(maxSpeed);
    }

    // draw image
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform test = AffineTransform.getRotateInstance(this.moveAngle,this.centerX,this.centerY);
        g2.setTransform(test);
        g2.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);
    }

}
