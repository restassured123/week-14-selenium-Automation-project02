package com.tutorialninja.testsuite;

import com.tutorialninja.pages.*;
import com.tutorialninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MyAccountsTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopsPage = new DesktopPage();
    ProductPage productPage = new ProductPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    RegisterPage registerPage = new RegisterPage();
    AccountPage accountPage = new AccountPage();
    LogOutPage logOutPage = new LogOutPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Register Account')]"),"Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        verifyTwoStrings(By.xpath("//h2[contains(text(),'Returning Customer')]"),"Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Dhiren");
        registerPage.enterLastName("Ganvir");
        registerPage.enterEmail("prime");
        registerPage.enterTelephone("07666333111");
        registerPage.enterPassword("Prime@123");
        registerPage.enterConfirmPassword("Prime@123");
        registerPage.clickOnSubscribe();
        registerPage.clickOnPolicy();
        registerPage.clickOnContinueButton();
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"),"Your Account Has Been Created!");
        accountPage.clickOnContinue();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        verifyTwoStrings(By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");
        logOutPage.clickOnLogout();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmail("prime1233@gmail.com");
        loginPage.enterPassword("test1234");
        loginPage.clickOnLogin();
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        verifyTwoStrings( By.xpath("//h1[contains(text(),'Account Logout')]"),"Account Logout");
        logOutPage.clickOnLogout();
    }

}

