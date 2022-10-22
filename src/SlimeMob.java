import java.awt.*;
import java.util.LinkedList;

public class SlimeMob{


    LinkedList<Slime> slimeList = new LinkedList<Slime>();
    Sound hurt = new Sound("src/audio/hitHurt.wav");

    int mobSize = 5;

    Slime tempslime;
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
        for(int i = 0; i < mobSize; i++){
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
            slimeList.get(i).draw(g);

        }
    }
    public Slime getNewSlime(){
        return (new Slime(scene,"src/images/slime.png",80,80));
    }
    public void removeBullet(Slime s){
        slimeList.remove(s);
    }

    public void slimeReset(int i){
        slimeList.get(i).reset();
    }

    public void checkSlimeCollide(Sprite s){
        for(int i = 0; i < mobSize; i++){
            if(s.spriteCollide(slimeList.get(i))){
                slimeList.get(i).reset();
                hurt.playSound();

            }
        }
    }




}
