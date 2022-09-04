package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.RandomData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class CreateMultipleUsers extends TestBase {


    @Test()
    public void CreateMultipleUsers() throws Exception {


        app.getGroupHelper().ifGroupsEmptyGoCreateGroup();
        app.getNavigationHelper().gotoHomePage();
        List<UserData> before = app.getContactHelper().getUserList();

        int amountOfIterations = 10;
        for (int i = 0; i < amountOfIterations; i++) {

            RandomData randomData = new RandomData();

            UserData userData = new UserData(randomData.randomFirstname(), randomData.randomLastname(), randomData.randomEmail(), randomData.randomMobile(), null);
            app.contactHelper.createUser(userData);
        }

        List<UserData> after = app.getContactHelper().getUserList();
        System.out.println("ArrayList before = " + before.size());
        System.out.println("ArrayList after = " + after.size());
        Assert.assertEquals(after.size(), before.size() + amountOfIterations);
    }

}