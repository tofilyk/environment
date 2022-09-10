package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        app.Group().ifGroupsEmptyGoCreateGroup();
    }

    @Test//(enabled = false)

    public void testGroupModification() {

        Groups before = app.Group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("EditName").withHeader("EditHeader").withFooter("EditFooter");
        app.Group().modify(group);
        Groups after = app.Group().all();
        Assert.assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));


    }


}
