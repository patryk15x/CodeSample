import main.java.com.patrykszaruga.Basket;
import main.java.com.patrykszaruga.StockItem;
import main.java.com.patrykszaruga.StockList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BasketTest {

    @Nested
    @DisplayName("Tests for sellItem() method")
    class TestsForSellItemMethod{

        Basket basket;
        StockList stockList;

        @BeforeEach
        void setUp(){
            basket = new Basket("Sample Basket");
            stockList = new StockList();
        }

        @Test
        void shouldReturnZeroIfItemIsNull() {
            String item = null;
            assertEquals(0, basket.sellItem(basket, item, 1, stockList));
        }

        @Test
        void shouldReturnZeroIfItemIsNotOnTheStockList() {
            String iron = "Iron";
            assertEquals(0, basket.sellItem(basket, iron, 1, stockList));
        }

        @Test
        void shouldNotReturnZeroIfItemIsPresentOnTheStockList() {
            StockItem iron = new StockItem("Iron", 1,5);
            stockList.addStock(iron);
            assertNotEquals(0,basket.sellItem(basket, "Iron", 1, stockList) );
        }

    }
}


