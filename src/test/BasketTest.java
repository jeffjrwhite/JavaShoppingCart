import com.nonetooclever.products.Apple;
import com.nonetooclever.products.Orange;
import com.nonetooclever.promotions.BuyOneGetOneFree;
import com.nonetooclever.promotions.PromotionalPriceCalc;
import com.nonetooclever.promotions.PromotionalPriceCalcImpl;
import com.nonetooclever.promotions.ThreeForTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nonetooclever.basket.*;

public class BasketTest {

    @Test
    public void basketTests() {

        CustomerBasket basket = new CustomerBasket();
        Assert.assertTrue(basket.isEmpty(), "Basket is NOT empty");
        basket.addFruit(new Apple(50));
        Assert.assertTrue(basket.isEmpty() == false, "Basket is empty");
        Assert.assertTrue(basket.numberOfItems() == 1, "Basket does NOT hold 1 item");
        Assert.assertTrue(basket.totalCost() == 50, "Basket total does not add up correctly");
        basket.addFruit(new Orange(85), 3);
        basket.printContents();
        System.out.println("Total cost : " + basket.totalCostFormatted());
        Assert.assertTrue(basket.totalCost() == 305, "Basket total does not add up correctly");
        basket.printContentsCondensed();

        System.out.println("\nCalculate promotional total on basket with no Promotions active");
        PromotionalPriceCalc promotionalPriceCalc = new PromotionalPriceCalcImpl();
        basket.totalCostPromotionalPrice(promotionalPriceCalc);

        System.out.println("\nTest promotions BuyOneGetOneFree ===============\n");
        CustomerBasket promoBasketBuyOneGetOneFree = new CustomerBasket();
        Assert.assertTrue(promoBasketBuyOneGetOneFree.isEmpty(), "promoBasketBuyOneGetOneFree is NOT empty");
        promoBasketBuyOneGetOneFree.addFruit(new Apple(50, new BuyOneGetOneFree()));
        promoBasketBuyOneGetOneFree.addFruit(new Apple(50, new BuyOneGetOneFree()));
        promoBasketBuyOneGetOneFree.addFruit(new Apple(50, new BuyOneGetOneFree()));
        Assert.assertTrue(promoBasketBuyOneGetOneFree.isEmpty() == false, "promoBasketBuyOneGetOneFree is empty");
        promoBasketBuyOneGetOneFree.totalCostPromotionalPrice(promotionalPriceCalc);
        Assert.assertTrue(promoBasketBuyOneGetOneFree.totalCostPromotionalPrice(promotionalPriceCalc) == 100,
                "promotionalPriceCalcBuyOneGetOneFree is NOT correct");

        System.out.println("Basket " + promoBasketBuyOneGetOneFree.mapOfContents());
        System.out.println("Promotional Total cost : " + promoBasketBuyOneGetOneFree.totalCostPromotionalPrice(promotionalPriceCalc));
        System.out.println("Total cost : " + promoBasketBuyOneGetOneFree.totalCostFormatted());

        System.out.println("\nAdd another Apple\n");
        promoBasketBuyOneGetOneFree.addFruit(new Apple(50, new ThreeForTwo()));
        promoBasketBuyOneGetOneFree.totalCostPromotionalPrice(promotionalPriceCalc);
        Assert.assertTrue(promoBasketBuyOneGetOneFree.totalCostPromotionalPrice(promotionalPriceCalc) == 100,
                "promoBasketBuyOneGetOneFree is NOT correct");

        System.out.println("Basket " + promoBasketBuyOneGetOneFree.mapOfContents());
        System.out.println("Promotional Total cost : " + promoBasketBuyOneGetOneFree.totalCostPromotionalPrice(promotionalPriceCalc));
        System.out.println("Total cost : " + promoBasketBuyOneGetOneFree.totalCostFormatted());

        System.out.println("\nTest promotions ThreeForTwo ===============\n");
        CustomerBasket promoBasketThreeForTwo = new CustomerBasket();
        Assert.assertTrue(promoBasketThreeForTwo.isEmpty(), "promoBasketThreeForTwo is NOT empty");
        promoBasketThreeForTwo.addFruit(new Apple(50, new ThreeForTwo()));
        promoBasketThreeForTwo.addFruit(new Apple(50, new ThreeForTwo()));
        promoBasketThreeForTwo.addFruit(new Apple(50, new ThreeForTwo()));
        Assert.assertTrue(promoBasketThreeForTwo.isEmpty() == false, "promoBasketThreeForTwo is empty");
        promoBasketThreeForTwo.totalCostPromotionalPrice(promotionalPriceCalc);
        Assert.assertTrue(promoBasketThreeForTwo.totalCostPromotionalPrice(promotionalPriceCalc) == 100,
                "promotionalPriceCalcThreeForTwo is NOT correct");

        System.out.println("Basket " + promoBasketThreeForTwo.mapOfContents());
        System.out.println("Promotional Total cost : " + promoBasketThreeForTwo.totalCostPromotionalPrice(promotionalPriceCalc));
        System.out.println("Total cost : " + promoBasketThreeForTwo.totalCostFormatted());

        System.out.println("\nAdd another Apple\n");
        promoBasketThreeForTwo.addFruit(new Apple(50, new ThreeForTwo()));
        promoBasketThreeForTwo.totalCostPromotionalPrice(promotionalPriceCalc);
        Assert.assertTrue(promoBasketThreeForTwo.totalCostPromotionalPrice(promotionalPriceCalc) == 150,
                "promotionalPriceCalcThreeForTwo is NOT correct");

        System.out.println("Basket " + promoBasketThreeForTwo.mapOfContents());
        System.out.println("Promotional Total cost : " + promoBasketThreeForTwo.totalCostPromotionalPrice(promotionalPriceCalc));
        System.out.println("Total cost : " + promoBasketThreeForTwo.totalCostFormatted());
        Assert.assertTrue(promoBasketThreeForTwo.totalCost() == 200, "Basket total does not add up correctly");

    }
}
