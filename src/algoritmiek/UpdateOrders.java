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
    private Keys key;
    private ArrayList<BestelInformatie> orders = new ArrayList<BestelInformatie>();
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    Date startDate = new Date();

    public UpdateOrders(Keys key) {
        this.key = key;

        BestelInformatie orderOne = new BestelInformatie(1, 5, "00:01:12");
        BestelInformatie orderTwo = new BestelInformatie(2, 3, "00:03:02");
        BestelInformatie orderThree = new BestelInformatie(3, 2, "00:04:10");

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
            Algoritmiek.keys.update();

            // System.out.println("handling order with KlantID:  " + orders.get(pointer).KlantId);
            orders.get(0).isVerwerkt = true;
            try {
                Date durationOfCurrentOrder = formatter.parse(orders.get(0).Duur);
                System.out.println("durationOfCurrentOrder:  " + durationOfCurrentOrder.toString());
                long finishSum = durationOfCurrentOrder.getTime() + startDate.getTime();
                System.out.println("finishSum:  " + finishSum);
                Date sumDate = new Date(finishSum);
                System.out.println("sumDate:  " + sumDate.toString());
                Date dateNow = new Date();
                System.out.println("dateNow:  " + dateNow.toString());
                if (dateNow.after(sumDate)) {
                    orders.get(0).isFinished = true;
                    orders.remove(0);
                    if (orders.isEmpty()) {
                        running = false;
                    }
                    startDate = dateNow;
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
