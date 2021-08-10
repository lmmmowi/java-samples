package com.lmmmowi.sample.designpattern.abstractfactory;

class Restaurant {

    static final String CHINESE_FOOD = "中餐";
    static final String ITALIAN_FOOD = "意大利菜";

    Cook getCook(String type) {
        switch (type) {
            case CHINESE_FOOD:
                return new ChineseCook();
            case ITALIAN_FOOD:
                return new ItalianCook();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
