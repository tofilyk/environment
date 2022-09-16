package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.AppclicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    protected static final AppclicationManager app = new AppclicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }

    @BeforeMethod
    public void  logTestStart(Method m,Object[] p){
        logger.info("Start test CreateGroupTest"+m.getName()+"with patametrs"+ Arrays.asList(p));


    }
    @AfterMethod(alwaysRun = true)
    public  void logTestStop(Method m){
        logger.info("Stop test CreateGroupTest"+m.getName());

    }

}
