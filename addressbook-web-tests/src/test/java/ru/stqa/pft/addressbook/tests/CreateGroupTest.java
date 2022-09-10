package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends TestBase {


    @Test//(enabled = false)
    public void testCreateGroup() throws Exception {
        app.goTo().GroupPage();
        Groups before = app.Group().all();
        GroupData group = new GroupData().withName("Group1");
        app.Group().create(group);
        Groups after = app.Group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));



    }

}
