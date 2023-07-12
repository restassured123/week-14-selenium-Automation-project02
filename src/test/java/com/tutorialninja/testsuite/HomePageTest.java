package com.tutorialninja.testsuite;

import com.tutorialninja.pages.DesktopPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.LaptopsAndNotebooksPage;
import com.tutorialninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
        HomePage homePage = new HomePage();
        DesktopPage desktopPage = new DesktopPage();
        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.clickOnDesktop();
        homePage.selectMenu("Show AllDesktops");
        verifyTwoStrings(By.xpath("//h2[contains(text(),'Desktops')]"),"Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.clickOnLaptopsAndNotebooks();
        homePage.clickShowAllLaptopsAndNotebooks("Show AllLaptops & Notebooks");
        verifyTwoStrings(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"),"Laptops & Notebooks");
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        selectMethod(By.linkText("Components"));
        selectMethod(By.linkText("Show AllComponents"));
        verifyTwoStrings(By.xpath("//h2[contains(text(),'Components')]"),"Components");

    }
}
