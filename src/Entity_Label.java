import java.awt.*;

public class Entity_Label extends Entity{
    public Entity_Label(Shape shape, String label) {
        super(shape, label);
    }

    @Override
    public void draw(Graphics g) {
        this.getShape().draw(g);
        g.drawString(this.getText(),this.getShape().getxPos()+5,this.getShape().getyPos()+15);
    }
}
