package com.lmmmowi.sample.designpattern.abstractfactory;

import com.lmmmowi.sample.designpattern.common.Dish;
import com.lmmmowi.sample.designpattern.common.DishStyle;

interface Cook {

    Dish prepare(DishStyle dishStyle);
}
