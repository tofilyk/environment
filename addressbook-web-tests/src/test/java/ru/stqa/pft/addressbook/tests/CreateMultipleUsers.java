package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.RandomData;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

public class CreateMultipleUsers extends TestBase {


    @Test//(enabled = false)
    public void CreateMultipleUsers() throws Exception {


        app.Group().ifGroupsEmptyGoCreateGroup();
        app.goTo().HomePage();
        Users before = app.contact().all();

        int amountOfIterations = 8;
        for (int i = 0; i < amountOfIterations; i++) {

            RandomData rd = new RandomData();

            UserData userData = new UserData().withFirstname(rd.randomFirstname()).withLastname(rd.randomLastname())
                    .withMobile(rd.randomMobile()).withEmail(rd.randomEmail()).withGroup(null);
            app.contactHelper.create(userData);
        }

        Users after = app.contact().all();
        System.out.println("ArrayList before = " + before.size());
        System.out.println("ArrayList after = " + after.size());
        Assert.assertEquals(after.size(), before.size() + amountOfIterations);
    }

}