package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserModificationTest extends TestBase {


    @Test
    public void UserModificationTest() throws Exception {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().ifNotUserCreateUser();
        List<UserData> before = app.getContactHelper().getUserList();
        app.getContactHelper().initUserModification();
        app.getContactHelper().fillUser(new UserData("Edit", "Edit2", "Edit3",
                "Edit4", null), false);
        app.getContactHelper().submitUserModification();
        app.getContactHelper().returnHomePage();
        List<UserData> after = app.getContactHelper().getUserList();
        System.out.println("ArrayList before = " + before);
        System.out.println("ArrayList after = " + after);
        Assert.assertEquals(before.size(),after.size());

    }


}
