package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.RandomData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class CreateMultipleUsers extends TestBase {


    @Test//(enabled = false)
    public void CreateMultipleUsers() throws Exception {


        app.Group().ifGroupsEmptyGoCreateGroup();
        app.goTo().HomePage();
        List<UserData> before = app.contact().list();

        int amountOfIterations = 120;
        for (int i = 0; i < amountOfIterations; i++) {

            RandomData randomData = new RandomData();

            UserData userData = new UserData(randomData.randomFirstname(), randomData.randomLastname(), randomData.randomEmail(), randomData.randomMobile(), null);
            app.contactHelper.create(userData);
        }

        List<UserData> after = app.contact().list();
        System.out.println("ArrayList before = " + before.size());
        System.out.println("ArrayList after = " + after.size());
        Assert.assertEquals(after.size(), before.size() + amountOfIterations);
    }

}