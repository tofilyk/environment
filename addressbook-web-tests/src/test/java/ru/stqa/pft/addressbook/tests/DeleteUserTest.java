package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class DeleteUserTest extends TestBase {

    @Test//(enabled = false)
    public void testUserDelete() throws Exception {

        app.goTo().gotoHomePage();
        app.getContactHelper().ifNotUserCreateUser();
        List<UserData> before = app.getContactHelper().getUserList();
        app.getContactHelper().selectUser(before.size() - 1);
        app.getContactHelper().initDeleteUser();
        app.goTo().confirmAlertForDeleteUsers();
        app.goTo().gotoHomePage();
        List<UserData> after = app.getContactHelper().getUserList();
        System.out.println("ArrayList before = " + before.size());
        System.out.println("ArrayList after = " + after.size());
        Assert.assertEquals(before.size() - 1, after.size());

        before.remove(before.size() - 1);
        Comparator<? super UserData> byId = Comparator.comparingInt(UserData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
