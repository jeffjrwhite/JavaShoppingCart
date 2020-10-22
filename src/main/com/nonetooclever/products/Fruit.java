package com.nonetooclever.products;

import com.nonetooclever.promotions.Promotion;

import java.util.Objects;

abstract public class Fruit {

        FruitEnum type;
        public int price;
        public Promotion promotion = new Promotion();

        public FruitEnum getType() { return type; }
        public void setPromotion(Promotion promotion){
                this.promotion = promotion;
        }

        public String toString() {
                return String.format("%s, price %4d.%02d", type.toString(), price/100, price%100);
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Fruit fruit = (Fruit) o;
                return price == fruit.price &&
                        type == fruit.type;
        }

        @Override
        public int hashCode() {
                return Objects.hash(type, price);
        }
}


