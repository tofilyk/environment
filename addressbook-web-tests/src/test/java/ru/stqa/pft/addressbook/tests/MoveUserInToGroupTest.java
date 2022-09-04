package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class MoveUserInToGroupTest extends TestBase{

    @Test
    public void MoveUserInToGroupTest() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        List<UserData> before = app.getContactHelper().getUserList();
        app.getContactHelper().ifNotUserCreateUser();
        app.getContactHelper().selectUser(before.size() - 1);
        app.getContactHelper().AddClientsIntoFirstGroup();
        app.getNavigationHelper().gotoClientsPage();
        List<UserData> after = app.getContactHelper().getUserList();
        System.out.println("ArrayList before = " + before);
        System.out.println("ArrayList after = " + after);
        Assert.assertEquals(before.size()-1,after.size());


    }
}
