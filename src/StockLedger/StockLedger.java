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
        ledger.get(ledger.indexOf(stock)).addPurchasedStocks(stock, stock.getSharesBought());


    }


    public double sell(String stockSymbol, int sharesSold, double pricePerShare) {
        return 0;
    }


    public boolean contains(String stockSymbol) {
        //loops through the ArrayList containing each ledger entry
        for(int i = 0; i < ledger.size(); i++){
            //checks if the stock exists in the ledger
            if(Objects.equals(ledger.get(i).getStockSymbol(), stockSymbol)){
                return true;
            }
        }
        return false;
    }


    public LedgerEntry getEntry(String stockSymbol) {
        return null;
    }
}
