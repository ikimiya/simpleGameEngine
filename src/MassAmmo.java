import java.awt.*;
import java.util.LinkedList;

public class MassAmmo {

    LinkedList<Ammo> bullet = new LinkedList<Ammo>();
    int maximumAmount = 5;
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

            if(tempBullet.checkBoundRemove()){
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
        return new Ammo(scene,500,500);
    }

    public void destory(Ammo a){
        bullet.remove(a);
    }


    public boolean checkBulletHit(Sprite s){
        for(int i = 0; i < bullet.size() && i < maximumAmount; i++){

            if(bullet.get(i).spriteCollide(s)){
                destory(tempBullet);
                return true;

                //hurt.playSound();
                //this.increaseLimit(1);
            }
        }
        return false;
    }
}
