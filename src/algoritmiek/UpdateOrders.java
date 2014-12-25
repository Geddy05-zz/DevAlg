package algoritmiek;

/**
 * Created by sam on 25/12/2014.
 */
public class UpdateOrders implements Runnable {
    public UpdateOrders() {
    }
    public void run() {
        Algoritmiek.keys.update();
    }
}
