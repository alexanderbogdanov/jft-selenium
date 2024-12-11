package com.jft.addressbook.appmanager;

import com.jft.addressbook.model.ContactData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
  private WebDriver wd;
  private GroupHelper groupHelper;

  public void init() {
    WebDriverManager.chromedriver().setup();
    wd = new ChromeDriver();
    wd.get("http://localhost/addressbook/index.php");
    groupHelper = new GroupHelper(wd);

    login("admin", "secret");
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  //    group creation
  public void gotoGroupsPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  //    contact creation
  public void gotoContactCreationPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void fillContactForm(ContactData contactData) {
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

  public void submitContactCreation() {
    groupHelper.submitGroupCreation();
  }

  public void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  //    contact deletion
  public void deleteContact() {
    wd.findElement(By.cssSelector("input[value='Delete']")).click();
  }

  public void selectContact() {
    groupHelper.selectGroup();
  }

  //    helper methods
  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
