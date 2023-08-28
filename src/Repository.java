import java.util.ArrayList;
import java.util.Observable;

public class Repository extends Observable {
    private static Repository repository;
    private String currentMode;
    private ArrayList<Drawable> drawables;
    private Drawable previewDrawable;
    private NeuralNetwork neuralNetwork;

    private Repository() {
        currentMode = null;
        drawables = new ArrayList<>();
        neuralNetwork = new NeuralNetwork();
    }

    public static Repository getInstance() {
        if(repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public String getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(String currentMode) {
        this.currentMode = currentMode;
    }

    public ArrayList<Drawable> getDrawables() {
        return drawables;
    }

    public void addDrawable(Drawable d) {
        this.drawables.add(d);
        this.setChanged();
        this.notifyObservers();
    }

    public NeuralNetwork getNeuralNetwork() {
        return neuralNetwork;
    }

    public void addNeuron(Neuron n) {
        this.neuralNetwork.addNeuron(n);
    }
    public void addConnection(Connection c) {
        this.neuralNetwork.addConnection(c);
    }

    public void removeAllDrawables() {
        drawables.removeAll(drawables);
    }

    /**
     * Function will return the center point of an existing Drawable if
     * the provided coordinates are located inside the existing Drawable
     * @param x
     * @param y
     * @return array [x,y] of center point in which to snap to
     */
    public int[] snapCordinates(int x, int y) {
        int[] center = {-1,-1};
        for (Drawable d : drawables) {
            if(d instanceof Entity) {
                if(x < ((Entity) d).getShape().getxPos() + ((Entity) d).getShape().getWidth() &&
                   x > ((Entity) d).getShape().getxPos() &&
                   y < ((Entity) d).getShape().getyPos() + ((Entity) d).getShape().getWidth() &&
                   y > ((Entity) d).getShape().getyPos()) {
                    center[0] = ((Entity) d).getShape().getxPos()+((Entity) d).getShape().getWidth()/2;
                    center[1] = ((Entity) d).getShape().getyPos()+((Entity) d).getShape().getHeight()/2;
                }
            }
        }
        return center;
    }

    public boolean setCenterLocationOfEntity(int x, int y) {
        boolean success = false;
        for (Drawable d : drawables) {
            if(d instanceof Entity) {
                if(x < ((Entity) d).getShape().getxPos() + ((Entity) d).getShape().getWidth() &&
                        x > ((Entity) d).getShape().getxPos() &&
                        y < ((Entity) d).getShape().getyPos() + ((Entity) d).getShape().getWidth() &&
                        y > ((Entity) d).getShape().getyPos()) {

                    ((Entity) d).getShape().setCenterPoint(x,y);
                    this.setChanged();
                    this.notifyObservers();
                    success = true;
                }
            }
            if(d instanceof Line) {
                if(withinRange(x,y,((Line) d).getStartX(),((Line) d).getStartY(),10)) {
                    ((Line) d).setStartX(x);
                    ((Line) d).setStartY(y);
                    success = true;
                }
                if(withinRange(x,y,((Line) d).getDestinationX(),((Line) d).getDestinationY(),10)) {
                    ((Line) d).setDestinationX(x);
                    ((Line) d).setDestinationY(y);
                    success = true;
                }
            }
        }
        return success;
    }
    private boolean withinRange(int x1,int y1,int x2,int y2,int range) {
        if(Math.abs(x1-x2) < range && Math.abs(y1-y2) < range) return true;
        return false;
    }

    public void setPreviewDrawable(Drawable d) {
        System.out.println("preview set!");
        this.previewDrawable = d;
        this.setChanged();
        this.notifyObservers();
    }
    public void clearPreviewDrawable() {
        this.previewDrawable = null;
    }

    public Drawable getPreviewDrawable() {
        return previewDrawable;
    }
}
