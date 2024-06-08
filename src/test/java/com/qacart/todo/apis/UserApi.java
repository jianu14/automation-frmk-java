package com.qacart.todo.apis;

import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static io.restassured.RestAssured.given;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserApi {

    @Getter
    private static final UserApi instance = new UserApi();

    public Response register(User user) {
        return given()
                .baseUri(ConfigUtils.getInstance().getBaseURL())
                .contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .when()
                .post("/api/v1/users/register")
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response login(User user) {
        return given()
                .baseUri(ConfigUtils.getInstance().getBaseURL())
                .contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .when()
                .post("/api/v1/users/login")
                .then()
                .log().all()
                .extract()
                .response();
    }
}
