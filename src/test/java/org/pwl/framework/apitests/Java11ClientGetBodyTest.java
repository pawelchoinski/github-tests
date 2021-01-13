package org.pwl.framework.apitests;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.pwl.framework.handlers.JsonBodyHandler;
import org.pwl.framework.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Java11ClientGetBodyTest {
    public static final String BASE_URL = "https://api.github.com";
    static HttpClient httpClient = HttpClient.newBuilder().build();

    @Test
    void handleJsonBody() throws IOException, InterruptedException {
        HttpRequest get =
                HttpRequest.newBuilder(URI.create(BASE_URL + "/users/pawelchoinski")).build();
        HttpResponse<User> response = httpClient.send(get, new JsonBodyHandler<>(User.class));
        User user = response.body();
        Assert.assertEquals(user.getLogin(), "pawelchoinski");
    }
}
