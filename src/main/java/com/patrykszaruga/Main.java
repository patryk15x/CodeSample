package main.java.com.patrykszaruga;

public class Main {

    public static void main(String[] args) {
        StockList stockList = new StockList();
        populate(stockList);

        stockList.displayList();

        Basket adasBasket = new Basket("Ada");
        adasBasket.sellItem(adasBasket, "car", 1, stockList);
        adasBasket.displayBasket();



        adasBasket.checkOut(adasBasket, stockList);
    }

    public static void populate(StockList stockList){
        stockList.addStock( new StockItem("bread", 0.86, 100));
        stockList.addStock( new StockItem("cake", 1.10, 7));
        stockList.addStock( new StockItem("car", 12.50, 2));
        stockList.addStock( new StockItem("chair", 52.0, 10));
        stockList.addStock( new StockItem("cup", 0.50, 200));
        stockList.addStock( new StockItem("cup", 0.45, 7));
        stockList.addStock( new StockItem("door", 72.95, 4));
        stockList.addStock( new StockItem("juice", 2.50, 36));
        stockList.addStock( new StockItem("phone", 96.99, 35));
        stockList.addStock( new StockItem("towel", 2.40, 80));
        stockList.addStock( new StockItem("vase", 8.75, 40));

    }
}



