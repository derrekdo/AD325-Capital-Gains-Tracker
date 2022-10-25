package StockLedger;

import Deque.LinkedDeque;
import MyUtils.EmptyQueueException;

public class LedgerEntry {
    private String stockSymbol;
    private LinkedDeque<StockPurchase> deque = new LinkedDeque<>();

    public LedgerEntry(String stockSymbol){
        this.stockSymbol = stockSymbol;
    }
    public void addPurchasedStocks(StockPurchase stock, int sharesBought){

        for(int i = 0; i < sharesBought; i++){
            deque.addToBack(stock);

        }
    }

    public String getStockSymbol(){
        return stockSymbol;
    }


}
