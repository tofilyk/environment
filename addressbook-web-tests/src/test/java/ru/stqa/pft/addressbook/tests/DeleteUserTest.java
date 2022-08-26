package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteUserTest extends TestBase {

    @Test
    public void testUserDelete() throws Exception {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectUser();
        app.getContactHelper().initDeleteUser();
        app.getNavigationHelper().isAlertPresent();
        app.getNavigationHelper().gotoHomePage();


    }
}
