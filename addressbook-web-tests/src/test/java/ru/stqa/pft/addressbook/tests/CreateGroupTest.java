package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class CreateGroupTest extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("Group778", null, null));

    }


}
