package com.nonetooclever.promotions;

import com.nonetooclever.basket.CustomerBasket;
import com.nonetooclever.products.Fruit;

import java.util.List;
import java.util.Objects;

public class Promotion {

    public PromotionEnum type = PromotionEnum.None;
    public PromotionEnum getType() { return type; }

    public int promotionalTotal(List<Fruit> list) {
        // Calculate full cost of this type of fruit (no promotianal discount)
        int total = CustomerBasket.totalCost(list);
        System.out.println("promotionalTotal " + this.type + " : " + total);
        return total;
    }

    public String toString() {
        return String.format("%s", type.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return type == promotion.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
