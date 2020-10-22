package com.nonetooclever.promotions;

import com.nonetooclever.products.Fruit;
import com.nonetooclever.products.FruitEnum;

import java.util.List;

public interface PromotionalPriceCalc {
    int calculatePrice(FruitEnum type, List<Fruit> list);
}
