package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.qacart.todo.factory.DriverFactory.initializeDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        this.driver = initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }
}
