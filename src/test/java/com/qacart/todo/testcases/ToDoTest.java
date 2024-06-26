package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.LogInPage;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToDoTest extends BaseTest {

    LogInPage logInPage = LogInPage.getInstance();
    ToDoPage toDoPage = ToDoPage.getInstance();
    NewToDoPage newTodoPage = NewToDoPage.getInstance();

    /**
     * Log in made from UI
     * Add made from UI
     */
    @Test(description = "Should be able to Add a ToDo")
    public void shouldBeAbleToAddAToDo() throws InterruptedException {
        User user = User.getUserOne();

        logInPage.load(driver.get());
        logInPage.logInUI(driver.get(), user);
        Thread.sleep(500);

        toDoPage.clickOnPlusButton(driver.get());
        String inputToDoText = "Learn to cook";
        newTodoPage.addToDoUI(driver.get(), inputToDoText);
        Thread.sleep(500);

        String taskText = toDoPage.getToDoText(driver.get());
        assertThat(taskText).isEqualTo(inputToDoText);
        Thread.sleep(500);
    }

    /**
     * Log in made from API
     * Add made from UI
     */
    @Test(description = "Should be able to Add another ToDo")
    public void shouldBeAbleToAddAnotherToDo() throws InterruptedException {
        User user = User.getUserTwo();

        logInPage.load(driver.get());
        logInPage.logInAPI(driver.get(), user);
        Thread.sleep(500);

        toDoPage.clickOnPlusButton(driver.get());
        String inputToDoText = "Learn to cook";
        newTodoPage.addToDoUI(driver.get(), inputToDoText);
        Thread.sleep(500);

        String taskText = toDoPage.getToDoText(driver.get());
        assertThat(taskText).isEqualTo(inputToDoText);
        Thread.sleep(500);
    }

    /**
     * Log in made from API
     * Add made from API
     * Delete made from UI
     */
    @Test(description = "Should be able to Delete a ToDo")
    public void shouldBeAbleToDeleteAToDo() throws InterruptedException {
        User user = User.getUserThree();

        logInPage.load(driver.get());
        logInPage.logInAPI(driver.get(), user);
        Thread.sleep(500);

        String inputToDoText = "Learn to not cook";
        newTodoPage.addToDoAPI(user, inputToDoText);
        Thread.sleep(500);

        toDoPage.load(driver.get());
        toDoPage.deleteToDo(driver.get());
        boolean isNoToDosDisplayed = toDoPage.isNoToDosMessageDisplayed(driver.get());
        assertThat(isNoToDosDisplayed).isTrue();
        Thread.sleep(500);
    }

}
