import com.nonetooclever.products.Apple;
import com.nonetooclever.products.Orange;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nonetooclever.basket.*;

import static jdk.nashorn.internal.objects.Global.println;

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

    }
}
