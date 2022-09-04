package ru.stqa.pft.addressbook.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomData {
    Random rand = new Random();

    List<String> firstname = Arrays.asList("Larry", "Nick", "David", "Max", "Robert","James","Timothy","Edward","Samuel");
    String randomFirstname = firstname.get(rand.nextInt(firstname.size()));

    public String randomFirstname() {
        return randomFirstname;
    }


    List<String> lastname = Arrays.asList("McBride", "Jones", "Dixon", "Houston", "Ross","Edwards","Graves","Parker","Thompson");
    String randLastname = lastname.get(rand.nextInt(lastname.size()));

    public String randomLastname() {
        return randLastname;
    }

    List<String> mobile = Arrays.asList("+79225554488", "+79652154783", "+79114785526", "+79263254815");
    String randMobile = mobile.get(rand.nextInt(mobile.size()));

    public String randomMobile() {
        return randMobile;
    }
}
