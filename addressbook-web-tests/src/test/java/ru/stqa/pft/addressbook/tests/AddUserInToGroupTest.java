package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddUserInToGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions1() {
        if (app.db().groups().size() == 0) {
            app.goTo().GroupPage();
            app.Group().create(new GroupData().withName("test1"));
        }
    }

    @BeforeMethod
    public void ensurePreconditions2() {
        if (app.db().users().size() == 0) {
            app.goTo().HomePage();
            app.user().create(new UserData().withFirstname("Edward").withLastname("Parker").withAddress("SPb")
                    .withEmail("test@ya.ru").withHomePhone("111")
                    .withMobilePhone("222").withWorkPhone("333"));
        }
    }


    @Test//(enabled = false)
    public void AddUserInToGroup() throws Exception {
        Users before = app.db().users();
        UserData moveuser = before.iterator().next();
        app.user().addUserInToGroup(moveuser);
        assertThat(app.user().count(), equalTo(before.size()));
        Users after = app.db().users();
        assertThat(after, equalTo(before.withOut(moveuser).withAdded(moveuser)));


    }

    @Test
    public void groups() {
        List<WebElement> elements = app.wd.findElements(By.name("to_group"));
        String lastname =elements.get(0).getText();
        String eleString = String.valueOf(app.wd.findElement(By.name("group")).getSize());




        System.out.println("lastname " + lastname);
        System.out.println("eleString " + eleString);


    }


}