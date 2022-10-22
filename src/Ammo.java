import java.awt.*;

public class Ammo extends Sprite{

    String imagePath = "src/images/bullet.png";

    int maxSpeed = 5;

    public Ammo(Scene scene, int x, int y) {
        super(scene,x,y);
        this.setImage(imagePath);
        this.width = 20;
        this.height = 20;

    }

    public void weaponAttack (int playerAngle){

        this.setAngle(playerAngle);
        this.setSpeed(maxSpeed);
        this.changeSpeedBy(maxSpeed);


    }





    @Override
    public void draw(Graphics g) {
        g.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);

    }
}
