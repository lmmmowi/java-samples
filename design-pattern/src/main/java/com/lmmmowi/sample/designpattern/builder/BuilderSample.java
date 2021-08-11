package com.lmmmowi.sample.designpattern.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderSample {

    public static void main(String[] args) {
        SpicyHotPot spicyHotPot = new SpicyHotPot.Builder()
                .setSpicyLevel(SpicyHotPot.SpicyLevel.HOT)
                .setVegetable(1)
                .setMeat(3)
                .build();
        log.info("无肉不欢：{}", spicyHotPot.describe());

        spicyHotPot = new SpicyHotPot.Builder()
                .setSpicyLevel(SpicyHotPot.SpicyLevel.MILD)
                .setVegetable(5)
                .build();
        log.info("素食主义：{}", spicyHotPot.describe());

        // 建造者模式可以在build阶段对构造参数的合法性进行校验
        new SpicyHotPot.Builder()
                .setVegetable(2)
                .setVegetable(2)
                .build();
    }
}
