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

    public void fillUser(UserData userData) {
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("middlename"), userData.getMiddlename());
        type(By.name("company"), userData.getCompany());
        type(By.name("mobile"), userData.getMobile());
    }

    public void saveUser() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }


}
