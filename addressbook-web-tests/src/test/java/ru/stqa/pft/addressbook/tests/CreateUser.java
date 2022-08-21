package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUser extends TestBase {


    @Test
    public void testCreateUser() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getContactHelper().initCreateUser();
        app.getContactHelper().fillUser(new UserData("Dima89", "Petrov", "Elisoft", "9112224455"));
        app.getContactHelper().submitUserCreation();
        app.getContactHelper().returnHomePage();


    }


}




