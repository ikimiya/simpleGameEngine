import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Scene extends JPanel implements ActionListener, KeyListener {

    int width = 800;
    int height = 600;

    Timer t = new Timer(30,this);

    String timeLabel;
    int elapsedTime = 0;
    int second = 0;
    int minute = 0;
    int hour = 0;

    int x = 0;
    int y = 0;


    int count = 0;
    String score;

    int life = 3;
    String lifeBoard = "Life: " + life;
    boolean notGameOver = true;

    Keyboard keys = new Keyboard();

    Snake snake = new Snake(this,"src/images/snake.png",65,65);

    Sound explode = new Sound("src/audio/explosion.wav");
    Sound hit = new Sound ("src/audio/laserShoot.wav");

    SlimeMob m;
    MassAmmo ammo;

    Ammo tempAmmo;
    Slime tempSlime;

    // set keyboard keys
    public Scene(){

        ammo = new MassAmmo(this);
        m = new SlimeMob(this);
        ammo.createBullets();
        m.createMob();
        keys.createKeys();

        this.setFocusable(true);
        addKeyListener(this);
        this.setDoubleBuffered(true);
    }

    public void paintComponent (Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(x,y,this.width,this.height);

        snake.draw(g);
        ammo.draw(g);
        m.draw(g);

        this.repaint();
    }

    // set the size
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    // set the point location
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void startTimer(){
        if(notGameOver) {
            t.start();
        }
    }

    public void stopTimer(){
        if(notGameOver){
            t.stop();
        }
    }

    public void restart(){

    }

    public String timeElapsed(){

        elapsedTime += 30;
        hour = (elapsedTime/3600000) % 60;
        minute = (elapsedTime/60000) % 60;
        second = (elapsedTime/1000) % 60;
        return timeLabel = ("Hours:" + hour +" Minutes:" + minute + " Seconds:" + second);
    }

    public void init(){
        keys.createKeys();
        ammo = new MassAmmo(this);
        ammo.createBullets();
        m.createMob();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        snake.velocityDrag();
        System.out.println(timeElapsed());

        m.slimeMove(snake);
        if(m.checkSlimeCollide(snake)){
            life -= 1;
            if(life <= 0){
                lifeBoard = "Life: " + life;

            }else{
                lifeBoard = "Life: " + life;
            }


        }

        // ammo.checkBulletHit(slime);
        m.update();
        checkBullet();
        ammo.update();
        snake.update();
        snake.checkKeys();
    }

    public void checkBullet(){
        for(int i = 0; i < m.mobSize && i <m.slimeList.size(); i++){
            tempSlime = m.slimeList.get(i);
            if(ammo.checkBulletHit(tempSlime)){
                explode.playSound();
                tempSlime.reset();
                count = count+1;
                score = "Count :" + count;
                System.out.println(score);
            }
        }
    }

    public Timer getTimer(){
        return t;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.checkKeys(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.clearKeys(e);

    }
}
