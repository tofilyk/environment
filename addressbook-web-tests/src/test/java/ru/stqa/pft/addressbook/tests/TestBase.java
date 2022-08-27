package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addressbook.appmanager.AppclicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final AppclicationManager app = new AppclicationManager(BrowserType.CHROME);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }

}
