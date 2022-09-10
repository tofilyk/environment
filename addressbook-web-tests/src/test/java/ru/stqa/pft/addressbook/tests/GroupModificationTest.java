package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        app.Group().ifGroupsEmptyGoCreateGroup();
    }

    @Test//(enabled = false)

    public void testGroupModification() {

        List<GroupData> before = app.Group().list();
        int index = before.size() - 1;
        GroupData group = new GroupData().withId(before.get(index).getId()).withName("Group1").withHeader("header1").withFooter("footer1");
        app.Group().modify(index, group);
        List<GroupData> after = app.Group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);


    }


}
