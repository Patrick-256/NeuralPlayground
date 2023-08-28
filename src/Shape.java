import java.awt.*;
/**
 * Parent class for anything that can be drawn on the screen
 */
public abstract class Shape implements Drawable {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;

    public Shape(int xPos, int yPos, int width, int height, Color color) {
        if(color == null){
            throw new NullPointerException();
        }
        if(width < 0){
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        if(height < 0){
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int x) {
        this.xPos = x;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int y) {
        this.yPos = y;
    }

    public void setCenterPoint(int x, int y) {
        this.xPos = x - this.width/2;
        this.yPos = y - this.height/2;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
}
