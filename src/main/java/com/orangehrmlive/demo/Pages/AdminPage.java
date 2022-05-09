package com.orangehrmlive.demo.Pages;
/* 
 Created by Kalpesh Patel
 */

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AdminPage extends Utility {
    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
    WebElement adminUserManagement;

    @FindBy(xpath = "//a[@id='menu_admin_Job']")
    WebElement adminJob;

    @FindBy(xpath = "//a[@id='menu_admin_Organization']")
    WebElement adminOrganisation;

    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;

    @FindBy(xpath = "//div[@class='head']/h1")
    WebElement userManagementHeader;

    public String getAdminHeader() {
        Reporter.log("Getting Page Header : " + userManagementHeader.toString());
        return getTextFromElement(userManagementHeader);
    }

    public void setAddButton() {
        Reporter.log("Clicking on Add Button : " + addButton.toString());
        clickOnElement(addButton);
    }
}