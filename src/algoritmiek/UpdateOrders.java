package algoritmiek;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sam on 25/12/2014.
 */
public class UpdateOrders implements Runnable {

    public static boolean running;
    private ArrayList<BestelInformatie> orders = new ArrayList<BestelInformatie>();
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    Date startDate = new Date();
    Date endDate = new Date();
    private boolean preparingJob;

    public UpdateOrders() {

        BestelInformatie orderOne = new BestelInformatie(1, 5, 1000);
        BestelInformatie orderTwo = new BestelInformatie(2, 3, 10000);
        BestelInformatie orderThree = new BestelInformatie(3, 2, 2000);

        orders.add(orderOne);
        orders.add(orderTwo);
        orders.add(orderThree);

        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).isWaiting = true;
        }
    }
    public void run() {
        running = true;
        while(running) {
            orders.get(0).isVerwerkt = true;
            if (!preparingJob) {
                preparingJob = true;
                try {
                    startDate = new Date();
                    endDate.setTime(startDate.getTime() + orders.get(0).Duur);
                } catch (Exception e) {
                    System.err.println(e);
                }
                System.out.println("Current job for klant:   " + orders.get(0).KlantId);
                System.out.println("duration:   " + orders.get(0).Duur + " miliseconds");
            }
            startDate = new Date();
            if (startDate.after(endDate)) {
                orders.get(0).isFinished = true;
                orders.remove(0);
                preparingJob = false;
                if (orders.isEmpty()) {
                    System.out.println("Queue empty");
                    running = false;
                }
            }
        }
    }
}
