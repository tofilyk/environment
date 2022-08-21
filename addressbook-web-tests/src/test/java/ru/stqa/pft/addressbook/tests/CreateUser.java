package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUser extends TestBase {


    @Test
    public void testCreateUser1() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getContactHelper().initCreateUser();
        app.getContactHelper().fillUser(new UserData("Andrey", "Petrov", "Standertoil", "+9112224455"));
        app.getContactHelper().submitUserCreation();
        app.getContactHelper().returnHomePage();


    }
    @Test
    public void testCreateUser2() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getContactHelper().initCreateUser();
        app.getContactHelper().fillUser(new UserData("Dima", "Dmitriev", "Elisoft", "+9112224455"));
        app.getContactHelper().submitUserCreation();
        app.getContactHelper().returnHomePage();


    }
    @Test
    public void testCreateUser3() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getContactHelper().initCreateUser();
        app.getContactHelper().fillUser(new UserData("Nikolay", "Nikolaev", "Grad", "+9184445523"));
        app.getContactHelper().submitUserCreation();
        app.getContactHelper().returnHomePage();


    }

}




