package org.example.gcopages;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.example.utilities.Excel.*;
import static org.example.utilities.JavaScriptUtility.scrollToElement;

public class DetailCommandePage extends BasePage {
    private By saveButton = By.xpath("//*[@id=\"srtoolbartransaction-save-button\"]/span[2]/i");
    private By quantityInput=By.xpath("//*[@id=\"gridQuantityDistribPerSite\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]");
    /*private By pagesuit=By.xpath("//div[@aria-label='Page suivante']") ;*/
    public void setSaveButton(){
        click(saveButton);
    }
    public void setOrderPUQuantity() throws IOException, InterruptedException, CsvValidationException {
        int i=1;
        System.out.println(map());
        for(List<String> quantity: map().values()){
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",find2(By.xpath("//div[@name='left']/div["+i+"]/div[4]/span/span[2]")));
            int compid=Integer.parseInt(find(quantityInput).getAttribute("comp-id"));
            for(int q=0; q<quantity.size(); q++){
                if(!quantity.get(q).equals("0,000")){
                    find(By.xpath("//div[@comp-id='" + (compid+q) + "']/div[3]")).sendKeys(Keys.DELETE);
                    find(By.xpath("//div[@comp-id='" + (compid+q) + "']/div[3]//input")).sendKeys(quantity.get(q)+ Keys.ENTER);
                }}
            WebElement element = find2(By.xpath("//div[@name='left']/div["+i+"]/div[4]/span/span[2]"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
            System.out.println("Target xpath: //div[@name='left']/div["+i+"]/div[4]/span/span[2]");
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
            System.out.println("Clicking on element at row: " + i + " with quantities: " + quantity);

                i++;
        }
       Thread.sleep(500);
        setSaveButton();
        click(By.xpath("/html/body/div[9]/div/div[2]/div/div[3]/button"));
        scrollToElement(By.xpath("//*[@id=\"q-app\"]/div/div/div/main/div[2]/div[1]/div[4]/button"));
        click(By.xpath("//*[@id=\"q-app\"]/div/div/div/main/div[2]/div[1]/div[4]/button"));
        click(By.xpath("/html/body/div[10]/div/div[2]/div/div[4]/button[2]"));
    }
}
