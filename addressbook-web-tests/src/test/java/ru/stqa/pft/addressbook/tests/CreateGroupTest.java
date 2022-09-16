package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGroupTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validGroups")
    public void testCreateGroup(GroupData group) throws Exception {
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
