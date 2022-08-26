package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTests extends TestBase {


    @Test
    public void testCreateUser() throws Exception {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initUserModification();
        app.getContactHelper().fillUser(new UserData("Edit", "Edit2", "Edit3", "Edit4",null),false);
        app.getContactHelper().submitUserModification();
        app.getContactHelper().returnHomePage();

    }
}
