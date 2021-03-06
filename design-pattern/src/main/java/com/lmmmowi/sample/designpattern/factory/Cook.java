package com.lmmmowi.sample.designpattern.factory;

import com.lmmmowi.sample.designpattern.common.*;

class Cook {

    Dish prepare(DishStyle dishStyle) {
        switch (dishStyle) {
            case SALTY:
                return new RoastChicken();
            case SWEET:
                return new CheeseCake();
            case SPICY:
                return new MapoTofu();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
