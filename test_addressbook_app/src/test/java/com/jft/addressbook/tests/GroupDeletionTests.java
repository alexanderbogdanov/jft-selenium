package com.jft.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends BaseTest {

  @Test
  public void testGroupDeletion() {
    app.gotoGroupsPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupsPage();
  }
}
