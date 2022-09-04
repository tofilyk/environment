package ru.stqa.oft.sandbox;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Easy {



    public static void main(String[] args) {
        Random rand = new Random();

        List<String> firstname = Arrays.asList("Larry", "Nick", "David", "Max","Robert");
        String randomFirstname= firstname.get(rand.nextInt(firstname.size()));

        List<String> lastname = Arrays.asList("McBride", "Jones", "Dixon", "Houston","Ross");
        String randLastname= lastname.get(rand.nextInt(lastname.size()));

        List<String> mobile = Arrays.asList("+79225554488", "+79652154783", "+79114785526", "+79263254815");
        String randMobile= mobile.get(rand.nextInt(mobile.size()));

        System.out.println("Random number: " + randLastname);
    }

}

