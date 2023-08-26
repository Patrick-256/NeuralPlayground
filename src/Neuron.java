/**
 * The Neuron will have a bias and a type.
 * types can be: sigmoid or rectifier
 * iot: (Input Output Type) can be: input, hidden or output
 */
public class Neuron {
    private double bias;
    private String type;
    private String iot;
    private double outputValue = 0;

    public Neuron(double bias, String type, String iot) {
        this.bias = bias;
        this.type = type;
        this.iot = iot;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public String getType() {
        return type;
    }

    public String getIot() {
        return iot;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }


}
