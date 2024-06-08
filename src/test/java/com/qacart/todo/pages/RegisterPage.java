package com.qacart.todo.pages;

import com.qacart.todo.apis.UserApi;
import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterPage {

    @Getter
    private static final RegisterPage instance = new RegisterPage();

    private final By firstNameInput = By.xpath("//input[@data-testid='first-name']");
    private final By lastNameInput = By.xpath("//input[@data-testid='last-name']");
    private final By emailInput = By.xpath("//input[@data-testid='email']");
    private final By passwordInput = By.xpath("//input[@data-testid='password']");
    private final By confirmPasswordInput = By.xpath("//input[@data-testid='confirm-password']");
    private final By submitButton = By.xpath("//button[@data-testid='submit']");

    @Step("Visit the sign up page")
    public void load(WebDriver driver) {
        driver.get(ConfigUtils.getInstance().getBaseURL() + "/signup");
    }

    @Step("Register using the UI")
    public void registerUI(WebDriver driver, User user) {
        driver.findElement(this.firstNameInput).sendKeys(user.getFirstName());
        driver.findElement(this.lastNameInput).sendKeys(user.getLastName());
        driver.findElement(this.emailInput).sendKeys(user.getEmail());
        driver.findElement(this.passwordInput).sendKeys(user.getPassword());
        driver.findElement(this.confirmPasswordInput).sendKeys(user.getPassword());
        driver.findElement(this.submitButton).click();
    }

    @Step("Register using the API")
    public void registerAPI(WebDriver driver, User user) {
        Response response = UserApi.getInstance().register(user);

        String accessToken = response.path("access_token");
        String userID = response.path("userID");
        String firstName = response.path("firstName");
        user.setAccessToken(accessToken);

        Cookie accessTokenCookie = new Cookie("access_token", accessToken);
        Cookie userIDCookie = new Cookie("userID", userID);
        Cookie firstNameCookie = new Cookie("firstName", firstName);

        driver.manage().addCookie(accessTokenCookie);
        driver.manage().addCookie(userIDCookie);
        driver.manage().addCookie(firstNameCookie);
        RegisterPage.getInstance().load(driver);
    }
}
