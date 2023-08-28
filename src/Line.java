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

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public void setDestinationY(int destinationY) {
        this.destinationY = destinationY;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);
        ((Graphics2D) g).setStroke(new BasicStroke(this.thickness));
        g2.drawLine(this.startX,this.startY,this.destinationX,this.destinationY);
        ((Graphics2D) g).setStroke(new BasicStroke(1));
    }
}
