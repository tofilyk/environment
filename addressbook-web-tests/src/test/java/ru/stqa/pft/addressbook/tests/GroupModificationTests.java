package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests  extends TestBase{

    @Test
public  void testGroupModification(){
        app.getNavigationHelper().gotoGroupPage();
            if (!app.getGroupHelper().isThereAGrpup()) {
                    app.getGroupHelper().createGroupMethod(new GroupData("Group777", null, null));
            }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("testEdit","testEdit1","testEdit3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();


}

}
