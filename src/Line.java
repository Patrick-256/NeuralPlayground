import java.awt.*;

public class Line implements Drawable {
    private int startX;
    private int startY;
    private int destinationX;
    private int destinationY;
    private int thickness;
    private Color color;

    public Line(int startX, int startY, int destinationX, int destinationY, int thickness, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        //thickness not being used yet :/
        g.drawLine(this.startX,this.startY,this.destinationX,this.destinationY);
    }
}
