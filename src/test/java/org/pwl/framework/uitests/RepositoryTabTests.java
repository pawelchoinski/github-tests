package org.pwl.framework.uitests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RepositoryTabTests extends BaseTestClass {

    @Test
    void repositoryLinkLeadsToCorrectRepository() {
        driver.get(BASE_URL + USER + "?tab=repositories");
        String repo = "github-tests";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://github.com/pawelchoinski/github-tests";
        assertEquals(currentUrl, expectedUrl);
    }

    @Test
    void repositoryCounterIsCorrect() {
        driver.get(BASE_URL + USER + "?tab=repositories");
        List<WebElement> repos =
                driver.findElements(By.xpath("//*[@id='user-repositories-list']//li"));
        int reposCounter = Integer.parseInt(driver.findElement(By.className("Counter")).getText());
        assertEquals(reposCounter, repos.size());
    }
}
