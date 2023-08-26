import java.awt.*;

public class EntityFactory {
    public Entity makeEntity(String type, int xCenter,int yCenter) {
        Shape shape;
        switch(type) {
            case "node":
                shape = new Circle(xCenter-10,yCenter-10,20,20, Color.BLACK);
                return new Entity_Node(shape,"0.25");
            case "input":
                shape = new Circle(xCenter-10,yCenter-10,20,20, Color.GREEN);
                return new Entity_Node(shape,"0.00");
            case "output":
                shape = new Circle(xCenter-10,yCenter-10,20,20, Color.BLUE);
                return new Entity_Node(shape,"0.00");
            case "label":
                shape = new Rectangle(xCenter-25,yCenter-10,50,20, Color.WHITE);
                return new Entity_Label(shape,"Label");
            default:
                System.out.println("default on makeEntity switch");
        }
        return null;
    }
}
