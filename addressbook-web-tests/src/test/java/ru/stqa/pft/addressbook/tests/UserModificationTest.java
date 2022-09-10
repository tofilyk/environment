package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModificationTest extends TestBase {


    @Test//(enabled = false)
    public void UserModificationTest() throws Exception {

        app.goTo().gotoHomePage();
        app.getContactHelper().ifNotUserCreateUser();
        List<UserData> before = app.getContactHelper().getUserList();
        app.getContactHelper().initUserModification(before.size()-1);
        UserData userData= new UserData(before.get(before.size()-1).getId(),"newFirstname", "newLastname", "newEmail",
                "newMobile", null);
        app.getContactHelper().fillUser(userData, false);
        app.getContactHelper().submitUserModification();
        app.getContactHelper().returnHomePage();
        List<UserData> after = app.getContactHelper().getUserList();
        System.out.println("ArrayList before = " + before.size());
        System.out.println("ArrayList after = " + after.size());
        Assert.assertEquals(before.size(),after.size());

       before.remove(before.size() - 1);
        before.add(userData);
        Comparator<? super UserData> byId = Comparator.comparingInt(UserData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }
}
