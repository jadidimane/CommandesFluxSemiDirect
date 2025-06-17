package org.example.gcopages;

import org.openqa.selenium.By;

public class OrderSearchPage extends BasePage {
    private By NewCommand=By.xpath("//*[text()='Nouveau']");
    private By NewCommandWindow=By.xpath("//*[text()='Nouvelle commande']");
    public OrderCreationPage setNewCommand(){
        click(NewCommand);
        OrderCreationPage order= new OrderCreationPage();
        order.setDriver(this.getDriver());
        return order;
    }
    public  boolean isNewCommandWindowDisplayd(){
        return find(NewCommandWindow).isDisplayed();
    }
}
