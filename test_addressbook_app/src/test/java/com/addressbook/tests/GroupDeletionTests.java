package com.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends BaseTest {

  @Test
  public void testGroupDeletion() {
    gotoGroupsPage();
    selectGroup();
    deleteGroup();
    returnToGroupsPage();
  }

}
