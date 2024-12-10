package com.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class ContactCreationTests extends BaseTest {
  @BeforeMethod
  public void loginToApp() {
    wd.get("http://localhost/addressbook/index.php");
    login("admin", "secret");
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

  @Test
  public void testContactCreation() {
    gotoContactCreationPage();
    fillContactForm(new ContactData("John", "Doe", "89119999999", "JohnnyDoe@mail.com"));
    submitContactCreation();
    returnToHomePage();
  }

    private void returnToHomePage() {
      wd.findElement(By.linkText("home page")).click();
    }

    private void submitContactCreation() {
      wd.findElement(By.name("submit")).click();
    }

    private void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  private void gotoContactCreationPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}