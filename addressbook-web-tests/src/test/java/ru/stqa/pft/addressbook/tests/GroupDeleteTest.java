package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeleteTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        app.Group().ifGroupsEmptyGoCreateGroup();
    }

    @Test//(enabled = false)
    public void testGroupDelete() throws Exception {

        Set<GroupData> before = app.Group().all();
        GroupData deletedGroup=before.iterator().next();
        app.Group().delete(deletedGroup);
        Set<GroupData> after = app.Group().all();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);


    }


}

