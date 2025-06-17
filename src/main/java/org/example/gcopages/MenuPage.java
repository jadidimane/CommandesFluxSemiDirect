package org.example.gcopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage {
    private By menuLabel=By.xpath("//*[text()='Gestion des flux']");
    private By FavorisLabel=By.xpath("//div[text()='Favoris']");
    private By CommandeFournisseur=By.xpath("//*[text()='Commandes fournisseur']");

    public void setMenuLabel(){
        click(menuLabel);
    }
    public boolean isFavorisLabelDisplayd(){
        return find(FavorisLabel).isDisplayed();
    }
    public OrderSearchPage setCommandeFournisseur(){
        click(CommandeFournisseur);
        OrderSearchPage order= new OrderSearchPage();
        order.setDriver(this.getDriver());
        return order;
    }
    public boolean isCommandeFournisseurDisplayd(){
        return find(CommandeFournisseur).isDisplayed();
    }

}
