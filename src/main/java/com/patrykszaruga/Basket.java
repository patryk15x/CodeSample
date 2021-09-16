package main.java.com.patrykszaruga;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    private int addToBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item,0);
            int total = inBasket+quantity;
            list.put(item, total);
            return total;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity){
        if ((item != null) && (quantity > 0)){
            //check if we have already item in basket
            int inBasket = list.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;

            if (newQuantity > 0){
                list.put(item, newQuantity);
                return quantity;
            } else if (newQuantity == 0){
                list.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    public int removeItem(Basket basket, String item, int quantity, StockList stockList){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public void checkOut(Basket basket, StockList stockList){
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }

    public void clearBasket(){
        this.list.clear();
    }

    public Map<StockItem, Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    public int sellItem(Basket basket, String item, int quantity, StockList stockList){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0){
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() +
                ((list.size() == 1) ? " item" :  " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
