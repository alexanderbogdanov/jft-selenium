package com.jft.addressbook.tests;

import com.jft.addressbook.model.GroupData;
import org.testng.annotations.*;

public class GroupCreationTests extends BaseTest {

  @Test
  public void testGroupCreation() {
    app.gotoGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("group2", "group1_header", "group1_footer"));
    app.submitGroupCreation();
    app.returnToGroupsPage();
  }
}
