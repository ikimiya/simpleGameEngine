import java.awt.*;
import java.util.LinkedList;

public class MassAmmo {


    LinkedList<Ammo> bullet = new LinkedList<Ammo>();
    int maximumAmount = 50;

    Ammo tempBullet;
    Scene scene;

    public MassAmmo(Scene scene){
        this.scene = scene;

    }

    public void createBullets(){
        for(int i = 0; i < bullet.size() && i < maximumAmount;i++){
            bullet.add(i,getNewAmmo());
        }
    }

    public void update(){
        for(int i = 0; i < bullet.size() && i < maximumAmount ;i++){
            tempBullet = bullet.get(i);


            if(tempBullet.x > scene.width){
                destory(tempBullet);
            }


            tempBullet.update();


        }
    }


    public void draw(Graphics g){

        for(int i = 0; i < bullet.size() && i < maximumAmount ;i++){
            tempBullet = bullet.get(i);

            tempBullet.draw(g);

        }
    }

    public void addBullet(Ammo a){
        bullet.add(a);

    }

    public Ammo getNewAmmo(){
        return new Ammo(scene,20,20);
    }

    public void destory(Ammo a){
        bullet.remove(a);
    }

}
