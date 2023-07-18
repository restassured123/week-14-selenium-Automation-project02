package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LogOutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement logout;

    public void clickOnLogout(){
        Reporter.log("click On Logout" + logout.toString());
        CustomListeners.test.log(Status.PASS, "click On Logout" + logout);
        clickOnElement(logout);
    }
}
