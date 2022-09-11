package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteUserTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        app.user().ifNotUserCreateUser();
    }

    @Test//(enabled = false)
    public void testUserDelete() throws Exception {

        Users before = app.user().all();
        UserData deletedUser = before.iterator().next();
        app.user().delete(deletedUser);
        Users after = app.user().all();
        assertThat(app.user().count(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.withOut(deletedUser)));

    }
}
