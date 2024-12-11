package com.jft.addressbook.tests;

import com.jft.addressbook.model.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() {
    app.gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("group2", "group1_header", "group1_footer"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
}
