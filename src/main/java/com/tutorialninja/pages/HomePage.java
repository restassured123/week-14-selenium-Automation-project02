package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By desktop = By.linkText("Desktops");
    By clickOnShowAllDesktop = By.xpath("//a[contains(text(),'Show AllDesktops')]");
    By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    By showAllLaptopsAndNotebooks = By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]");
    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By pound = By.xpath("//button[normalize-space()='£Pound Sterling']");
    By myAccount = By.xpath("//span[contains(text(),'My Account')]");


    public void clickOnDesktop() {
        mouseHoverToElementAndClick(desktop);
    }

    public void selectMenu(String menu) {
        clickOnElement(showAllLaptopsAndNotebooks);
    }

    public void clickOnLaptopsAndNotebooks() {
        clickOnElement(laptopsAndNotebooks);
    }

    public void clickShowAllLaptopsAndNotebooks(String menu) {
        clickOnElement(showAllLaptopsAndNotebooks);
    }

    public void mouseHoverOnLaptopsAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    public void selectCurrency() {
        clickOnElement(currency);
        clickOnElement(pound);
    }

    public void clickOnMyAccount() {
        clickOnElement(myAccount);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }

    }
}


