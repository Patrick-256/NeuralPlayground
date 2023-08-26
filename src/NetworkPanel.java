import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class NetworkPanel extends JPanel implements Observer {

    public NetworkPanel() {}

    /**
     * paints the neurons and their connections
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Repository repo = Repository.getInstance();
        for( Drawable d : repo.getDrawables()) {
            d.draw(g);
        }
        Drawable preview = repo.getPreviewDrawable();
        if(preview != null) {
            preview.draw(g);
        }
    }
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
