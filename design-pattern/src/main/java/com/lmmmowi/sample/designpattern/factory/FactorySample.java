package com.lmmmowi.sample.designpattern.factory;

import com.lmmmowi.sample.designpattern.common.Dish;
import com.lmmmowi.sample.designpattern.common.DishStyle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactorySample {

    public static void main(String[] args) {
        Cook cook = new Cook();

        // 想吃咸的
        Dish dish = cook.prepare(DishStyle.SALTY);
        log.info(dish.taste());

        // 想吃甜的
        dish = cook.prepare(DishStyle.SWEET);
        log.info(dish.taste());

        // 想吃辣的
        dish = cook.prepare(DishStyle.SPICY);
        log.info(dish.taste());
    }
}
