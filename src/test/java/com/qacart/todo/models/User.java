package com.qacart.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.javafaker.Faker;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    public static final String DEFAULT_PASSWORD = "Test1234";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    private String email;
    private String password;

    @JsonIgnore
    private String accessToken;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public static User generateRandomRegisterUser() {
        Faker faker = new Faker();

        return new User(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().safeEmailAddress(),
                DEFAULT_PASSWORD
        );
    }

    public static User getUserOne() {
        return new User("iancujianu1@gmail.com", DEFAULT_PASSWORD);
    }

    public static User getUserTwo() {
        return new User("iancujianu2@gmail.com", DEFAULT_PASSWORD);
    }

    public static User getUserThree() {
        return new User("iancujianu98@gmail.com", DEFAULT_PASSWORD);
    }
}
