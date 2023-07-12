package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends Utility {
    By quantity = By.xpath("//input[contains(@name, 'quantity')]");
    By update = By.xpath("//button[contains(@data-original-title, 'Update')]");

    public void changeQuantity(String text) {
        WebElement qty = driver.findElement(quantity);
        qty.clear();
        sendTextToElement(quantity, text);
    }
    public void clickOnUpdate(){
        clickOnElement(update);
    }

}