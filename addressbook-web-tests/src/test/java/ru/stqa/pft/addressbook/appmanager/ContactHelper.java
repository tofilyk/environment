package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;


public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initCreateUser() {
        click(By.linkText("add new"));
    }

    public void submitUserCreation() {
        click(By.name("submit"));
    }

    public void fillUser(UserData userData, boolean creation) {
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("middlename"), userData.getMiddlename());
        type(By.name("company"), userData.getCompany());
        type(By.name("mobile"), userData.getMobile());

        if (creation) { // Если есть группа то выбрать группу, если нет -тест падает
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initUserModification() {

        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitUserModification() {
        click(By.name("update"));
    }

    public void selectUser() {
        click(By.name("selected[]"));
    }

    public void initDeleteUser() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void AddClientsIntoFirstGroup() {
        click(By.name("add"));
    }

    public void selectAllUsers() {
        click(By.id("MassCB"));
    }

    public void createUserMethod(UserData user, boolean b) {
        initCreateUser();
        fillUser(user, true);
        submitUserCreation();
        returnHomePage();
    }


    public boolean isThereAUser() {
        return isElementPresent(By.name("selected[]"));
    }

    public void IfNotUserCreateUser() {
        if (!isThereAUser()) { // если нет юзера - создать юзера
            createUserMethod(new UserData("Andrey", "Ivanov",
                    "Elisoft", "+79112223344", "Group777"), false);
        }
    }
}


