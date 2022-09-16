package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new GroupData().withName("name1").withFooter("footer1").withHeader("header1")});
        list.add(new Object[]{new GroupData().withName("name2").withFooter("footer2").withHeader("header2")});
        list.add(new Object[]{new GroupData().withName("name3").withFooter("footer3").withHeader("header3")});
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testCreateGroup(GroupData group ) throws Exception {
       // GroupData group = new GroupData().withName(name).withFooter(footer).withHeader(header);
        app.goTo().GroupPage();
        Groups before = app.Group().all();
        app.Group().create(group);
        assertThat(app.Group().count(), equalTo(before.size() + 1));
        Groups after = app.Group().all();
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testCreateBadGroup() throws Exception {
        app.goTo().GroupPage();
        Groups before = app.Group().all();
        GroupData group = new GroupData().withName("Group1'");
        app.Group().create(group);
        assertThat(app.Group().count(), equalTo(before.size()));
        Groups after = app.Group().all();
        assertThat(after, equalTo(before));
    }
}
