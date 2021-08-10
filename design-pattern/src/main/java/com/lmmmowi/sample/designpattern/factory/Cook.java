package com.lmmmowi.sample.designpattern.factory;

public class Cook {

    public Dish prepare(DishStyle dishStyle) {
        switch (dishStyle) {
            case SALTY:
                return new RoastChicken();
            case SWEET:
                return new Cake();
            case SPICY:
                return new MapoTofu();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
