package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class DeleteAllUsersTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        app.contact().ifNotUserCreateUser();
    }

    @Test//(enabled = false)
    public void testDeleteAllUsers() throws Exception {

        List<UserData> before = app.contact().list();
        app.contact().deleteAllUsers();
        List<UserData> after = app.contact().list();
        Assert.assertEquals(before.size() - before.size(), after.size());

    }
}
