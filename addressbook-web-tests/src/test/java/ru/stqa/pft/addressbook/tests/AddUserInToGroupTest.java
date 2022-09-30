package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddUserInToGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions1() {
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.Group().create(new GroupData().withName("test1"));
        }
    }

    @BeforeMethod
    public void ensurePreconditions2() {
        if (app.db().users().size() == 0) {
            app.goTo().HomePage();
            app.user().create(new UserData().withFirstname("Edward").withLastname("Parker").withAddress("SPb")
                    .withEmail("test@ya.ru").withHomePhone("111")
                    .withMobilePhone("222").withWorkPhone("333"));
        }
    }


    @Test
    public void AddUserInToGroup() throws Exception {
        Users before = app.db().users();
        UserData moveuser = before.iterator().next();
        app.user().addUserInToGroup(moveuser);
        assertThat(app.user().count(), equalTo(before.size()));
        Users after = app.db().users();
        assertThat(after, equalTo(before.withOut(moveuser).withAdded(moveuser)));
        System.out.println("7777777777777 " + app.db().users());



    }


}