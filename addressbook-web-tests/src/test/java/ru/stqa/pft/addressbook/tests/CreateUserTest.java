package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import ru.stqa.pft.addressbook.model.Users;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUserTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.Group().ifGroupsEmptyGoCreateGroup();
        app.goTo().HomePage();
    }

    @Test//(enabled = false)
    public void testCreateUser() throws Exception {
        File photo=new File("src/test/resources/stru.png");
        Users before = app.user().all();
        UserData user = new UserData().withFirstname("Kostya").withLastname("Jons").withAddress("SPB")
                .withEmail("test@ya.ru").withMobilePhone("+79112223355").withPhoto(photo).withGroup(null);
        app.user().create(user);
        assertThat(app.user().count(), equalTo(before.size() + 1));
        Users after = app.user().all();
        assertThat(after, equalTo(
                before.withAdded(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

    @Test(enabled = false)
    public void testCurrentDir() {

        File currentDir = new File(".");
        File photo=new File("src/test/resources/stru.png");
        System.out.println(currentDir.getAbsolutePath());
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}






