package org.pwl.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class GitHubTests {
    public static final String BASE_URL = "https://github.com/";
    public static final String USER = "pawelchoinski";
    static WebDriver driver;

    @BeforeClass
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    static void cleanup(){
        driver.close();
    }

    @Test
    void usernameIsCorrectOnOverviewTab() {
        driver.get(BASE_URL + USER);
        String actualUsername = driver.findElement(By.className("p-nickname")).getText();
        assertEquals(USER, actualUsername);
    }

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
        List<WebElement> repos = driver.findElements(By.xpath("//*[@id='user-repositories-list']//li"));
        int reposCounter = Integer.parseInt(driver.findElement(By.className("Counter")).getText());
        assertEquals(reposCounter, repos.size());
    }
}
