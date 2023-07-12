package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class AccountPage extends Utility {

    By continueButton = By.xpath("//a[contains(text(),'Continue')]");

    public void clickOnContinue(){
        clickOnElement(continueButton);
    }

}
