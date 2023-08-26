import java.awt.*;

public class Rectangle extends Shape {
    public Rectangle(int xPos, int yPos, int width, int height, Color color) {
        super(xPos, yPos, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawRect(this.getxPos(),this.getyPos(),this.getWidth(),this.getHeight());
    }
}
