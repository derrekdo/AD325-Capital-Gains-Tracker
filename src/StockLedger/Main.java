package StockLedger;

import MyUtils.EmptyQueueException;

public class Main {
    public static void main(String[] args) throws EmptyQueueException {
        StockLedger derksLedger = new StockLedger();
        //derksLedger.buy("AAPL", 20, 45);
        derksLedger.buy("TSLA", 20, 100);
        System.out.println(derksLedger.contains("AAPL"));

        //   derksLedger.getEntry("AAPL");

    }

}
