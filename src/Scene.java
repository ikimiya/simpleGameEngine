import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Scene extends JPanel implements ActionListener, KeyListener {

    int size;

    int width = 800;
    int height = 600;

    Timer t = new Timer(30,this);

    int x = 0;
    int y = 0;


    Keyboard keys = new Keyboard();
    int slimeNum = 3;

    LinkedList<Sprite> slimeList = new LinkedList<Sprite>();


    //Ammo bullet = new Ammo(this,"src/images/bullet.png",20,20);
    Snake snake = new Snake(this,"src/images/snake.png",65,65);
    Slime slime = new Slime(this,"src/images/slime.png",80,80);

    SlimeMob m = new SlimeMob(this);
    MassAmmo ammo;

    Ammo tempAmmo;


    // set keyboard keys
    public Scene(){

        keys.createKeys();
        ammo = new MassAmmo(this);
        //ammo.createBullets();
        m.createMob();
        this.setFocusable(true);
        t.start();
        addKeyListener(this);
        this.setDoubleBuffered(true);
    }

    public void paintComponent (Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(x,y,this.width,this.height);
        snake.draw(g);
        //m.draw(g);

        ammo.draw(g);

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

    @Override
    public void actionPerformed(ActionEvent e) {

        snake.velocityDrag();

        //m.slimeMove(snake);
        //m.checkSlimeCollide(snake);
        snake.checkKeys();
        snake.update();
        //bullet.update();
        ammo.update();
        //m.update();

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.checkKeys(e);
        //int key = KeyEvent.VK_A;
/*
        if(keys.keyDown[KeyEvent.VK_W]){
            snake.setAngle(270);
            snake.changeSpeedBy(snake.value);
            if (snake.speed > snake.maxSpeed) {
                snake.setSpeed(snake.maxSpeed);
            }
            //snake.wPressed = true;
            //snake.move();
        }
        if(keys.keyDown[KeyEvent.VK_D]){
            snake.imageDegree += 5;

            if(snake.imageDegree > 360){
                snake.setAngle(360);
            }else{
                snake.setAngle((snake.imageDegree));
            }

            snake.changeSpeedBy(snake.value);
            if (snake.speed > snake.maxSpeed) {
                snake.setSpeed(snake.maxSpeed);
            }
            //snake.wPressed = true;
            //snake.move();
        }

        if(keys.keyDown[KeyEvent.VK_A]){
            snake.setAngle(180);
            snake.changeSpeedBy(snake.value);
            if (snake.speed > snake.maxSpeed) {
                snake.setSpeed(snake.maxSpeed);
            }
            //snake.wPressed = true;
            //snake.move();
        }
        if(keys.keyDown[KeyEvent.VK_S]){
            snake.setAngle(90);
            snake.changeSpeedBy(snake.value);
            if (snake.speed > snake.maxSpeed) {
                snake.setSpeed(snake.maxSpeed);
            }
            //snake.wPressed = true;
            //snake.move();
        }


        if(keys.keyDown[KeyEvent.VK_SPACE]){
            tempAmmo = new Ammo(this,snake.centerX,snake.centerY);
            tempAmmo.weaponAttack(snake.imageDegree);
            //tempAmmo.weaponAttack((int) Math.toRadians(snake.imgAngle));
            tempAmmo.print();
            ammo.addBullet(tempAmmo);
        }

        /*
        if(e.getKeyCode() == KeyEvent.VK_W){
            snake.setAngle(270);
            snake.wPressed = true;
            snake.move();
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            snake.setAngle(180);
            snake.aPressed = true;
            snake.move();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            snake.setAngle(90);
            snake.sPressed = true;
            snake.move();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            snake.setAngle(0);
            snake.dPressed = true;
            snake.move();
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE){

            tempAmmo = new Ammo(this,snake.centerX,snake.centerY);
            tempAmmo.weaponAttack(snake.imageDegree);
            //tempAmmo.weaponAttack((int) Math.toRadians(snake.imgAngle));
            tempAmmo.print();
            ammo.addBullet(tempAmmo);
        }

         */

    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.clearKeys(e);

        //snake.aPressed = false;
        //snake.wPressed = false;
        //snake.sPressed = false;
        //snake.dPressed = false;
    }
}
