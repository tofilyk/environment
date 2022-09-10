package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.AppclicationManager;

public class TestBase {

    protected static final AppclicationManager app = new AppclicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();

    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();

    }

}
