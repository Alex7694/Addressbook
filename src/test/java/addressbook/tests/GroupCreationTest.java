package addressbook.tests;

import addressbook.module.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("test1", null, "test3"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before+1);
    }
}
