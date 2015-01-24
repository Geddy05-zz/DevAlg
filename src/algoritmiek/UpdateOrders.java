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
    private ArrayList<BestelInformatie> allOrders = new ArrayList<BestelInformatie>();
    private ArrayList<BestelInformatie> dadelijkeOrders = new ArrayList<BestelInformatie>();
    private ArrayList<BestelInformatie> longerOrders= new ArrayList<BestelInformatie>();
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    Date currentTime = new Date();

    public UpdateOrders() {

        // init the orders
        BestelInformatie orderOne = new BestelInformatie(1, 5, 1000, true);
        BestelInformatie orderTwo = new BestelInformatie(2, 3, 10000, false);
        BestelInformatie orderThree = new BestelInformatie(1, 2, 2500, true);
        BestelInformatie orderFour = new BestelInformatie(4, 1, 12010, false);
        BestelInformatie orderFive = new BestelInformatie(6, 6, 1000, true);

        allOrders.add(orderOne);
        allOrders.add(orderTwo);
        allOrders.add(orderThree);
        allOrders.add(orderFour);
        allOrders.add(orderFive);

        for (int i = 0; i < allOrders.size(); i++) {
            if (allOrders.get(i).isWaiting) {
                dadelijkeOrders.add(allOrders.get(i));
            } else {
                longerOrders.add(allOrders.get(i));
            }
        }
    }

    private boolean dadelijkeIsFinished, longerIsFinished;

    public void run() {
        running = true;
        while(running) {
            if (!dadelijkeOrders.isEmpty()) {
                runOrders(dadelijkeOrders);
            } else {
                if (!dadelijkeIsFinished) {
                    System.out.println("Dadelijke orders machine finished");
                    dadelijkeIsFinished = true;
                }
            }
            if (!longerOrders.isEmpty()) {
                runOrders(longerOrders);

            } else {
                if (!longerIsFinished) {
                    System.out.println("Longer orders machine finished");
                    longerIsFinished = true;
                }
            }
        }
    }

    private void runOrders(ArrayList<BestelInformatie> orderList) {
        orderList.get(0).isVerwerkt = true;
        if (orderList.get(0).startTijd == null) {
            try {
                currentTime = new Date();
                orderList.get(0).startTijd = currentTime;
            } catch (Exception e) {
                System.err.println(e);
            }
            System.out.println("Job started for KlantID:   " + orderList.get(0).KlantId);
            System.out.println("duration:   " + orderList.get(0).Duur + " miliseconds");
        }
        currentTime = new Date();
        Date checkDate = new Date();
        checkDate.setTime(orderList.get(0).startTijd.getTime() + orderList.get(0).Duur);
        if (currentTime.after(checkDate)) {
            orderList.get(0).isFinished = true;
            orderList.remove(0);
        }
    }
}
