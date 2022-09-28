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
        if (app.db().groups().size()==0){
            app.goTo().GroupPage();
            app.Group().create(new GroupData().withName("test1"));
        }}

    @Test//(enabled = false)
    public void testGroupDelete() throws Exception {

        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.Group().delete(deletedGroup);
        assertThat(app.Group().count(), equalTo(before.size() - 1));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(deletedGroup)));
    }
}

