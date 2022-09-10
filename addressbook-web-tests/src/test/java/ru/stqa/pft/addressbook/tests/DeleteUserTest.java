package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

public class DeleteUserTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        app.contact().ifNotUserCreateUser();
    }

    @Test//(enabled = false)
    public void testUserDelete() throws Exception {

        Users before = app.contact().all();
        UserData deletedUser = before.iterator().next();
        app.contact().delete(deletedUser);
        Users after = app.contact().all();
        Assert.assertEquals(after.size(), after.size());
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withOut(deletedUser)));


    }


}
