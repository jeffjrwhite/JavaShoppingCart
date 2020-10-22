package com.nonetooclever.products;

import com.nonetooclever.promotions.Promotion;

public class Apple extends Fruit {

    public Apple(int price) {
        this.price = price;
        this.type = FruitEnum.Apple;
    }

    public Apple(int price, Promotion promotion) {
        this.price = price;
        this.type = FruitEnum.Apple;
        this.promotion = promotion;
    }
}
