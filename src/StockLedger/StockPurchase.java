package StockLedger;

public class StockPurchase {
    private String stockSymbol;
    private int sharesBought;
    private double pricePerShare;

    public StockPurchase(String stockSymbol, int sharesBought, double pricePerShare){
        this.stockSymbol = stockSymbol;
        this.sharesBought = sharesBought;
        this.pricePerShare = pricePerShare;
    }

    /**
     * returns the amounts of shares bought
     * @return sharesBought
     */
    public int getSharesBought(){
        return sharesBought;
    }
    public double getPricePerShare(){
        return pricePerShare;
    }
}
