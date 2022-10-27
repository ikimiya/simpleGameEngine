import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Scene extends JPanel implements ActionListener, KeyListener {

    // check if imageset else draw rectangle
    boolean imageSet = false;
    Image image;

    int width;
    int height;
    int x;
    int y;

    // timer values
    Timer t = new Timer(30,this);
    String timeLabel;
    int elapsedTime = 0;
    int second = 0;
    int minute = 0;
    int hour = 0;

    // game variables
    int count = 0;
    String score;

    int life = 3;
    String lifeBoard = "Life: " + life;
    boolean notGameOver = true;

    // keyboard
    Keyboard keys = new Keyboard();

    // player and entitys
    Snake snake;
    SlimeMob slimeMass;
    MassAmmo ammo;

    // temperary player and entities
    Ammo tempAmmo;
    Slime tempSlime;

    // effects
    Sound explode = new Sound("src/audio/explosion.wav");
    Sound hit = new Sound ("src/audio/laserShoot.wav");
    Sound hurt = new Sound("src/audio/hitHurt.wav");
    Sound woosh = new Sound("src/audio/jump.wav");

    // constructor
    public Scene(){
        // jpanel
        this.setFocusable(true);
        addKeyListener(this);
        this.setDoubleBuffered(true);
    }

    // initalize scene values
    public void init(){
        snake = new Snake(this,"src/images/snake.png",65,65);
        ammo = new MassAmmo(this);
        slimeMass = new SlimeMob(this);
        ammo.createBullets();
        slimeMass.createMob();
        keys.createKeys();
    }

    // draw
    public void paintComponent (Graphics g) {

        // check if image set else draw background with color
        if(imageSet){
            g.drawImage(image,this.x,this.y,this.width,this.height,null);
        }else{
            g.setColor(Color.GRAY);
            g.fillRect(x,y,this.width,this.height);
        }

        // draw entiteis
        snake.draw(g);
        ammo.draw(g);
        slimeMass.draw(g);

        this.repaint();
    }

    // set the size of image/background size
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    // set the point location
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    // set background
    public void setBackground(String path){
        imageSet = true;
        this.image = new ImageIcon(path).getImage();
    }

    // start timer
    public void startTimer(){
        if(notGameOver) {
            t.start();
        }
    }

    // stop timer
    public void stopTimer(){
        if(notGameOver){
            t.stop();
        }
    }

    // print time
    public String timeElapsed(){
        elapsedTime += 30;
        hour = (elapsedTime/3600000) % 60;
        minute = (elapsedTime/60000) % 60;
        second = (elapsedTime/1000) % 60;
        return timeLabel = ("Hours:" + hour +" Minutes:" + minute + " Seconds:" + second);
    }

    // update call by tiemr
    @Override
    public void actionPerformed(ActionEvent e) {

        // snake slowly slow down
        snake.velocityDrag();

        // CheckScoreBoard
        slimeMass.slimeMove(snake);
        if(slimeMass.checkSlimeCollide(snake)){
            life -= 1;
            if(life <= 0){
                lifeBoard = "Life: " + life;
            }else{
                lifeBoard = "Life: " + life;
            }
        }

        // update functions
        slimeMass.update();
        checkBullet();
        ammo.update();
        snake.update();
        snake.checkKeys();
    }

    // check if bullet hits a slime function
    public void checkBullet(){
        for(int i = 0; i < slimeMass.mobSize && i <slimeMass.slimeList.size(); i++){
            tempSlime = slimeMass.slimeList.get(i);
            if(ammo.checkBulletHit(tempSlime)){
                explode.playSound();
                tempSlime.reset();
                count = count+1;
                score = "Count :" + count;
                if(count % 10 == 0 && count != 0){
                    slimeMass.increaseLimit(1);
                }
            }
        }
    }

    // return timer
    public Timer getTimer(){
        return t;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // set key press to true
        keys.checkKeys(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // set key release to false
        keys.clearKeys(e);
    }
}
