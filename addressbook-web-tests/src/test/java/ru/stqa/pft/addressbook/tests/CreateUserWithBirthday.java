package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class CreateUserWithBirthday extends TestBase {


    @Test
    // Чистим базу аккаунтов. Создаем аккаунт с датой рождения. Делаем переход на страницу Next birthdays
    // Переходим в карточку аккаунта и проверяем наличие кнопок print и modifiy
    public void CreateUserWithBirthday() throws Exception {

        app.getContactHelper().deleteAllUsers();
        app.contactHelper.initCreateUser();
        app.getContactHelper().fillUser(new UserData("Konstantin", "Ivanov", "Elisoft", "+79112223344", "Group777"), true);
        app.getContactHelper().setBirthday();
        app.getContactHelper().submitUserCreation();
        app.getNavigationHelper().gotoPageNextBirthdays();
        app.getContactHelper().iconUserDetails();
        app.contactHelper.checkElement(By.name("print"));
        app.contactHelper.checkElement(By.name("modifiy"));


    }

}

