package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.RandomData;

public class CreateMultipleGroups extends TestBase{

    @Test//(enabled = false)
    public void testCreateGroup() throws Exception {

        int amountOfIterations = 8;
        for (int i = 0; i < amountOfIterations; i++) {

            RandomData rd = new RandomData();
            app.goTo().GroupPage();
            GroupData group = new GroupData().withName("Group "+rd.randomNumber());
            app.Group().create(group);

        }

    }

}
