package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeleteTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().GroupPage();
        app.Group().ifGroupsEmptyGoCreateGroup();
    }

    @Test//(enabled = false)
    public void testGroupDelete() throws Exception {

        Groups before = app.Group().all();
        GroupData deletedGroup = before.iterator().next();
        app.Group().delete(deletedGroup);
        Groups after = app.Group().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.withOut(deletedGroup)));


    }


}

