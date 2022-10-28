package StockLedger;

public class StockPurchase {
    private String stockSymbol;
    private int sharesBought;
    private double pricePerShare;

    /**
     * Default constructor for the stock
     * @param stockSymbol the name of this stock
     * @param pricePerShare the current buy price
     */
    public StockPurchase(String stockSymbol, int sharesBought, double pricePerShare){
        this.stockSymbol = stockSymbol;
        this.sharesBought = sharesBought;
        this.pricePerShare = pricePerShare;
    }

    /**
     * lowers the total shares by 1
     */
    public void setShares(){
        this.sharesBought += -1;
    }

    /**
     * getter for the shares bought and price per
     * @return sharesBought and pricePerShare
     */
    public int getShares(){
        return sharesBought;
    }

    public double getPricePerShare(){
        return pricePerShare;
    }
}
