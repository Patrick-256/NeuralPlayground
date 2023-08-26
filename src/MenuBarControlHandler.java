import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarControlHandler implements ActionListener {



    public MenuBarControlHandler() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Repository repo = Repository.getInstance();

        switch(e.getActionCommand()) {
            case "Save":
                System.out.println("user chose to save");
                break;
            case "Load":
                System.out.println("user chose to load");
                break;
            case "Node":
                repo.setCurrentMode("node");
                break;
            case "Connection":
                repo.setCurrentMode("connection");
                break;
            case "Input":
                repo.setCurrentMode("input");
                break;
            case "Output":
                repo.setCurrentMode("output");
                break;
            case "Label":
                repo.setCurrentMode("label");
                break;
            case "Clear":
                repo.removeAllDrawables();
                break;
        }
    }
}
