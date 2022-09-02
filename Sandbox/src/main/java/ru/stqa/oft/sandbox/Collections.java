package ru.stqa.oft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {


    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};
        List<String> langues = Arrays.asList("Java", "C#", "Python", "PHP");


        for (String l : langues) {
            System.out.println("Я хочу выучить " + l);
        }

    }
}
