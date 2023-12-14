package com.example.A.services;

import com.example.A.models.Widget;

import java.util.Random;

public class WidgetCreator {

    private static final Random random = new Random();

    public static Widget createWidgets() {
        Widget widgetRan = new Widget();

        widgetRan.setNum(random.nextInt(11));
        widgetRan.setFruit(getRandomFruit());
        widgetRan.setLetter(getRandomLowerCaseLetter());

        return widgetRan;
    }

    private static String getRandomFruit() {
        String[] fruits = {"Apple", "Banana", "Orange", "Grapes", "Strawberry", "Kiwi", "Mango"};
        return fruits[random.nextInt(fruits.length)];
    }

    private static String getRandomLowerCaseLetter() {
        return String.valueOf((char) (random.nextInt(26) + 'a'));
    }
}
