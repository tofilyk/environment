package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        app.contact().ifNotUserCreateUser();
    }

    @Test//(enabled = false)
    public void UserModificationTest() throws Exception {


        List<UserData> before = app.contact().list();
        int index = before.size() - 1;
        UserData userData = new UserData(before.get(before.size() - 1).getId(), "newFirstname", "newLastname", "newEmail",
                "newMobile", null);
        app.contact().modify(index, userData);
        List<UserData> after = app.contact().list();
        Assert.assertEquals(before.size(), after.size());


        before.remove(index);
        before.add(userData);
        Comparator<? super UserData> byId = Comparator.comparingInt(UserData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }


}
