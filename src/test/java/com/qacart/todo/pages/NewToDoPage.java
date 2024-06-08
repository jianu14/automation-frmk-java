package com.qacart.todo.pages;

import com.qacart.todo.apis.ToDoApi;
import com.qacart.todo.models.ToDo;
import com.qacart.todo.models.User;
import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewToDoPage {

    @Getter
    private static final NewToDoPage instance = new NewToDoPage();

    private final By newTodoInput = By.xpath("//input[@data-testid='new-todo']");
    private final By submitNewTaskButton = By.xpath("//button[@data-testid='submit-newTask']");

    @Step("Add to do using the UI")
    public void addToDoUI(WebDriver driver, String inputToDoText) {
        driver.findElement(this.newTodoInput).sendKeys(inputToDoText);
        driver.findElement(this.submitNewTaskButton).click();
    }

    @Step("Add to do using the API")
    public void addToDoAPI(User user, String inputToDoText) {
        ToDoApi.getInstance().addNewToDo(user, new ToDo(false, inputToDoText));
    }
}
