import java.util.ArrayList;

/**
 * A NeuralNetwork has an array of neurons and an array of connections.
 */
public class NeuralNetwork {
    /**
     * Initializes an empty NeuralNetwork
     */
    private ArrayList<Neuron> neurons;
    private ArrayList<Connection> connections;

    /**
     * Initializes an empty NeuralNetwork
     */
    public NeuralNetwork() {
        neurons = new ArrayList<>();
        connections = new ArrayList<>();
    }

    public void addNeuron(Neuron n) {
        this.neurons.add(n);
    }

    public void addConnection(Connection c){
        this.connections.add(c);

    }

    public void printNeuralNetwork() {
        System.out.println("Neurons:");
    }


}
