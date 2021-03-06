package addressbook.tests;

import addressbook.module.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test1", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
        group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
}
