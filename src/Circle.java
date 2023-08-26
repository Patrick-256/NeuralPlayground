import java.awt.*;

public class Circle extends Shape {

    public Circle(int xPos, int yPos, int width, int height, Color color) {
        super(xPos, yPos, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawOval(this.getxPos(),this.getyPos(),this.getWidth(),this.getHeight());
    }
}
