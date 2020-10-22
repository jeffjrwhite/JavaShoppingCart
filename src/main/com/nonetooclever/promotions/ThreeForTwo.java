package com.nonetooclever.promotions;

import com.nonetooclever.basket.CustomerBasket;
import com.nonetooclever.products.Fruit;

import java.util.List;

public class ThreeForTwo extends Promotion{

    public ThreeForTwo() {
        this.type = PromotionEnum.ThreeForTwo;
    }

    public int promotionalTotal(List<Fruit> list) {
        if (list.isEmpty()) return 0;
        int numberOfItems = list.size();
        int numOfpromotionalItems = numberOfItems/3;
        int numOfFullPriceItems = numberOfItems%3;
        int total = numOfpromotionalItems*list.get(0).price*2
                +numOfFullPriceItems*list.get(0).price;
        //System.out.println("promotionalTotal " + this.type + " : " + total);
        return total;
    }

}
