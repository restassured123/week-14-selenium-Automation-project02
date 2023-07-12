package com.tutorialninja.testsuite;

import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.clickOnDesktop();
        homePage.selectMenu("Show AllDesktops");
        //desktopPage.setSortZToA();
        Thread.sleep(2000);

        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        // Sort By Reverse order
        Collections.reverse(originalProductsName);

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        Thread.sleep(3000);
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        Assert.assertEquals(afterSortByZToAProductsName, originalProductsName, "Product not arrange in descending order.");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.clickOnDesktop();
        homePage.selectMenu("Show AllDesktops");
        Thread.sleep(2000);
        desktopPage.selectSorting("Name (A - Z)");
        Thread.sleep(5000);
        desktopPage.selectHPLP3065();
        Thread.sleep(3000);
        verifyTwoStrings(By.xpath("//a[contains(text(),'HP LP3065')]"), "HP LP3065");
        Thread.sleep(2000);
        desktopPage.datePicker("2022", "November", "30");
        Thread.sleep(2000);
        desktopPage.clearQuantity();
        desktopPage.clickOnAddToCart();
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//div[@class = 'alert alert-success alert-dismissible']"),"Success: You have added HP LP3065 to your shopping cart!\n" + "×");
        Thread.sleep(2000);
        desktopPage.clickOnShoppingCartLink();
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Shopping Cart')]"),"Shopping Cart  (1.00kg)");
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"HP LP3065");
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"),"Delivery Date:2022-11-30");
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//td[contains(text(),'Product 21')]"), "Product 21");
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//tbody/tr[1]/td[6]"),"$122.00");
        Thread.sleep(2000);

    }
}
