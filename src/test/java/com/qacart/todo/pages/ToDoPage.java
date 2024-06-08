package com.qacart.todo.pages;

import com.qacart.todo.utils.ConfigUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ToDoPage {

    @Getter
    private static final ToDoPage instance = new ToDoPage();

    private final By welcomeMessage = By.xpath("//*[@data-testid='welcome']");
    private final By noTodosMessage = By.xpath("//*[@data-testid='no-todos']");
    private final By todoItem = By.xpath("//div[@data-testid='todo-item']");
    private final By plusButton = By.xpath("//button//*[@data-testid='add']");
    private final By deleteButton = By.xpath("//button[@data-testid='delete']");

    public void load(WebDriver driver) {
        driver.get(ConfigUtils.getInstance().getBaseURL() + "/todo");
    }

    public boolean isWelcomeMessageDisplayed(WebDriver driver) {
        return driver.findElement(this.welcomeMessage).isDisplayed();
    }

    public void clickOnPlusButton(WebDriver driver) {
        driver.findElement(this.plusButton).click();
    }

    public String getToDoText(WebDriver driver) {
        return driver.findElement(this.todoItem).getText();
    }

    public void deleteToDo(WebDriver driver) {
        driver.findElement(this.deleteButton).click();
    }

    public boolean isNoToDosMessageDisplayed(WebDriver driver) {
        return driver.findElement(this.noTodosMessage).isDisplayed();
    }
}
