package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserPhoneTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        app.user().ifNotUserCreateUser();
    }
    @Test

    public void testUserPhones() {

        UserData user = app.user().all().iterator().next();
        UserData userInfoFromEditForm = app.user().infoFromEditForm(user);
        assertThat(user.getAllPhones(), equalTo(mergePhones(userInfoFromEditForm)));
    }

    private String mergePhones(UserData userData) {
        return  Arrays.asList(userData.getHomePhone(),userData.getMobilePhone(),userData.getWorkPhone())
                .stream().filter((s)->!s.equals(""))
                .map(UserPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
