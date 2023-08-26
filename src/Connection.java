public class Connection {
    private int inputNodeIndex;
    private int outputNodeIndex;
    private double weight;

    public Connection(int inputNodeIndex, int outputNodeIndex, double weight) {
        this.inputNodeIndex = inputNodeIndex;
        this.outputNodeIndex = outputNodeIndex;
        this.weight = weight;
    }

    public int getInputNodeIndex() {
        return inputNodeIndex;
    }

    public int getOutputNodeIndex() {
        return outputNodeIndex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
