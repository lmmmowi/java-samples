package com.lmmmowi.sample.designpattern.abstractfactory;

import com.lmmmowi.sample.designpattern.common.Dish;
import com.lmmmowi.sample.designpattern.common.DishStyle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractFactorySample {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // 吃中餐
        serve(restaurant, Restaurant.CHINESE_FOOD);

        // 吃意大利菜
        serve(restaurant, Restaurant.ITALIAN_FOOD);
    }

    private static void serve(Restaurant restaurant, String foodType) {
        log.info("【我要吃{}】", foodType);

        // 在这里厨师就是抽象工厂，根据不同菜系选择特定的厨师
        Cook cook = restaurant.getCook(foodType);

        for (DishStyle dishStyle : DishStyle.values()) {
            Dish dish = cook.prepare(dishStyle);
            log.info(dish.taste());
        }
    }
}
