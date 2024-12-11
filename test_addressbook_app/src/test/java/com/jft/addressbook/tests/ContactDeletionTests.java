package com.jft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends BaseTest {

  @Test
  public void testContactDeletion() {
    app.selectContact();
    app.deleteContact();
  }
}
