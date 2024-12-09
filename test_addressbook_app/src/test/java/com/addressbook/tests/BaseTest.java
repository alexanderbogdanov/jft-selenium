package com.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver wd;

    @BeforeClass
    public void setupClass() {
        // Set up WebDriver binary once for the entire test suite
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        // Create a new WebDriver instance for each test
        wd = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        // Quit WebDriver after each test
        if (wd != null) {
            wd.quit();
        }
    }
}
