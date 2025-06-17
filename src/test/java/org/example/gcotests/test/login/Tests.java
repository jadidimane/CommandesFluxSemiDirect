package org.example.gcotests.test.login;
import com.opencsv.exceptions.CsvValidationException;
import org.example.gcopages.DetailCommandePage;
import org.example.gcopages.OrderCreationPage;
import org.example.gcopages.OrderSearchPage;
import org.example.gcotests.base.testBase;
import org.example.utilities.Excel;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Tests extends testBase {

     @Test
     public void DetailCommand() throws InterruptedException, CsvValidationException, IOException {
         menuPage=loginPage.loginIntoGCO("RHT15","RHT","911");
         OrderCreationPage order=menuPage.setCommandeFournisseur().setNewCommand();
         DetailCommandePage detail=order.newCommande("Semi-Direct","Valo. prix Centrale","A0341 - SAIDA FOOD TRADING","Par article",Excel.extractEANCodes(),List.of("RH Vitrolles","RH Bonneveine","RH Grand Littoral"));
         detail.setOrderPUQuantity();
     }
     @Test
     public void FillSupplierDetailLivraisonEntrepot() throws InterruptedException, CsvValidationException, IOException {
         menuPage=loginPage.loginIntoGCO("RHT15","RHT","912");
         OrderCreationPage order=menuPage.setCommandeFournisseur().setNewCommand();
         DetailCommandePage detail=order.DetailCommandePageLivraison("Cde livrais entrepot","A921 - RH TRADING TAMPONET","Par article",Excel.extractEANCodes(),List.of("RH Vitrolles","RH Bonneveine","RH Grand Littoral"));
         detail.setOrderPUQuantity();
     }

}
