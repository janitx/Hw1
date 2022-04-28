package com.lab.selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.io.File;
import java.time.Duration;


public class App {

    public static void takeScreenshot(WebDriver driver, String filePath) {


        TakesScreenshot ts = (TakesScreenshot) driver;

        try {
            File source = ts.getScreenshotAs(OutputType.FILE);
            File target = new File(filePath);
            FileHandler.copy(source, target);
        } catch (Exception e) {
            System.err.format("WebDriverForm.takeScreenshot() = %s", e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver.exe");
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://www.google.com/");
        webDriver.findElement(By.name("q")).sendKeys("cats" + Keys.ENTER);
        WebElement first = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
        System.out.println(first.getAttribute("textContent"));

    }
}
