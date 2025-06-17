package org.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JavaScriptUtility extends Utility{
    public static void scrollToElement(By locator) {
        WebElement webElement =wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String jsScript="arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor)driver).executeScript(jsScript,webElement);

    }
}
