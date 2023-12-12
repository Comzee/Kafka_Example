package com.example.A;


import java.util.Random;

public class WidgetCreator {


    public static Widget createWidgets() {
        Widget widgetRan = new Widget();
        Random random = new Random();

        widgetRan.setNum(random.nextInt(11)); // Generates a random number between 0 and 10
        widgetRan.setFruit(getRandomFruit());
        widgetRan.setLetter(getRandomLowerCaseLetter());

        return widgetRan;
    }

    private static String getRandomFruit() {
        String[] fruits = {"Apple", "Banana", "Orange", "Grapes", "Strawberry", "Kiwi", "Mango"};
        Random random = new Random();
        return fruits[random.nextInt(fruits.length)];
    }

    private static char getRandomLowerCaseLetter() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a'); // Generates a random lowercase letter (a-z)
    }
}
