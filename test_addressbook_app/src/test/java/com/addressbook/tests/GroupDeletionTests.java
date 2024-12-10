package com.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupDeletionTests extends BaseTest {
  @BeforeMethod
  public void loginToApp() {
    wd.get("http://localhost/addressbook/index.php");
    login("admin", "secret");
  }

  @Test
  public void testGroupDeletion() {
    gotoGroupsPage();
    selectGroup();
    deleteGroup();
    returnToGroupsPage();
  }

  private void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  private void deleteGroup() {
    wd.findElement(By.name("delete")).click();
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  private void gotoGroupsPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  private void returnToGroupsPage() {
    wd.findElement(By.linkText("group page")).click();
  }
}
