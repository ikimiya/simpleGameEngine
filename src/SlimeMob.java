import java.awt.*;
import java.util.LinkedList;

public class SlimeMob{


    LinkedList<Slime> slimeList = new LinkedList<Slime>();
    Sound hurt = new Sound("src/audio/hitHurt.wav");

    int mobSize = 3;

    Slime tempSlime;
    Scene scene;

    public SlimeMob(Scene scene) {
        this.scene = scene;

    }

    public void update(){
        for(int i = 0; i < mobSize; i++){
            slimeList.get(i).update();
        }
    }

    public void createMob(){
        for(int i = 0; i < mobSize;i++){
            slimeList.add(i,getNewSlime());
        }
    }
    public void slimeMove(Sprite s){
        for(int i = 0; i < mobSize; i++){
            slimeList.get(i).move(s);
        }
    }

    public void draw(Graphics g){
        for(int i = 0; i < mobSize; i++){
            tempSlime = slimeList.get(i);
            tempSlime.draw(g);

        }
    }

    public void increaseLimit(int inc){
        mobSize += inc;
        for(int i = mobSize - inc; i < mobSize;i++){
            slimeList.add(i,getNewSlime());
        }
    }

    public Slime getNewSlime(){
        return (new Slime(scene,"src/images/slime.png",80,80));
    }


    public boolean checkSlimeCollide(Sprite s){
        for(int i = 0; i < mobSize && i < slimeList.size(); i++){
            if(s.spriteCollide(slimeList.get(i))){
                slimeList.get(i).reset();
                hurt.playSound();
                return true;
                //this.increaseLimit(1);
            }
        }
        return false;
    }




}
