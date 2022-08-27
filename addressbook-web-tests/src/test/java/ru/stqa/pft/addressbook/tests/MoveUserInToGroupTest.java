package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class MoveUserInToGroupTest extends TestBase{

    @Test
    public void MoveUserInToGroupTest() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAUser()) { // если нет юзера - создать юзера
            app.getContactHelper().createUserMethod(new UserData("Andrey", "Ivanov",
                    "Elisoft", "+79112223344","Group777"),false);
        }
        app.getContactHelper().selectUser();
        app.getContactHelper().AddClientsIntoFirstGroup();
        app.getNavigationHelper().gotoClientsPage();


    }
}
