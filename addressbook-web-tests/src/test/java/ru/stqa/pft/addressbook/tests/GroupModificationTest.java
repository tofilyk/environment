package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size()==0){
        app.goTo().GroupPage();
        app.Group().create(new GroupData().withName("test1"));
    }}

    @Test//(enabled = false)

    public void testGroupModification() {

        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("EditName").withHeader("EditHeader").withFooter("EditFooter");
        app.goTo().GroupPage();
        app.Group().modify(group);
        assertThat(app.Group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    }
}
