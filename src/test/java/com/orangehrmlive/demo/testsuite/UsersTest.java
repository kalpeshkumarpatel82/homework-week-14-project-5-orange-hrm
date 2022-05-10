package com.orangehrmlive.demo.testsuite;
/* 
 Created by Kalpesh Patel
 */

import com.orangehrmlive.demo.Pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsersTest extends TestBase {
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

    @Test(priority = 0, groups = {"sanity", "regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        homePage.setAdminMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(adminPage.getAdminHeader(), "System Users", "Failed to navigate Admin Page");
        adminPage.setAddButton();
        addUserPage.setUserRoleDropDown("Admin");
        addUserPage.setEmployeeName("Ananya Dash");
        addUserPage.setUserName("admin");
        addUserPage.setStatusDropDown("Disabled");
        addUserPage.setPassword("12345678");
        addUserPage.setConfirmPassword("12345678");
        addUserPage.setSaveButton();
        Thread.sleep(500);
        softAssert.assertEquals(addUserPage.getConfirmMessage(), "Successfully Saved", "Failed to save");
        softAssert.assertAll();
    }

    @Test(priority = 1, groups = {"sanity", "smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        homePage.setAdminMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(adminPage.getAdminHeader(), "System Users", "Failed to navigate Admin Page");
        viewSystemUsersPage.setUserName("admin123");
        viewSystemUsersPage.setUserRoleDropDown("Admin");
        viewSystemUsersPage.setEmployeeName("Ananya Dash");
        viewSystemUsersPage.setStatus("Disabled");
        viewSystemUsersPage.setSearchButton();
        softAssert.assertEquals(viewSystemUsersPage.getSearchResult(), "admin123", "Failed to search");
        viewSystemUsersPage.setSearchResultCheckbox();
        viewSystemUsersPage.setDeleteButton();
        softAssert.assertAll();
    }

    @Test(priority = 2, groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        homePage.setAdminMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(adminPage.getAdminHeader(), "System Users", "Failed to navigate Admin Page");
        viewSystemUsersPage.setUserName("Orange");
        viewSystemUsersPage.setUserRoleDropDown("Admin");
        viewSystemUsersPage.setEmployeeName("Ananya Dash");
        viewSystemUsersPage.setStatus("Disabled");
        viewSystemUsersPage.setSearchButton();
        Thread.sleep(2000);
        viewSystemUsersPage.setSearchResultCheckbox();
        viewSystemUsersPage.setDeleteButton();
        viewSystemUsersPage.setDeleteRecordDialogueBoxOK();
        softAssert.assertEquals(viewSystemUsersPage.getDeletionConfirmation(), "Successfully Deleted", "Failed to save");
        softAssert.assertAll();
    }

    @Test(priority = 3, groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.setLoginButton();
        homePage.setAdminMenu();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(adminPage.getAdminHeader(), "System Users", "Failed to navigate Admin Page");
        viewSystemUsersPage.setUserName("Orange");
        viewSystemUsersPage.setUserRoleDropDown("Admin");
        viewSystemUsersPage.setEmployeeName("Ananya Dash");
        viewSystemUsersPage.setStatus("Disabled");
        viewSystemUsersPage.setSearchButton();
        softAssert.assertEquals(viewSystemUsersPage.getNoRecordFound(), "No Records Found", "Failed to save");
        softAssert.assertAll();
    }

}
