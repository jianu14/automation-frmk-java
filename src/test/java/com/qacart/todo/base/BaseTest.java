package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        WebDriver driver = new DriverFactory().initializeDriver();
        this.driver.set(driver);
    }

    @AfterMethod
    public void tearDown() {
        this.driver.get().quit();
    }
}
