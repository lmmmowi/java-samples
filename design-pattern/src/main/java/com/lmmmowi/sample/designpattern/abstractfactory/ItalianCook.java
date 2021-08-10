package com.lmmmowi.sample.designpattern.abstractfactory;

import com.lmmmowi.sample.designpattern.common.*;

class ItalianCook implements Cook {

    @Override
    public Dish prepare(DishStyle dishStyle) {
        switch (dishStyle) {
            case SALTY:
                return new RoastChicken();
            case SWEET:
                return new CheeseCake();
            case SPICY:
                return new ShrimpFraDiavolo();
            default:
                return null;
        }
    }
}
