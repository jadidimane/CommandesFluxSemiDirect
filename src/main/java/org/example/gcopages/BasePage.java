package org.example.gcopages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(110));
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }
    protected WebElement find(By locator) {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement find2(By locator) {
       return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected void click(By locator) {
        find(locator).click();
    }
    protected void type(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

}
