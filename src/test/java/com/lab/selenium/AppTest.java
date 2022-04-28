package com.lab.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.lab.selenium.App.takeScreenshot;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AppTest {

    @Test
    public void test() {
        String filePath = "src/main/screenshots/1.jpg";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver.exe");
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://www.google.com/");
        webDriver.findElement(By.name("q")).sendKeys("cats" + Keys.ENTER);
        WebElement first = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
        System.out.println(first.getAttribute("textContent"));


        Assert.assertFalse(first.getAttribute("textContent").isEmpty());
        takeScreenshot(webDriver, filePath);
    }
}
