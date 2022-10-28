package StockLedger;

import MyUtils.EmptyQueueException;

public class Main {
    public static void main(String[] args) throws EmptyQueueException {
        StockLedger derksLedger = new StockLedger();

        System.out.println("---- Stock Ledger ----");
        derksLedger.buy("AAPL", 20, 45);
        derksLedger.buy("AAPL", 20, 75);
        derksLedger.buy("MSFT", 20, 95);
        System.out.println(derksLedger.getEntry("AAPL"));
        System.out.println(derksLedger.getEntry("MSFT"));

        System.out.println();
        System.out.println("Profit: " + derksLedger.sell("AAPL", 30, 65));
//        derksLedger.sell("AAPL", 30, 65);
        System.out.println("---- Stock Ledger ----");
        System.out.println(derksLedger.getEntry("AAPL"));
        System.out.println(derksLedger.getEntry("MSFT"));

        System.out.println();
        System.out.println("Profit: " + derksLedger.sell("AAPL", 10, 65));
//        derksLedger.sell("AAPL", 10, 65);
        System.out.println("---- Stock Ledger ----");
        System.out.println(derksLedger.getEntry("MSFT"));

        System.out.println();
        derksLedger.buy("AAPL", 100, 20);
        derksLedger.buy("AAPL", 20, 24);
        derksLedger.buy("TSLA", 200, 36);
        System.out.println("---- Stock Ledger ----");
        System.out.println(derksLedger.getEntry("AAPL"));
        System.out.println(derksLedger.getEntry("MSFT"));
        System.out.println(derksLedger.getEntry("TSLA"));

        System.out.println();
        System.out.println("Profit: " + derksLedger.sell("AAPL", 10, 65));
//        derksLedger.sell("AAPL", 10, 65);
        System.out.println("---- Stock Ledger ----");
        System.out.println(derksLedger.getEntry("AAPL"));
        System.out.println(derksLedger.getEntry("MSFT"));
        System.out.println(derksLedger.getEntry("TSLA"));

        System.out.println();
        System.out.println("Profit: " + derksLedger.sell("TSLA", 150, 30));
//        System.out.println(derksLedger.sell("TSLA", 150, 30));
        System.out.println("---- Stock Ledger ----");
        System.out.println(derksLedger.getEntry("AAPL"));
        System.out.println(derksLedger.getEntry("MSFT"));
        System.out.println(derksLedger.getEntry("TSLA"));

        System.out.println();
        derksLedger.buy("MSFT", 5, 60);
        derksLedger.buy("MSFT", 5, 70);
        System.out.println("---- Stock Ledger ----");
        System.out.println(derksLedger.getEntry("AAPL"));
        System.out.println(derksLedger.getEntry("MSFT"));
        System.out.println(derksLedger.getEntry("TSLA"));

        System.out.println();
        System.out.println("Profit: " + derksLedger.sell("MSFT", 4, 30));
//        derksLedger.sell("MSFT", 4, 30);
        System.out.println("---- Stock Ledger ----");
        System.out.println(derksLedger.getEntry("AAPL"));
        System.out.println(derksLedger.getEntry("MSFT"));
        System.out.println(derksLedger.getEntry("TSLA"));

        System.out.println();
        System.out.println("Profit: " + derksLedger.sell("MSFT", 2, 30));
//        derksLedger.sell("MSFT", 2, 30);
        System.out.println("---- Stock Ledger ----");
        System.out.println(derksLedger.getEntry("AAPL"));
        System.out.println(derksLedger.getEntry("MSFT"));
        System.out.println(derksLedger.getEntry("TSLA"));
    }

}
