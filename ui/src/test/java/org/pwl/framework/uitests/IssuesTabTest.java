package org.pwl.framework.uitests;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IssuesTabTest extends BaseTestClass {

    @Test
    void testIssuesFilters() {
        driver.get(BASE_URL + USER + "/github-tests/issues");
        WebElement closed = driver.findElement(By.partialLinkText("Close"));
        System.out.println(closed.isDisplayed());
        closed.click();
        driver.findElement(By.id("author-select-menu")).click();
        WebElement authorFilterField = driver.findElement(By.id("author-filter-field"));
        authorFilterField.sendKeys(USER);
        authorFilterField.sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Organize tests")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://github.com/pawelchoinski/github-tests/issues/1";
        assertEquals(currentUrl, expectedUrl);
    }
}
