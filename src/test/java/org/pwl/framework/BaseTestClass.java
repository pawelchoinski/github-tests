package org.pwl.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
    public static final String BASE_URL = "https://github.com/";
    public static final String USER = "pawelchoinski";
    static WebDriver driver;

    @BeforeClass
    static void setup() {
        driver = DriverFactory.getChromeDriver();
    }

    @AfterClass
    static void cleanup() {
        driver.close();
    }
}
