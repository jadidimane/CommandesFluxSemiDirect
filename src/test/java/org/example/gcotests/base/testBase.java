package org.example.gcotests.base;

import org.example.gcopages.BasePage;
import org.example.gcopages.LoginPage;
import org.example.gcopages.MenuPage;
import org.example.utilities.Utility;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class testBase {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected MenuPage menuPage;
    private String url="http://192.168.0.116:9080/gco/";
    @Before
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        /*options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");*/
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage=new BasePage();
        basePage.setDriver(driver);
        Utility.setUtilityDriver(driver);

        loginPage=new LoginPage();
        loginPage.setDriver(driver);

    }
    @After
    public void tearDown(){
    }
}
