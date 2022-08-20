package tests;

import org.testng.annotations.Test;
import model.GroupData;

public class CreateGroup extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("Group555", "header555", "footer555"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }


}
