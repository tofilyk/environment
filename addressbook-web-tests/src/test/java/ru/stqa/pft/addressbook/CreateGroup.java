package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class CreateGroup extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Group555", "header555", "footer555"));
        submitGroupCreation();
        returnToGroupPage();
    }


}
