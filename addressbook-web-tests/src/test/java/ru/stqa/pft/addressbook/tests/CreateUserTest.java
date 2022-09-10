package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class CreateUserTest extends TestBase {


    @Test//(enabled = false)
    public void testCreateUser() throws Exception {
        app.Group().ifGroupsEmptyGoCreateGroup();
        app.goTo().gotoHomePage();
        List<UserData> before = app.getContactHelper().getUserList();
        UserData userData = new UserData("Edward", "McBride", "edward@gmail.com", "+79289996655", null);
        app.contactHelper.createUser(userData);
        List<UserData> after = app.getContactHelper().getUserList();
        System.out.println("ArrayList before = " + before.size());
        System.out.println("ArrayList after = " + after.size());
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(userData);
        Comparator<? super UserData> byId = Comparator.comparingInt(UserData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }

}






