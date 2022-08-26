package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.UserData;


public class ContactHelper extends HelperBase {
    public WebDriver wd;


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initCreateUser() {
        click(By.linkText("add new"));
    }

    public void submitUserCreation() {
        click(By.name("submit"));
    }

    public void fillUser(UserData userData) {
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("middlename"), userData.getMiddlename());
        type(By.name("company"), userData.getCompany());
        type(By.name("mobile"), userData.getMobile());
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
}

