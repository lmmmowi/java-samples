package com.lmmmowi.sample.designpattern.abstractfactory;

import com.lmmmowi.sample.designpattern.common.*;

class ChineseCook implements Cook {

    @Override
    public Dish prepare(DishStyle dishStyle) {
        switch (dishStyle) {
            case SALTY:
                return new SesameSeedCake();
            case SPICY:
                return new MapoTofu();
            case SWEET:
                return new SweetDumpling();
            default:
                return null;
        }
    }
}
