package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase {


    @Test
    public void testGroupDelete() throws Exception {

        app.getNavigationHelper().gotoGroupPage();
        if (!app.getGroupHelper().isThereAGrpup()) {
            app.getGroupHelper().createGroupMethod(new GroupData("Group777", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }


}

