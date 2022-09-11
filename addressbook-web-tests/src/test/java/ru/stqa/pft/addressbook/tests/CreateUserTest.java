package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.Group().ifGroupsEmptyGoCreateGroup();
        app.goTo().HomePage();
    }

    @Test//(enabled = false)
    public void testCreateUser() throws Exception {

        Users before = app.contact().all();
        UserData user = new UserData().withFirstname("Kostya").withLastname("Jons").withHomePhone("111")
                .withMobilePhone("222").withWorkPhone("333").withGroup(null);
        app.contact().create(user);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Users after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}






