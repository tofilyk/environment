package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class DeleteAllUsersTest extends TestBase {


    @Test//(enabled = false)
    public void testDeleteAllUsers() throws Exception {

        app.goTo().gotoHomePage();
        app.getContactHelper().ifNotUserCreateUser();
        List<UserData> before = app.getContactHelper().getUserList();
        app.getContactHelper().deleteAllUsers();
        List<UserData> after = app.getContactHelper().getUserList();
        System.out.println("ArrayList before = " + before);
        System.out.println("ArrayList after = " + after);
        Assert.assertEquals( before.size()-before.size(), after.size());

    }
}
