package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;

public class AddUserInToGroupTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().users().size() == 0) {
            app.goTo().HomePage();
            app.user().create(new UserData().withFirstname("Edward").withLastname("Parker").withAddress("SPb")
                    .withEmail("test@ya.ru").withHomePhone("111")
                    .withMobilePhone("222").withWorkPhone("333"));
        }
    }

    @Test//(enabled = false)
    public void AddUserInToGroup() throws Exception {

        Users before = app.db().users();
        UserData moveuser = before.iterator().next();
        app.user().addUserInToGroup(moveuser);
        MatcherAssert.assertThat(app.user().count(), equalTo(before.size()));
        Users after = app.db().users();
        MatcherAssert.assertThat(after, equalTo(before.withOut(moveuser).withAdded(moveuser)));

    }
}
