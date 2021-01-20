package org.pwl.framework.apitests;

import static org.testng.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Java11ClientGetTests {
    public static final String BASE_URL = "https://api.github.com";
    static HttpClient httpClient = HttpClient.newBuilder().build();
    static HttpResponse<Void> response;

    @BeforeClass
    void setUp() throws IOException, InterruptedException {
        HttpRequest get =
                HttpRequest.newBuilder(URI.create(BASE_URL))
                        .setHeader("user-agent", "Java 11 HTTP Client")
                        .build();

        response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
    }

    @Test
    void getShouldReturn200() {
        int actualCode = response.statusCode();
        int expectedCOde = 200;
        assertEquals(actualCode, expectedCOde);
    }

    @Test
    void contentTypeIsJson() {
        String actualContentType = response.headers().firstValue("content-type").get();
        String expectedContentType = "application/json; charset=utf-8";
        assertEquals(actualContentType, expectedContentType);
    }

    @Test
    void xRateLimitIsPresent() {
        String xXRateLimit = response.headers().firstValue("X-RateLimit-Limit").get();
        assertEquals(Integer.parseInt(xXRateLimit), 60);
    }

    @DataProvider
    Object[][] provider() {
        return new Object[][] {
            {"content-type", "application/json; charset=utf-8"},
            {"X-RateLimit-Limit", "60"},
            {"server", "GitHub.com"}
        };
    }

    @Test(dataProvider = "provider")
    void parametrizedTestForHeaders(String header, String expectedValue) {
        String actualHeaderValue = response.headers().firstValue(header).get();
        assertEquals(actualHeaderValue, expectedValue);
    }
}
