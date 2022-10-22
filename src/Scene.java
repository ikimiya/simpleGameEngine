public class Scene {

    int size;

    int width = 400;
    int height = 400;

    int xPos = 0;
    int yPos = 0;



    // set keyboard keys
    public Scene(){

    }


    // set the size
    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    // set the point location
    public void setPosition(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }





}
