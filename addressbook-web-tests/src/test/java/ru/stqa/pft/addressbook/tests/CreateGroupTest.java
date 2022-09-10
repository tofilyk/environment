package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class CreateGroupTest extends TestBase {


    @Test//(enabled = false)
    public void testCreateGroup() throws Exception {
        app.goTo().GroupPage();
        List<GroupData> before = app.Group().list();
        GroupData group = new GroupData().withName("Group1");
        app.Group().create(group);
        List<GroupData> after = app.Group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }

}
