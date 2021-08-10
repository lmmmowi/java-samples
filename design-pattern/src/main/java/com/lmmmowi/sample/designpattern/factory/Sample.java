package com.lmmmowi.sample.designpattern.factory;

public class Sample {

    public static void main(String[] args) {
        Cook cook = new Cook();

        // 想吃咸的
        Dish dish = cook.prepare(DishStyle.SALTY);
        System.out.println(dish.taste());

        // 想吃甜的
        dish = cook.prepare(DishStyle.SWEET);
        System.out.println(dish.taste());

        // 想吃辣的
        dish = cook.prepare(DishStyle.SPICY);
        System.out.println(dish.taste());
    }
}
