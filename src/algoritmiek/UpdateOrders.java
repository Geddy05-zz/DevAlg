package algoritmiek;

/**
 * Created by sam on 25/12/2014.
 */
public class UpdateOrders implements Runnable {

    public static boolean running;
    private Keys key;

    public UpdateOrders(Keys key) {
        this.key = key;
    }
    public void run() {
        running = true;
        while(running) {
            if (key.i) {
                System.out.println("i");
            }
            Algoritmiek.keys.update();
        }
    }
}
