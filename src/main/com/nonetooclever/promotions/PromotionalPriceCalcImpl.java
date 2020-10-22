package com.nonetooclever.promotions;

import com.nonetooclever.products.Fruit;
import com.nonetooclever.products.FruitEnum;

import java.util.List;

public class PromotionalPriceCalcImpl implements PromotionalPriceCalc{

    public int calculatePrice(FruitEnum type, List<Fruit> list){
        //System.out.println("PromotionalPriceCalcImpl type " + type.toString() + " list " + list);
        if (list.isEmpty()) return 0;
        Fruit fruit = list.get(0);
        //System.out.println("Fruit " + fruit);
        Promotion promotion = fruit.promotion;
        //System.out.println("Promotion " + promotion);
        return promotion.promotionalTotal(list);
    }
}
