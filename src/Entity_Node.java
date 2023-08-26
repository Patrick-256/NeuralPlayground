import java.awt.*;

public class Entity_Node extends Entity {
    public Entity_Node(Shape shape, String label) {
        super(shape,label);
    }

    @Override
    public void draw(Graphics g) {
        this.getShape().draw(g);
        g.drawString(this.getText(),this.getShape().getxPos(),this.getShape().getyPos()-5);
    }
}
