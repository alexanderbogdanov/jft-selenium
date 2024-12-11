package com.jft.addressbook.appmanager;

import com.jft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {

  private final WebDriver wd;

  public GroupHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void returnToGroupsPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  //    group deletion
  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }

  public void deleteGroup() {
    wd.findElement(By.name("delete")).click();
  }
}
