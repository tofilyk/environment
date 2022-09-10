package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class CreateGroupTest extends TestBase {


    @Test//(enabled = false)
    public void testCreateGroup() throws Exception {
        app.goTo().GroupPage();
        Set<GroupData> before = app.Group().all();
        GroupData group = new GroupData().withName("Group1");
        app.Group().create(group);
        Set<GroupData> after = app.Group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);


    }

}
