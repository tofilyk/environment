package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUser extends TestBase{
    ChromeDriver wdd;

    @Test
    public void testCreateUser() throws Exception {

       app.getGroupHelper().initCreateUser();
        app.getGroupHelper().fillUser(new UserData("Scarlet", "Ivanov", "vanya"));
        app.getGroupHelper().saveUser();
        app.getGroupHelper().returnHomePage();

    }







    }




