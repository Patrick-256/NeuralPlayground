import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class NeuralPlayground extends JFrame implements Observer {

    public NeuralPlayground() {
        super("Neural Playground");
        this.setLayout(new BorderLayout());
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Repository repo = Repository.getInstance();


        JMenuBar menuBar = new JMenuBar();
        MenuBarControlHandler menuBarControlHandler = new MenuBarControlHandler();

        JMenu file = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        save.addActionListener(menuBarControlHandler);
        load.addActionListener(menuBarControlHandler);
        file.add(save);
        file.add(load);

        JMenu create = new JMenu("Create");
        JMenuItem node = new JMenuItem("Node");
        JMenuItem connection = new JMenuItem("Connection");
        JMenuItem input = new JMenuItem("Input");
        JMenuItem output = new JMenuItem("Output");
        JMenuItem label = new JMenuItem("Label");
        node.addActionListener(menuBarControlHandler);
        connection.addActionListener(menuBarControlHandler);
        input.addActionListener(menuBarControlHandler);
        output.addActionListener(menuBarControlHandler);
        label.addActionListener(menuBarControlHandler);
        create.add(input);
        create.add(node);
        create.add(output);
        create.add(connection);
        create.add(label);

        JMenu edit = new JMenu("Edit");
        JMenuItem clear = new JMenuItem("Clear");
        clear.addActionListener(menuBarControlHandler);
        edit.add(clear);

        menuBar.add(file);
        menuBar.add(create);
        menuBar.add(edit);

        this.add(menuBar,BorderLayout.NORTH);

        NetworkPanel networkPanel = new NetworkPanel();
        networkPanel.setBackground(Color.GRAY);

        NetworkPanelControlHandler networkPanelControlHandler = new NetworkPanelControlHandler();
        networkPanel.addMouseListener(networkPanelControlHandler);
        networkPanel.addMouseMotionListener(networkPanelControlHandler);

        repo.addObserver(networkPanel);

        this.add(networkPanel, BorderLayout.CENTER);

        this.setVisible(true);
        repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        String command = (String) arg;
        System.out.println("main update: "+command);
    }

    public static void main(String[] args) {
        new NeuralPlayground();
    }
}
