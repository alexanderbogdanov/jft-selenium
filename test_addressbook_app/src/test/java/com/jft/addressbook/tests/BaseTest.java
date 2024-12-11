package com.jft.addressbook.tests;

import com.jft.addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }
}
