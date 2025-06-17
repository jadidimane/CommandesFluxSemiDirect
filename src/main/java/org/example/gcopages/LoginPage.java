package org.example.gcopages;

import org.example.utilities.JavaScriptUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.utilities.JavaScriptUtility.scrollToElement;

public class LoginPage extends BasePage {
      private By usernameField=By.name("userField");
        private By passwordField=By.name("passwordField");
        private By loginButton=By.tagName("button");
        private By siteI=By.xpath("//input[@aria-label='Site']");
       /* private By dropDownIcon=By.xpath(
                "/html/body/div[1]/div/div/div/main/div/div/div[2]/div/div[2]/div[1]/label[3]/div[1]/div[1]/div[3]/i");*/

    public void setUsernameField(String username) {
        type(usernameField,username);
    }
    public void setPasswordField(String password) {
        type(passwordField,password);
    }
    public MenuPage setLoginButton() {
        click(loginButton);
        MenuPage menuPage = new MenuPage();
        menuPage.setDriver(this.getDriver());
        return menuPage;
    }
    public void setSite(String site) throws InterruptedException {
        int idqvs2=0;
        click(By.cssSelector(".desktop"));
        Thread.sleep(200);
        find(siteI).sendKeys(site);
        Thread.sleep(500);
        String id=find(By.xpath("//div[contains(@id, 'qvs')]")).getAttribute("id");
        idqvs2=Integer.parseInt(id.split("_")[1]);
        Thread.sleep(500);
        click(By.id("qvs_"+idqvs2));
    }
    public MenuPage loginIntoGCO(String username, String password, String site) throws InterruptedException {
        setUsernameField(username);
        setPasswordField(password);
        setSite(site);

        return setLoginButton();

    }
}
