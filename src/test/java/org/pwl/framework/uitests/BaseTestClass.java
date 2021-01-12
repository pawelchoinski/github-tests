package org.pwl.framework.uitests;

import org.openqa.selenium.WebDriver;
import org.pwl.framework.DriverFactory;
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
