package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LaptopsAndNotebooksPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortOption;

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macbook;



    public void selectSorting(String text) {
        Reporter.log("select Sorting" + sortOption.toString());
        CustomListeners.test.log(Status.PASS, "select Sorting" + sortOption);
        selectByVisibleTextFromDropDown(sortOption, text);
    }
    public void clickOnMacbook(){
        Reporter.log("click On Macbook" + macbook.toString());
        CustomListeners.test.log(Status.PASS, "click On Macbook" + macbook);
        clickOnElement(macbook);
    }

}