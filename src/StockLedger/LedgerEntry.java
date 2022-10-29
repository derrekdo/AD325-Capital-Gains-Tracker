package StockLedger;

import Deque.LinkedDeque;
import MyUtils.EmptyQueueException;

import java.util.Iterator;

public class LedgerEntry {
    private String stockSymbol;
    private LinkedDeque<StockPurchase> deque = new LinkedDeque<>();

    /**
     * Default constructor
     * @param stockSymbol the name of this Ledger Entry
     */
    public LedgerEntry(String stockSymbol){
        this.stockSymbol = stockSymbol;
    }

    /**
     * Adds shares to this entry
     * @param stock represents the particular share being bought at its current price
     * @param sharesBought the total bought
     */
    public void addStocks(StockPurchase stock, int sharesBought){
        //adds the shares to the entry based on the shares bought
        //Runtime: O(N)
        for(int i = 0; i < sharesBought; i++){
            deque.addToBack(stock);
        }
    }

    /**
     * Removes shares from this entry, and adding their costs together
     * @param shareSold the amount being sold
     * @return the total cost of the stocks sold
     * @throws EmptyQueueException
     */
    public double sellStocks(int shareSold) throws EmptyQueueException {
        int i = 0;
        double total = 0;

        //Runtime O(N)
        //sells each stock until it reaches the amount wanted
        while(i < shareSold){
            //Total of each stock sold
            total += deque.getFront().getPricePerShare();
            //removes a share from the ledger
            deque.getFront().setShares();
            deque.removeFront();
            //System.out.println("total " + total);
            i++;
        }
        return total;
    }

    /**
     * getter for the stock symbol
     * @return stockSymbol
     */
    public String getStockSymbol(){
        return stockSymbol;
    }

    //String representation of the Ledger Entry
    public String toString() {
        if(deque.isEmpty()){
            return stockSymbol + ": Empty Ledger";
        }
        //iterator for the deque
        Iterator<StockPurchase> iterator = deque.getIterator();
        //temporary stock to pull data out
        StockPurchase current = iterator.next();
        double cost = current.getPricePerShare();
        int total = current.getShares();

        StringBuilder result = new StringBuilder(stockSymbol + ": " + cost + " (" + total + " shares)");

        //iterates through the deque
        //Runtime: O(N)
        while(iterator.hasNext()){
            StockPurchase prev = current;
            current = iterator.next();

            //compares the current and previous stock in the deque
            if(current != prev){
                //If there is a new stock type in this deque, it is added to the string
                cost = current.getPricePerShare();
                total = current.getShares();
                result.append(", " + cost + " (" + total + " shares)");
            }
        }
        return result + "";
    }
}
