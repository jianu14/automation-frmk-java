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
    @Test(description = "Should be able to Register (UI)")
    public void shouldBeAbleToRegisterToTheApplicationUI() throws InterruptedException {
        User user = User.generateRandomRegisterUser();

        registerPage.load(driver.get());
        registerPage.registerUI(driver.get(), user);
        Thread.sleep(500);

        boolean isWelcomeDisplayed = toDoPage.isWelcomeMessageDisplayed(driver.get());
        assertThat(isWelcomeDisplayed).isTrue();
        Thread.sleep(500);
    }

    /**
     * Register made from API
     */
    @Test(description = "Should be able to Register (API)")
    public void shouldBeAbleToRegisterToTheApplicationAPI() throws InterruptedException {
        User user = User.generateRandomRegisterUser();

        registerPage.load(driver.get());
        registerPage.registerAPI(driver.get(), user);
        Thread.sleep(500);

        boolean isWelcomeDisplayed = toDoPage.isWelcomeMessageDisplayed(driver.get());
        assertThat(isWelcomeDisplayed).isTrue();
        Thread.sleep(500);
    }
}
