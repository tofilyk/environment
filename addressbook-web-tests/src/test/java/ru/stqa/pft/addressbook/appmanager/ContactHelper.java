package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class ContactHelper extends HelperBase {
    public ChromeDriver wd;


    public ContactHelper(ChromeDriver wd) {
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
        click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
    }

    public void submitUserModification() {
        click(By.name("update"));
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }


}
