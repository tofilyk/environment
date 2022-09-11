package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserPhoneTests extends TestBase {

    @Test

    public void testUserPhones() {
        app.goTo().GroupPage();

        UserData user = app.contact().all().iterator().next();
        UserData userInfoFromEditForm = app.contact().infoFromEditForm(user);

        assertThat(user.getHomePhone(), equalTo(userInfoFromEditForm.getHomePhone()));
        assertThat(user.getMobilePhone(), equalTo(userInfoFromEditForm.getMobilePhone()));
        assertThat(user.getWorkPhone(), equalTo(userInfoFromEditForm.getWorkPhone()));

    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
