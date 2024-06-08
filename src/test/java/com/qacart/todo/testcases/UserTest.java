package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import com.qacart.todo.pages.RegisterPage;
import com.qacart.todo.pages.ToDoPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest extends BaseTest {

    RegisterPage registerPage = RegisterPage.getInstance();
    ToDoPage toDoPage = ToDoPage.getInstance();

    /**
     * Register made from UI
     */
    @Test
    public void shouldBeAbleToRegisterToTheApplicationUI() throws InterruptedException {
        User user = User.generateRandomRegisterUser();

        registerPage.load(driver);
        registerPage.registerUI(driver, user);
        Thread.sleep(500);

        boolean isWelcomeDisplayed = toDoPage.isWelcomeMessageDisplayed(driver);
        assertThat(isWelcomeDisplayed).isTrue();
        Thread.sleep(500);
    }

    /**
     * Register made from API
     */
    @Test
    public void shouldBeAbleToRegisterToTheApplicationAPI() throws InterruptedException {
        User user = User.generateRandomRegisterUser();

        registerPage.load(driver);
        registerPage.registerAPI(driver, user);
        Thread.sleep(500);

        boolean isWelcomeDisplayed = toDoPage.isWelcomeMessageDisplayed(driver);
        assertThat(isWelcomeDisplayed).isTrue();
        Thread.sleep(500);
    }
}
