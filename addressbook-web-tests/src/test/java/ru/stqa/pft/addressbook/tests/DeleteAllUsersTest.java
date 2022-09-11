package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Users;

public class DeleteAllUsersTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        app.user().ifNotUserCreateUser();
    }

    @Test//(enabled = false)
    public void testDeleteAllUsers() throws Exception {

        Users before = app.user().all();
        app.user().deleteAllUsers();
        Users after = app.user().all();
        Assert.assertEquals( after.size(),before.size() -1);

    }
}
