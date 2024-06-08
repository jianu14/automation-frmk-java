package com.qacart.todo.apis;

import com.qacart.todo.models.ToDo;
import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static io.restassured.RestAssured.given;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ToDoApi {

    @Getter
    private static final ToDoApi instance = new ToDoApi();

    public void addNewToDo(User user, ToDo toDo) {
        given()
                .baseUri(ConfigUtils.getInstance().getBaseURL())
                .contentType(ContentType.JSON)
                .body(toDo)
                .auth().oauth2(user.getAccessToken())
                .when()
                .post("/api/v1/tasks")
                .then()
                .extract()
                .response();
    }
}
