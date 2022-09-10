package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        app.contact().ifNotUserCreateUser();
    }

    @Test//(enabled = false)
    public void UserModificationTest() throws Exception {
        Users before = app.contact().all();
        UserData modifiedUser = before.iterator().next();
        UserData user = new UserData()
                .withId(modifiedUser.getId()).withFirstname("Max").withLastname("Bored").withGroup(null);
        app.contact().modify(user);
        assertThat(app.contact().count(), equalTo(before.size()));
        Users after = app.contact().all();
        assertThat(after, equalTo(before.withOut(modifiedUser).withAdded(user)));
    }
}
