package org.pwl.framework.uitests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.pwl.framework.StringUtils.*;

public class SingInTest extends BaseTestClass {
    @Test
    void invalidLoginFailsToSingIn() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.id("login_field")).sendKeys("fake");
        driver.findElement(By.id("password")).sendKeys(generateRandomString(7));
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        boolean isErrorDisplayed = driver
                .findElement(By.xpath("//*[contains(string(), 'Incorrect username or password')]"))
                .isDisplayed();

        Assert.assertTrue(isErrorDisplayed);


    }
}
