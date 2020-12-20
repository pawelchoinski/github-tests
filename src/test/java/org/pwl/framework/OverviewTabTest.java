package org.pwl.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class OverviewTabTest {

    @Test
    void usernameIsCorrectOnOverviewTab() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions().addArguments("start-fullscreen");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String user = "pawelchoinski";
        driver.get("https://github.com/" + user);

        String actualUsername = driver.findElement(By.className("p-nickname")).getText();

        Assert.assertEquals(user, actualUsername);
    }
}
