package org.pwl.framework.uitests;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;

public class OverviewTabTests extends BaseTestClass {
    @Test
    void usernameIsCorrectOnOverviewTab() {
        driver.get(BASE_URL + USER);
        String actualUsername = driver.findElement(By.className("p-nickname")).getText();
        assertEquals(USER, actualUsername);
    }
}
