package com.jft.addressbook.tests;

import com.jft.addressbook.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTests extends BaseTest {

  @Test
  public void testContactCreation() {
    app.gotoContactCreationPage();
    app.fillContactForm(new ContactData("John", "Doe", "89119999999", "JohnnyDoe@mail.com"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}
