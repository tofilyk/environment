package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUserTest extends TestBase {


    @Test
    public void testCreateUser1() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getContactHelper().initCreateUser();
        app.getContactHelper().fillUser(new UserData("Andrey", "Petrov", "Standertoil", "+9112224455",
                "Group777"),true);
        app.getContactHelper().submitUserCreation();
        app.getContactHelper().returnHomePage();

    }

}




