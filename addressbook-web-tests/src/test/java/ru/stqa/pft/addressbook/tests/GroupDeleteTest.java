package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        assertThat(app.Group().count(), equalTo(before.size() - 1));
        Groups after = app.Group().all();
        assertThat(after, equalTo(before.withOut(deletedGroup)));
    }
}

