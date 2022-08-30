package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteAllUsersTest extends TestBase {


    @Test
    public void testDeleteAllUsers() throws Exception {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().ifNotUserCreateUser();
        app.getContactHelper().deleteAllUsers();

    }
}
