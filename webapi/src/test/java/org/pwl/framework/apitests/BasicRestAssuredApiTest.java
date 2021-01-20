package org.pwl.framework.apitests;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class BasicRestAssuredApiTest {
    @Test
    public void getStatusCodeIs200() {
        RestAssured.get("https://api.github.com")
                .then()
                .statusCode(200);
    }

    @Test
    public void  bodyContainsLoginAndType() {
        RestAssured.get("https://api.github.com/users/pawelchoinski")
                .then()
                .assertThat()
                .body("login", equalTo("pawelchoinski"))
                .body("type", equalTo("User"));
    }
}
