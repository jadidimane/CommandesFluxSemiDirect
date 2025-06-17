package org.example.gcopages;

import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.example.utilities.Excel.extractEANCodes;
import static org.example.utilities.JavaScriptUtility.scrollToElement;

public class OrderCreationPage extends BasePage{
    private By ordergenre = By.xpath("//div[@id='orderMode']/input");
    private By supplierField=By.xpath("//input[@aria-label='Fournisseur']");
    private By selectMode=By.xpath("//div[@id='orderCreationMode']");
    private By addArticle=By.xpath("//*[@id='articleGrid-srgridtoolbar-add-button']");
    private By articlesPanel=By.xpath("//div[text()='Périmètre articles']");
    private By articleInput=By.xpath("//*[@id=\"articleGrid\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div[1]");
    private By siteInput=By.xpath("//*[@id=\"siteScopeGrid\"]/div/div[2]/div[2]/div[3]/div[2]/div/div/div");
    private By sitePanel=By.xpath("//div[text()='Périmètre sites']");
    private By addsite=By.xpath("//*[@id=\"siteScopeGrid-srgridtoolbar-add-button\"]/span[2]/i");
    private By validationButton=By.xpath("//*[@id=\"srtoolbartransaction-validate-button\"]/span[2]");
    private By typeValo=By.xpath("//input[@aria-label='Type valorisation']");
    public void setSupplierField(String value) {
        type(supplierField,value);
        type(supplierField, String.valueOf(Keys.ENTER));
    }
    public DetailCommandePage setValidationButton() {
        click(validationButton);
        DetailCommandePage detail= new DetailCommandePage();
        detail.setDriver(getDriver());
        return detail;
    }
    public void setSelectionMode(String selectionMode) throws InterruptedException {
        int idqvs2=0;
        scrollToElement(articlesPanel);
        click(selectMode);
        type(By.xpath("//input[@aria-label='Mode de sélection']"),selectionMode);
        Thread.sleep(600);
        String id=find(By.xpath("//div[contains(@id, 'qvs')]")).getAttribute("id");
        idqvs2=Integer.parseInt(id.split("_")[1]);
        Thread.sleep(600);
        click(By.id("qvs_"+idqvs2));
    }
    public void setAddArticle() throws InterruptedException {
        Thread.sleep(1000);
        scrollToElement(addArticle);
        click(addArticle);
    }
    public void setAddsite() {
        scrollToElement(addsite);
        click(addsite);
    }
    public void setArticleInput(List<String> articles) throws CsvValidationException, IOException, InterruptedException {
        scrollToElement(articlesPanel);
        String compid = "0";
        int j=0;
        int suite=0;
        for(String article:articles){
            if(extractEANCodes().get(0).equals(article)){
                setAddArticle();
                compid =find(articleInput).getAttribute("comp-id");
                click(articleInput);
                suite=Integer.parseInt(compid);
         }

            else{
                suite+=11;
                setAddArticle();

            }

                By champArticle = By.xpath("//div[@comp-id='" + (suite + 7) + "']");
                /*click(champArticle);*/
                Thread.sleep(1000);
                find(champArticle).sendKeys(article);
//                Thread.sleep(2500);
                find(champArticle).sendKeys(Keys.TAB);
                /*j++;
                if(j==5){
                    break;
                }*/



        }

        find(By.xpath("//*[@id=\"articleGrid\"]/div/div[2]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div[2]")).click();
    }
    public void setSiteInput(List<String> sites) throws InterruptedException {
        int idqvs1=0;
        int idqvs2=0;
        String compid = "0";
        int suite=0;
        int i=0;
        scrollToElement(sitePanel);
        for (String clientsite : sites) {
            if(sites.get(0).equals(clientsite)){
                setAddsite();
                compid =find(siteInput).getAttribute("comp-id");
                click(siteInput);
                suite=Integer.parseInt(compid);
            }
            else{
                suite+=12;
                setAddsite();
            }
            By champNomSite = By.xpath("//div[@comp-id='" + (suite + 7) + "']");
            By champScope = By.xpath("//div[@comp-id='" + (suite + 8) + "']");
            Thread.sleep(500);
            find(champNomSite).sendKeys(clientsite);
            idqvs1=Integer.parseInt(find(By.xpath("//div[contains(@id, 'qvs')]")).getAttribute("id").split("_")[1]);
            Thread.sleep(900);
            click(By.id("qvs_"+idqvs1));
            Thread.sleep(900);
            find(champScope).sendKeys("H0");
            String id=find(By.xpath("//div[contains(@id, 'qvs')]")).getAttribute("id");
            idqvs2=Integer.parseInt(id.split("_")[1]);
            Thread.sleep(900);
            find(By.id("qvs_"+idqvs2)).click();
            click(By.xpath("//div[@comp-id='" + (suite + 9) + "']"));
            By sitePoids = By.xpath("(//div[@class='ag-center-cols-container'])[4]/div["+(i+1)+"]/div[3]//input");
            type(sitePoids, "1" + Keys.TAB);
            i++;

        }
        click(By.xpath("//*[@id=\"siteScopeGrid\"]/div/div[2]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div[2]"));
    }
    public void setOrdergenre(String genre) throws InterruptedException {
        find(ordergenre).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(500);
        type(ordergenre, genre);
        Thread.sleep(500);
        find(By.id("qvs_30"));
        click(By.id("qvs_30"));
    }
    public void setTypeVlorisation(String typeVlorisation) throws InterruptedException {
        int idqvs2=0;
        find(typeValo).sendKeys(typeVlorisation);
        Thread.sleep(500);
        String id=find(By.xpath("//div[contains(@id, 'qvs')]")).getAttribute("id");
        idqvs2=Integer.parseInt(id.split("_")[1]);
        Thread.sleep(500);
        click(By.id("qvs_"+idqvs2));
    }
    public DetailCommandePage newCommande(String orderGenre, String valoType,String supplier,String seelectionMode,List<String> articles,List<String> sites) throws InterruptedException, CsvValidationException, IOException {
        setOrdergenre(orderGenre);
        setTypeVlorisation(valoType);
        setSupplierField(supplier);
        Thread.sleep(1000);
        setSelectionMode(seelectionMode);
        setArticleInput(articles);
        setSiteInput(sites);
        return setValidationButton();
    }
    public DetailCommandePage DetailCommandePageLivraison(String orderGenre,String supplier,String seelectionMode,List<String> articles,List<String> sites) throws InterruptedException, CsvValidationException, IOException {
        setOrdergenre(orderGenre);
        setSupplierField(supplier);
        Thread.sleep(1000);
        setSelectionMode(seelectionMode);
        setArticleInput(articles);
        setSiteInput(sites);
        return setValidationButton();
    }

}
