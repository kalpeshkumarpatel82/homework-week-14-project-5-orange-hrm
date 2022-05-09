package com.orangehrmlive.demo.Pages;
/* 
 Created by Kalpesh Patel
 */

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ViewSystemUsersPage extends Utility {
    public ViewSystemUsersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='head']/h1")
    WebElement userManagementHeader;

    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    WebElement userName;

    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRoleDropDown;

    @FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
    WebElement employeeName;

    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement status;

    @FindBy(xpath = "//input[@id='searchBtn']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@id='tableWrapper']//tbody[1]/tr/td[2]/a")
    WebElement searchResult;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    WebElement searchResultCheckbox;

    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement deleteButton;

    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordFound;

    @FindBy(xpath = "//input[@id='resetBtn']")
    WebElement resetButton;

    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;

    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    WebElement deleteRecordDialogueBoxOK;

    @FindBy(xpath = "//*[contains(text(),'Successfully')]")
    WebElement successConfirmMessage;

    public String getPageHeader() {
        Reporter.log("getting Page Header : " + userManagementHeader.toString());
        return getTextFromElement(userManagementHeader);
    }

    public void setDeleteRecordDialogueBoxOK() {
        Reporter.log("Clicking on OK to delete Dialogue box : " + deleteRecordDialogueBoxOK.toString());
        clickOnElement(deleteRecordDialogueBoxOK);
    }
    public void setResetButton() {
        Reporter.log("Clicking on reset Button : " + resetButton.toString());
        clickOnElement(resetButton);
    }

    public void setAddButton() {
        Reporter.log("Clicking on add Button : " + addButton.toString());
        clickOnElement(addButton);
    }

    public String getNoRecordFound() {
        Reporter.log("getting search result  " + noRecordFound.toString());
        return getTextFromElement(noRecordFound);
    }

    public String getSearchResult() {
        Reporter.log("getting search result : " + searchResult.toString());
        return getTextFromElement(searchResult);
    }

    public void setUserName(String text) {
        Reporter.log("Setting User Name " + userName.toString());
        sendTextToElement(userName, text);
    }

    public void setUserRoleDropDown(String text) {
        Reporter.log("Setting user role  : " + text + " to " + userRoleDropDown.toString());
        selectByVisibleTextFromDropDown(userRoleDropDown, text);
    }

    public void setEmployeeName(String text) {
        Reporter.log("Setting Employee Name : " + text + " to " + employeeName.toString());
        sendTextToElement(employeeName, text);
    }

    public void setStatus(String text) {
        Reporter.log("Setting user status : " + text + " to " + status.toString());
        selectByVisibleTextFromDropDown(status, text);
    }

    public void setSearchButton() {
        Reporter.log("Clicking on Search Button : " + searchButton.toString());
        clickOnElement(searchButton);
    }

    public void setSearchResultCheckbox() {
        Reporter.log("Clicking on Search username checkbox : " + searchResultCheckbox.toString());
        clickOnElement(searchResultCheckbox);
    }

    public void setDeleteButton() {
        Reporter.log("Clicking on delete button : " + deleteButton.toString());
        clickOnElement(deleteButton);
    }

    public String getDeletionConfirmation() {
        Reporter.log("Getting on delete confirm : " + successConfirmMessage.toString());
        return getTextFromElement(successConfirmMessage);
    }

}
