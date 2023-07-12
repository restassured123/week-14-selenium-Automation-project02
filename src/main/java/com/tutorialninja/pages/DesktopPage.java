package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopPage extends Utility {
    By sortByAToZ = By.id("input-sort");
    By hPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");
    By calendar = By.xpath("//div[@class = 'input-group date']//button");
    By monthAndyear = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By nextIcon = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    By alldates = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By quantity = (By.id("input-quantity"));
    By addToCart = (By.id("button-cart"));
    By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");

    public void selectSorting(String text) {
        selectByVisibleTextFromDropDown(sortByAToZ, text);
    }
    public void selectHPLP3065(){
        clickOnElement(hPLP3065);
    }
    public void datePicker(String y, String m, String d) {
        String year = y;
        String month = m;
        String date = d;
        clickOnElement(calendar);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndyear);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextIcon);
            }
        }
        List<WebElement> allDates = driver.findElements(alldates);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clearQuantity(){
       sendTextToElement(quantity,"1");
    }
    public void clickOnAddToCart(){
        clickOnElement(addToCart);
    }
    public void clickOnShoppingCartLink(){
        clickOnElement(shoppingCartLink);
    }


}

