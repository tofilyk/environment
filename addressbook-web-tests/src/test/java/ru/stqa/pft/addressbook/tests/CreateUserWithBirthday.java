package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUserWithBirthday extends TestBase {

  @Test
  public void testCreateUser() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.contactHelper.initCreateUser();
    app.getContactHelper().fillUser(new UserData("Konstantin", "Ivanov","Elisoft", "+79112223344", "Group777"), true);
    app.getContactHelper().setBirthday();
    app.getContactHelper().submitUserCreation();
    app.getContactHelper().returnHomePage();

  }

}