package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteAllUsers extends TestBase {


    @Test
    public void testDeleteAllUsers() throws Exception {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectAllUsers();
        app.getContactHelper().initDeleteUser();
        app.getNavigationHelper().isAlertPresent();
        app.getNavigationHelper().gotoHomePage();


    }
}
