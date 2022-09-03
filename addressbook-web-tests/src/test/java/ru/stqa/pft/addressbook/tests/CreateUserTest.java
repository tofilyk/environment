package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class CreateUserTest extends TestBase {


    @Test
    public void testCreateUser() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        List<UserData> before = app.getContactHelper().getUserList();
        UserData userData = new UserData("Max", "Ivanov", "Track", "+79289996655", null);
        app.getGroupHelper().ifGroupsEmptyGoCreateGroup();
        app.contactHelper.createUser(userData);
        List<UserData> after = app.getContactHelper().getUserList();
        System.out.println("ArrayList before = " + before);
        System.out.println("ArrayList after = " + after);
        Assert.assertEquals(after.size(), before.size() + 1);

    }

}




