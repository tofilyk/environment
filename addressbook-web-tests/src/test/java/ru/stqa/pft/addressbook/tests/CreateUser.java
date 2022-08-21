package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUser extends TestBase {
    ChromeDriver wd;

    @Test
    public void testCreateUser() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getContactHelper().initCreateUser();
        app.getContactHelper().fillUser(new UserData("Dima2", "Petrov", "Elisoft", "9112224455"));
        app.getContactHelper().saveUser();
        app.getContactHelper().returnHomePage();


    }


}




