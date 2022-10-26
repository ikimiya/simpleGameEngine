import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Sprite {

    Image image;

    int width;
    int height;

    int x;
    int y;

    int centerX;
    int centerY;

    int dx;
    int dy;

    int ddx;
    int ddy;

    int sceneHeight;
    int sceneWidth;

    double imgAngle;
    double moveAngle;
    int imageDegree;

    double speed = 0;

    Scene scene;

    boolean visible = true;
    boolean boundWarp = true;

    public Sprite(Scene scene, String imagePath, int width, int height){
        this.scene = scene;
        this.sceneWidth = scene.width;
        this.sceneHeight = scene.height;
        this.image = new ImageIcon(imagePath).getImage();
        this.width = width;
        this.height = height;
    }


    public Sprite(Scene scene, int x, int y){
        this.scene = scene;
        this.sceneWidth = scene.width;
        this.sceneHeight = scene.height;
        this.x = x;
        this.y = y;
    }




    public void setScene(int width, int height){
        this.sceneHeight = height;
        this.sceneWidth = width;
    }

    public void setImage(String imagePath){
        this.image = new ImageIcon(imagePath).getImage();

    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;

    }

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

            AffineTransform original = g2.getTransform();
            AffineTransform test = AffineTransform.getRotateInstance(Math.toRadians(0),this.centerX,this.centerY);

            g2.setTransform(test);
            g2.drawImage(this.getImage(),this.x,this.y,this.width,this.height,null);
        }

    }

    public void update(){
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

    public void calculateVector(){
        this.dx = (int) (this.speed * Math.cos((this.moveAngle)));
        this.dy = (int) (this.speed * Math.sin((this.moveAngle)));
    }

    public void setSpeed(double speed){
        this.speed = speed;
        this.calculateVector();
    }



    public void changeSpeedBy(int diff){
        this.speed += diff;
        this.calculateVector();
    }

    public void setImageAngle(int degree){

    }

    public void changeImageAngleBy(int degree){


    }

    public void setMoveAngle(int degree){

    }

    public void setMoveAngleBy(int degree){

    }

    public void setAngle(int degree){
        this.imageDegree = degree;
        this.imgAngle = (double) Math.toRadians(degree);
        this.moveAngle = (double) Math.toRadians(degree);
    }

    public void setAngle(double degree){
        this.imageDegree = (int)degree;
        this.imgAngle = Math.toRadians(degree);
        this.moveAngle =  Math.toRadians(degree);

    }

    public void changeAngleBy(int degree){
        this.imageDegree = (int)degree;
        this.imgAngle = Math.toRadians(degree);
        this.moveAngle =  Math.toRadians(degree);
    }

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

    // CheckBounds wrap mechanci
    public void checkBounds(){
        // test scene boudns
        if(boundWarp){
            int leftBound = 0;
            int rightBound = this.sceneWidth;
            int topBound = 0;
            int botBound = this.sceneHeight;

            if(this.x  > rightBound){
                this.x = leftBound + 1;
            }
            if(this.y > botBound){
                this.y = topBound + 1;
            }

            if(this.x < leftBound){
                this.x = rightBound - 1;
            }

            if(this.y < topBound){
                this.y = botBound -1;
            }
        }

    }

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

    float distanceTo(Sprite s){
        int myX = this.x/2;
        int myY = this.y/2;
        int spriteX = s.x/2;
        int spriteY = s.y/2;

        float diffX = spriteX - myX;
        float diffY = spriteY - myY;

        // distacnce
        return (float) Math.sqrt( (diffX * diffY)  + (diffY * diffY) );
    }

    double distance(Sprite s){
        int myX = this.centerX;
        int myY = this.centerY;

        int otherX = s.centerX;
        int otherY = s.centerY;

        int myDistance = Math.abs(otherX-myX)^2;
        int otherDistance = Math.abs(otherY-myY)^2;

        int xDistance = Math.abs(otherX - myX);
        int yDistance = Math.abs(otherY - myY);

        //System.out.println("mydistance :" + myDistance + " Otherdistance: "+ otherDistance);

        if(Math.abs(myX) == Math.abs(otherX)){
            return(1);
        }else{
            return ((yDistance/xDistance));
        }

        // distance formula

    }

    double findAngleTo(Sprite s){

        double yValue = s.centerY-centerY;
        double xValue = s.centerX-centerX;

        // theta from polar cords
        float angle = (float) Math.toDegrees(Math.atan2(yValue, xValue));

        if(angle < 0){
            angle += 360;
        }

        //this.setMoveAngle((int) angle);

        return angle;

    }

    public void print(){
        System.out.println("X: " + this.x + ",Y: " + this.y + "CenterX: " + this.centerX + "CenterY: " + this.centerY +
                ",dx:" + this.dx + ",dy:" + this.dy + ",ddx:" + this.ddx
                + ",ddy:" + this.ddy + ", Speed:" + this.speed + "mvoeangle: " + this.moveAngle + " Degree: " + this.imageDegree);
    }


}
