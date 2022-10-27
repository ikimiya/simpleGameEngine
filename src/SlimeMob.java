import java.awt.*;
import java.util.LinkedList;

public class SlimeMob{

    // list of slime mobs
    LinkedList<Slime> slimeList = new LinkedList<>();

    // starting size of mobs
    int mobSize = 3;

    Slime tempSlime;
    Scene scene;

    public SlimeMob(Scene scene) {
        this.scene = scene;
    }

    // update all mobs
    public void update(){
        for(int i = 0; i < mobSize; i++){
            slimeList.get(i).update();
        }
    }

    // create mobs
    public void createMob(){
        for(int i = 0; i < mobSize;i++){
            slimeList.add(i,getNewSlime());
        }
    }
    // move mobs to sprite
    public void slimeMove(Sprite s){
        for(int i = 0; i < mobSize; i++){
            slimeList.get(i).move(s);
        }
    }

    // draw sprite
    public void draw(Graphics g){
        for(int i = 0; i < mobSize; i++){
            tempSlime = slimeList.get(i);
            tempSlime.draw(g);

        }
    }

    // difficult increase
    public void increaseLimit(int inc){
        mobSize += inc;
        for(int i = mobSize - inc; i < mobSize;i++){
            slimeList.add(i,getNewSlime());
        }
    }

    // return new slime
    public Slime getNewSlime(){
        return (new Slime(scene,"src/images/slime.png",80,80));
    }

    // check if slime collided, use for player hurted
    public boolean checkSlimeCollide(Sprite s){
        for(int i = 0; i < mobSize && i < slimeList.size(); i++){
            if(s.spriteCollide(slimeList.get(i))){
                slimeList.get(i).reset();
                scene.hurt.playSound();
                return true;
                //this.increaseLimit(1);
            }
        }
        return false;
    }




}
