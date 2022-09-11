package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.List;


public class UserHelper extends HelperBase {

    NavigationHelper navigationHelper = new NavigationHelper(wd);
    // GroupHelper groupHelper = new GroupHelper(wd);

    public UserHelper(WebDriver wd) {
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
        type(By.name("home"), userData.getHomePhone());
        type(By.name("work"), userData.getWorkPhone());
        type(By.name("mobile"), userData.getMobilePhone());
        type(By.name("email"), userData.getEmail());
        type(By.name("address"), userData.getAddress());
        if (creation) {

            if (checkExistsFirstGroup()) new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);

        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void initUserModificationById(int id) {

        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void submitUserModification() {

        click(By.name("update"));
    }

    // public void selectUser(int index) { wd.findElements(By.name("selected[]")).get(index).click(); }

    public void selectUserById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initDeleteUser() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void returnHomePage() {
        click(By.linkText("home page"));
    }

    public void selectAllUsers() {
        click(By.id("MassCB"));
    }

    public void create(UserData user) {
        initCreateUser();
        fillUser(user, true);
        submitUserCreation();
        returnHomePage();
    }


    public void delete(UserData user) {
        selectUserById(user.getId());
        initDeleteUser();
        confirmAlertForDeleteUsers();
        navigationHelper.HomePage();

    }

    public void modify(UserData user) {
        initUserModificationById(user.getId());
        fillUser(user, false);
        submitUserModification();
        returnHomePage();
    }

    public void deleteAllUsers() {
        navigationHelper.HomePage();
        selectAllUsers();
        initDeleteUser();
        navigationHelper.confirmAlertForDeleteUsers();
        navigationHelper.HomePage();
    }

    // public boolean isThereAUser() { return isElementPresent(By.name("selected[]"));}

    public void ifNotUserCreateUser() {
        if (all().size() == 0) {
            create(new UserData().withFirstname("Edward").withLastname("Parker").withAddress("SPb").withEmail("test@ya.ru").withHomePhone("111")
                    .withMobilePhone("222").withWorkPhone("333").withGroup(null));
        }
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Users all() {
        Users users = new Users();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            String email=cells.get(4).getText();
            String address=cells.get(3).getText();
            String mobile=cells.get(5).getText();
            users.add(new UserData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address).withEmail(email)
                    .withAllPhones(allPhones).withMobilePhone(mobile).withAllEmails(allEmails));
            System.out.println(allPhones+allEmails);

        }
        return users;
    }

    public UserData infoFromEditForm(UserData user) {
        initUserModificationById(user.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new UserData().withId(user.getId()).withFirstname(firstname).withLastname(lastname)
                .withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3).
                withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);


    }

}


