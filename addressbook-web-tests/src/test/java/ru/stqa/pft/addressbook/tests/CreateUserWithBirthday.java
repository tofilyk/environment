package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUserWithBirthday extends TestBase {
    WebDriver wd;

    @Test
    public void CreateUserWithBirthday() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        app.contactHelper.initCreateUser();
        app.getContactHelper().fillUser(new UserData("Konstantin", "Ivanov", "Elisoft", "+79112223344", "Group777"), true);
        app.getContactHelper().setBirthday();
        app.getContactHelper().submitUserCreation();
        app.getNavigationHelper().gotoPageNextBirthdays();




        }

    }

