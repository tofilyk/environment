package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUser extends TestBase {
    ChromeDriver wd;

    @Test
    public void testCreateUser() throws Exception {

        app.getGroupHelper().initCreateUser();
        app.getGroupHelper().fillUser(new UserData("Dima","Petrov","Elisoft","9112224455"));
        app.getGroupHelper().saveUser();
        app.getGroupHelper().returnHomePage();

    }


}




