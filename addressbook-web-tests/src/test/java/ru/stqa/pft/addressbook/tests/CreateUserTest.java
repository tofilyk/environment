package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class CreateUserTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.Group().ifGroupsEmptyGoCreateGroup();
        app.goTo().HomePage();
    }

    @Test//(enabled = false)
    public void testCreateUser() throws Exception {

        List<UserData> before = app.contact().list();
        UserData userData = new UserData().withFirstname("Kostya").withGroup(null);
        app.contactHelper.create(userData);
        List<UserData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(userData);
        Comparator<? super UserData> byId = Comparator.comparingInt(UserData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }

}






