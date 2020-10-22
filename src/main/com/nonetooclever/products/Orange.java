package com.nonetooclever.products;

import com.nonetooclever.promotions.Promotion;

public class Orange extends Fruit {

    public Orange(int price) {
        this.price = price;
        this.type = FruitEnum.Orange;
    }

    public Orange(int price, Promotion promotion) {
        this.price = price;
        this.type = FruitEnum.Orange;
        this.promotion = promotion;
    }

}
