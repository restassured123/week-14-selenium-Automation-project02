package com.tutorialninja.testbase;

import com.tutorialninja.propertyreader.PropertyReader;
import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){

        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){

        closerBrowser();
    }

    public void verifyTwoStrings(By by, String text){
        String expected =text;
        String actual = getTextFromElement(by);
        Assert.assertEquals(actual,expected);
    }
    public void selectMethod(By by){
        WebElement components = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(components).click().build().perform();

    }
}
