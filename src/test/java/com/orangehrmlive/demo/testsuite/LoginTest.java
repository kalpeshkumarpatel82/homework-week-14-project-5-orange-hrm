package com.orangehrmlive.demo.testsuite;
/* 
 Created by Kalpesh Patel
 */

import com.orangehrmlive.demo.Pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AdminPage adminPage;
    AddUserPage addUserPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        addUserPage = new AddUserPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldLoginSuccessFully(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getWelcomeMessage(), "Welcome", "Failed to login");
        softAssert.assertAll();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getLogoDisplayed(), true, "Failed to load a logo");
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully(){
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        homePage.setUserProfileLogoHoverAndClick();
        homePage.setLogOutButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getLoginHeader(), "LOGIN Panel", "Failed to logout");
        softAssert.assertAll();
    }


}
