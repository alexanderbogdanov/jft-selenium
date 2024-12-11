package com.addressbook.tests;


import org.testng.annotations.*;

public class GroupCreationTests extends BaseTest {


    @Test
    public void testGroupCreation() {
        gotoGroupsPage();
        initGroupCreation();
        fillGroupForm(new GroupData("group1", "group1_header", "group1_footer"));
        submitGroupCreation();
        returnToGroupsPage();
    }


}
