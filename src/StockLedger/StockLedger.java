package StockLedger;

import MyUtils.EmptyQueueException;
import java.util.*;


public class StockLedger implements StockLedgerInterface{

    private ArrayList<LedgerEntry> ledger = new ArrayList<>();

    public void buy(String stockSymbol, int sharesBought, double pricePerShare){
        //Creates the stocks purchased
        StockPurchase stock = new StockPurchase(stockSymbol, sharesBought, pricePerShare);

        //checks if the stock already exists in the ledger
        if(!contains(stockSymbol)) {
            //creates an LedgerEntry instance
            ledger.add(new LedgerEntry(stockSymbol));
        }
        //Adds the bought stocks to the ledger entry
        ledger.get(search(stockSymbol)).addStocks(stock, sharesBought);
    }

    public double sell(String stockSymbol, int sharesSold, double pricePerShare) throws EmptyQueueException {
        //checks if the stock already exists
        if(!contains(stockSymbol)){
            return 0;
        }

        //Calculates the profits, the gain or loss from selling
        double total = ledger.get(search(stockSymbol)).sellStocks(sharesSold);
        double profit = (pricePerShare * sharesSold) - total;

        return profit;
    }

    public boolean contains(String stockSymbol) {
        return search(stockSymbol) != -1;
    }

    /**
     * Private helper method to find the location of the Stock Entry in the ledger
     * @param stockSymbol the stock to find
     * @return location of the stock in the ledger and -1 if it does not exist
     */
    private int search(String stockSymbol){
        //loops through the ledger to find the entry wanted
        //Runtime O(N)
        for(int i = 0; i < ledger.size(); i++){
            if(ledger.get(i).getStockSymbol() == stockSymbol){
                //returns the location of the entry in the ledger array list
                return i;
            }
        }
        return -1;
    }

    public LedgerEntry getEntry(String stockSymbol) {
        return ledger.get(search(stockSymbol));
    }
}
