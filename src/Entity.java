import java.awt.*;

public abstract class Entity implements Drawable {
    private Shape shape;
    private String text;

    public Entity(Shape shape, String text) {
        this.shape = shape;
        this.text = text;
    }

    public Shape getShape() {
        return shape;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void draw(Graphics g) {
        this.shape.draw(g);
        g.drawString(this.text,this.shape.getxPos(),this.shape.getyPos());
    }
}
