import java.awt.*;
import java.awt.event.*;

public class NetworkPanelControlHandler implements MouseListener, MouseMotionListener {
    private int lineStartX = -1;
    private int lineStartY = -1;
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Repository repo = Repository.getInstance();
        if(repo.getCurrentMode().equals("connection")) {
            if(lineStartX < 0 && lineStartY < 0) {
                lineStartX = e.getX();
                lineStartY = e.getY();

                //check if the line's starting coordinates reside inside a node
                int[] snapTo = repo.snapCordinates(lineStartX,lineStartY);
                System.out.println("snapping... pressed");

                if(snapTo[0] > 0 && snapTo[1] > 0) {
                    lineStartX = snapTo[0];
                    lineStartY = snapTo[1];
                    System.out.println("snapped! pressed");
                }
            }
        }
    }

    public Entity makeEntity(int x,int y) {
        Repository repo = Repository.getInstance();
        EntityFactory factory = new EntityFactory();
        return factory.makeEntity(repo.getCurrentMode(),x,y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Repository repo = Repository.getInstance();

        switch(repo.getCurrentMode()) {
            case "connection":
                int[] snapTo = repo.snapCordinates(e.getX(),e.getY());
                if(snapTo[0] > 0 && snapTo[1] > 0) {
                    repo.addDrawable(new Line(lineStartX,lineStartY,snapTo[0],snapTo[1],2,Color.BLACK));
                    System.out.println("snapping released");
                } else {
                    repo.addDrawable(new Line(lineStartX,lineStartY,e.getX(),e.getY(),2,Color.BLACK));
                }
                repo.clearPreviewDrawable();
                lineStartX = -1;
                lineStartY = -1;
                break;
            case "move":
                break;
            default:
                // input, node, output, label
                repo.addDrawable(this.makeEntity(e.getX(),e.getY()));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        Repository repo = Repository.getInstance();

        if(repo.getCurrentMode().equals("connection")) {
            repo.setPreviewDrawable(new Line(lineStartX,lineStartY,e.getX(),e.getY(),2,Color.BLACK));
        }

        if(repo.getCurrentMode().equals("move")) {
            //check if the cursor in inside a node
            int[] snapTo = repo.snapCordinates(e.getX(),e.getY());
            if(snapTo[0] > 0 && snapTo[1] > 0) {
                //set the center point of this entity to the current mouse position as well as any lines connected to it
                boolean moved = repo.setCenterLocationOfEntity(e.getX(),e.getY());
                System.out.println("shape moved successful: "+moved);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
