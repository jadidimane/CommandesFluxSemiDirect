package org.example.utilities;

import org.example.gcopages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static void setUtilityDriver(WebDriver driver) {
        Utility.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(50));
    }

}
