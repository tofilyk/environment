package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class MoveUserInToGroupTest extends TestBase{

    @Test
    public void MoveUserInToGroupTest() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().ifNotUserCreateUser();
        app.getContactHelper().selectUser();
        app.getContactHelper().AddClientsIntoFirstGroup();
        app.getNavigationHelper().gotoClientsPage();


    }
}
