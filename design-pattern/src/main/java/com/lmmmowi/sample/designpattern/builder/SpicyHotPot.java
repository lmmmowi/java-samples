package com.lmmmowi.sample.designpattern.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class SpicyHotPot {

    public static final int NONE = 0;
    public static final int MILD = 1;
    public static final int MEDIUM = 2;
    public static final int HOT = 3;

    private SpicyLevel spicyLevel;
    private int vegetable;
    private int meat;

    private SpicyHotPot(SpicyLevel spicyLevel, int vegetable, int meat) {
        this.spicyLevel = spicyLevel;
        this.vegetable = vegetable;
        this.meat = meat;
    }

    public String describe() {
        return "这是一份"
                + spicyLevel.name
                + "的麻辣烫，包含"
                + vegetable + "份蔬菜、"
                + meat + "份肉。";
    }

    @AllArgsConstructor
    public enum SpicyLevel {
        NONE("不辣"),
        MILD("微辣"),
        MEDIUM("中辣"),
        HOT("特辣");

        private String name;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Builder {

        private SpicyLevel spicyLevel;
        private int vegetable;
        private int meat;

        public SpicyHotPot build() {
            if (spicyLevel == null) {
                throw new IllegalArgumentException("请选择辣度");
            }

            return new SpicyHotPot(spicyLevel, vegetable, meat);
        }
    }
}
