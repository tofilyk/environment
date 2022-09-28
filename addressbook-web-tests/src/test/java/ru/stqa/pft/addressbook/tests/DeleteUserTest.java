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
        if (app.db().users().size() == 0) {
            app.goTo().HomePage();
            app.user().create(new UserData().withFirstname("Edward").withLastname("Parker").withAddress("SPb")
                    .withEmail("test@ya.ru").withHomePhone("111")
                    .withMobilePhone("222").withWorkPhone("333").withGroup(null));
        }
    }
    @Test//(enabled = false)
    public void testUserDelete() throws Exception {

        Users before = app.db().users();
        UserData deletedUser = before.iterator().next();
        app.user().delete(deletedUser);
        Users after = app.db().users();
        assertThat(app.user().count(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.withOut(deletedUser)));

    }
}
