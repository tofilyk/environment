package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class CreateGroup extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroupMethod(new GroupData("Group777", null, null));

    }


}
