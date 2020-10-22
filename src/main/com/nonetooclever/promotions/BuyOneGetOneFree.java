package com.nonetooclever.promotions;

import com.nonetooclever.basket.CustomerBasket;
import com.nonetooclever.products.Fruit;

import java.util.List;

public class BuyOneGetOneFree extends Promotion{

    public BuyOneGetOneFree() {
        this.type = PromotionEnum.BuyOneGetOneFree;
    }

    public int promotionalTotal(List<Fruit> list) {
        if (list.isEmpty()) return 0;
        int numberOfItems = list.size();
        int numOfpromotionalItems = numberOfItems/2;
        int numOfFullPriceItems = numberOfItems%2;
        int total = numOfpromotionalItems*list.get(0).price
                +numOfFullPriceItems*list.get(0).price;
        //System.out.println("promotionalTotal " + this.type + " : " + total);
        return total;
    }


}
