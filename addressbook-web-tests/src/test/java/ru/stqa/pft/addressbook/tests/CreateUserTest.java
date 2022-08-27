package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUserTest extends TestBase {


    @Test
    public void testCreateUser() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.contactHelper.createUserMethod(new UserData("Andrey", "Ivanov",
                "Elisoft", "+79112223344", "Group777"), false);

    }

}




