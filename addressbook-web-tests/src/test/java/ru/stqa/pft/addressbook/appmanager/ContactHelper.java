package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

    NavigationHelper navigationHelper = new NavigationHelper(wd);
    GroupHelper groupHelper = new GroupHelper(wd);

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initCreateUser() {
        click(By.linkText("add new"));
    }

    public void submitUserCreation() {
        click(By.name("submit"));
    }


    public boolean checkExistsFirstGroup() {
        try {
            new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void fillUser(UserData userData, boolean creation) {
        type(By.name("firstname"), userData.getFirstname());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("company"), userData.getCompany());
        type(By.name("mobile"), userData.getMobile());

        if (creation) {

            if (checkExistsFirstGroup()) new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);

        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void initUserModification() {

        click(By.xpath("//img[@alt='Edit']"));
    }

    public void goToUserProfile() {


        click(By.xpath("//img[@alt='Details']"));
    }

    public void submitUserModification() {

        click(By.name("update"));
    }

    public void selectUser(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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

    public void createUser(UserData user) {
        initCreateUser();
        fillUser(user, true);
        submitUserCreation();
        returnHomePage();
    }

    public void deleteAllUsers() {
        navigationHelper.gotoHomePage();
        selectAllUsers();
        initDeleteUser();
        navigationHelper.confirmAlertForDeleteUsers();
        navigationHelper.gotoHomePage();
    }

    public void setBirthday() {

        click(By.name("bday"));
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText("12");
        click(By.name("bmonth"));
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("February");
        click(By.name("byear"));
        wd.findElement(By.name("byear")).sendKeys("2001");
    }

    public boolean isThereAUser() {
        return isElementPresent(By.name("selected[]"));
    }


    public void ifNotUserCreateUser() {
        if (!isThereAUser()) { // если нет юзера - создать юзера
            createUser(new UserData("Andrey", "Ivanov",
                    "Elisoft", "+79112223344", null));
        }
    }

    public int getUserCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<UserData> getUserList() {
        List<UserData> users = new ArrayList<UserData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            //System.out.println("fistname="+ cells.get(1).getText()+ ",lastname="+ cells.get(2).getText()+",mobile="+cells.get(5).getText());
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            UserData user = new UserData(id, cells.get(2).getText(), cells.get(1).getText(), null, null, null);
            users.add(user);
        }
        return users;
    }
}


