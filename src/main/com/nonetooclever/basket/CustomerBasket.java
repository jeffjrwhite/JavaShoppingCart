package com.nonetooclever.basket;
import com.nonetooclever.products.Fruit;
import com.nonetooclever.products.FruitEnum;
import com.nonetooclever.promotions.PromotionalPriceCalc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerBasket {

    List<Fruit> basket = new ArrayList<Fruit>();

    public void addFruit(Fruit fruit) {
        basket.add(fruit);
    }
    public void addFruit(Fruit fruit, int count) {
        for (int i = 0 ; i < count ; i++) basket.add(fruit);
    }

    public void printContents() {
        for (int i = 0 ; i < basket.size() ; i++)
            System.out.println(basket.get(i).toString());
    }

    public int numberOfItems() {
        return basket.size();
    }

    public boolean isEmpty() {
        return numberOfItems() == 0;
    }

    public int totalCost() {
        return basket.stream().mapToInt(b -> b.price).sum();
    }

    static public int totalCost(List<Fruit> list) {
        return list.stream().mapToInt(b -> b.price).sum();
    }

    public String totalCostFormatted() {
        return String.format("%4d.%02d", totalCost()/100, totalCost()%100);
    }

    public Map<FruitEnum, List<Fruit>> mapOfContents(){
        return basket.stream().collect(Collectors.groupingBy(Fruit::getType));
    }
    public void printContentsCondensed() {
        Map<FruitEnum, List<Fruit>> mapOfContents = mapOfContents();
        // System.out.println(mapOfContents);
        for (Map.Entry<FruitEnum, List<Fruit>> entry : mapOfContents.entrySet()) {
           // System.out.println(entry.getKey() + ":" + entry.getValue());
            int totalCostPerFruit = entry.getValue().stream().mapToInt(b -> b.price).sum();
            System.out.println(entry.getKey().toString() + "(s), price " + String.format("%4d.%02d", totalCostPerFruit/100, totalCostPerFruit%100));
        }
    }

    public int totalCostPromotionalPrice(PromotionalPriceCalc calc) {
        Map<FruitEnum, List<Fruit>> mapOfContents = mapOfContents();
        // System.out.println(mapOfContents);
        int total = 0;
        for (Map.Entry<FruitEnum, List<Fruit>> entry : mapOfContents.entrySet()) {
            // System.out.println(entry.getKey() + ":" + entry.getValue());
            total += calc.calculatePrice(entry.getKey(), entry.getValue());
            // System.out.println("total " + total);
        }
        return total;
    }

}
