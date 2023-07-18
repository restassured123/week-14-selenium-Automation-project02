package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton;

    public void enterEmail(String text){
        Reporter.log("Enter email" + email.toString());
        CustomListeners.test.log(Status.PASS, "Enter email " + email);
        sendTextToElement(email,text);
    }
    public void enterPassword(String text){
        Reporter.log("Enter password" + password.toString());
        CustomListeners.test.log(Status.PASS, "Enter password " + password);
        sendTextToElement(password,text);
    }
    public void clickOnLogin(){
        Reporter.log("Click on Login" + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on Login " + loginButton);
        clickOnElement(loginButton);
    }

}
