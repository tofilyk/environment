package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class CreateGroup extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("Group666", "header555", "footer555"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }


}
