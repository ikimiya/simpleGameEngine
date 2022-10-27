import java.awt.*;
import java.util.LinkedList;

public class MassAmmo {

    // linklist of bullets
    LinkedList<Ammo> bullet = new LinkedList<>();

    int maximumAmount = 100;
    Ammo tempBullet;
    Scene scene;

    public MassAmmo(Scene scene){
        this.scene = scene;
    }

    // create Bullets
    public void createBullets(){
        for(int i = 0; i < bullet.size() && i < maximumAmount;i++){
            bullet.add(i,getNewAmmo());
        }
    }

    // update bullets
    public void update(){
        for(int i = 0; i < bullet.size() && i < maximumAmount ;i++){
            tempBullet = bullet.get(i);

            if(tempBullet.checkBoundRemove()){
                destory(tempBullet);
            }
            tempBullet.update();
        }
    }

    // draw bullets
    public void draw(Graphics g){
        for(int i = 0; i < bullet.size() && i < maximumAmount ;i++){
            tempBullet = bullet.get(i);
            tempBullet.draw(g);
        }
    }

    // add bullets to list
    public void addBullet(Ammo a){
        bullet.add(a);
    }

    // get ammo
    public Ammo getNewAmmo(){
        return new Ammo(scene,500,500);
    }

    // remove ammo from list
    public void destory(Ammo a){
        bullet.remove(a);
    }

    // chck if collibed with sprite
    public boolean checkBulletHit(Sprite s){
        for(int i = 0; i < bullet.size() && i < maximumAmount; i++){
            if(bullet.get(i).spriteCollide(s)){
                destory(tempBullet);
                return true;
            }
        }
        return false;
    }
}
