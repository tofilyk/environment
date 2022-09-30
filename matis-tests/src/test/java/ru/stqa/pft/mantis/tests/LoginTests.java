package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws Exception {
        HttpSession session = app.newSession();
       session.login("administrator", "root");

    }
}
