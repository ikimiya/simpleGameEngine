import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Sprite {

    Image image;

    // height and width
    int width;
    int height;

    // x and y position
    int x;
    int y;

    // center of sprite
    int centerX;
    int centerY;

    // velocityt and acceleration
    int dx;
    int dy;
    int ddx;
    int ddy;

    // scnee height and width for boundary
    int sceneHeight;
    int sceneWidth;

    // angle
    double imgAngle;
    double moveAngle;
    int imageDegree;

    double speed = 0;

    Scene scene;

    // state values
    boolean visible = true;
    boolean boundWarp = true;
    boolean warped = false;

    public Sprite(Scene scene, String imagePath, int width, int height){
        this.scene = scene;
        this.sceneWidth = scene.width;
        this.sceneHeight = scene.height;
        this.image = new ImageIcon(imagePath).getImage();
        this.width = width;
        this.height = height;
        this.setCenter(this.x,this.y);

    }


    public Sprite(Scene scene, int x, int y){
        this.scene = scene;
        this.sceneWidth = scene.width;
        this.sceneHeight = scene.height;
        this.x = x;
        this.y = y;
        this.setCenter(this.x,this.y);
    }

    public void setImage(String imagePath){
        this.image = new ImageIcon(imagePath).getImage();

    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    // set the center position of the sprite
    public void setCenter(int x, int y){
        this.centerX = x+(width/2);
        this.centerY = y+(height/2);
    }

    public Image getImage(){
        return this.image;
    }


    // public void draw
    public void draw(Graphics g){
        if(visible){
            Graphics2D g2 = (Graphics2D)g;
            AffineTransform test = AffineTransform.getRotateInstance(Math.toRadians(0),this.centerX,this.centerY);
            g2.setTransform(test);
            g2.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);
        }
    }

    public void update(){
        // update values and checkboudns
        this.checkBounds();
        this.x += this.dx;
        this.y += this.dy;
        this.setCenter(this.x,this.y);
    }

    public void show(){
        this.visible = true;
    }

    public void hide(){
        this.visible = false;
    }

    // calcuate velocity with angle
    public void calculateVector(){
        this.dx = (int) (this.speed * Math.cos((this.moveAngle)));
        this.dy = (int) (this.speed * Math.sin((this.moveAngle)));
    }

    // set speed and calcualte velcoity
    public void setSpeed(double speed){
        this.speed = speed;
        this.calculateVector();
    }

    // set value to change speed by
    public void changeSpeedBy(int diff){
        this.speed += diff;
        this.calculateVector();
    }

    // set angle with int
    public void setAngle(int degree){
        this.imageDegree = degree;
        this.imgAngle = Math.toRadians(degree);
        this.moveAngle = Math.toRadians(degree);
    }

    // set angle with double
    public void setAngle(double degree){
        this.imageDegree = (int)degree;
        this.imgAngle = Math.toRadians(degree);
        this.moveAngle =  Math.toRadians(degree);

    }

    // cjecl sprite collision rectangualr
    public boolean spriteCollide(Sprite s){

        int myLeft = this.x;
        int myRight = this.x + this.width;
        int myTop = this.y;
        int myBottom = this.y + this.height;

        int spriteLeft = s.x;
        int spriteRight = s.x + s.width;
        int spriteTop = s.y;
        int spriteBottom = s.y + s.height;

        if((myTop > spriteBottom) ||
                (myBottom < spriteTop) ||
                (myLeft > spriteRight) ||
                (myRight < spriteLeft))
        {
            return false;
        }
        // assume collision
        return true;
    }

    // CheckBounds wraping
    public void checkBounds(){

        // used to check if sprite pass warp zone
        warped = false;

        // if allow sprite to warp
        if(boundWarp){
            int leftBound = 0;
            int rightBound = this.sceneWidth;
            int topBound = 0;
            int botBound = this.sceneHeight;

            if(this.x  > rightBound){
                this.x = leftBound + 1;
                warped = true;
            }
            if(this.y > botBound){
                this.y = topBound + 1;
                warped = true;
            }

            if(this.x < leftBound){
                this.x = rightBound - 1;
                warped = true;
            }

            if(this.y < topBound){
                this.y = botBound -1;
                warped = true;
            }
        }
    }

    // check whether sprite pass bound use for Ammo class
    public boolean checkBoundRemove(){
        // test scene boudns
        int leftBound = 0;
        int rightBound = this.sceneWidth;
        int topBound = 0;
        int botBound = this.sceneHeight;

        if(this.x  > rightBound){
            return true;
        }
        if(this.y > botBound){
            return true;
        }
        if(this.x < leftBound){
            return true;
        }
        if(this.y < topBound){
            return true;
        }

        return false;
    }

    double distance(Sprite s){
        // distance formula for two points
        int myX = this.centerX;
        int myY = this.centerY;

        int otherX = s.centerX;
        int otherY = s.centerY;

        int myDistance = Math.abs(otherX-myX)^2;
        int otherDistance = Math.abs(otherY-myY)^2;

        return Math.sqrt(myDistance + otherDistance);

    }

    double findAngleTo(Sprite s){

        double yValue = s.centerY-centerY;
        double xValue = s.centerX-centerX;

        // polar coordinate formula to find angle
        float angle = (float) Math.toDegrees(Math.atan2(yValue, xValue));

        if(angle < 0){
            angle += 360;
        }
        return angle;

    }

    // debug mechanic
    public void print(){
        System.out.println("X: " + this.x + ",Y: " + this.y + "CenterX: " + this.centerX + "CenterY: " + this.centerY +
                ",dx:" + this.dx + ",dy:" + this.dy + ",ddx:" + this.ddx
                + ",ddy:" + this.ddy + ", Speed:" + this.speed + "mvoeangle: " + this.moveAngle + " Degree: " + this.imageDegree);
    }


}
