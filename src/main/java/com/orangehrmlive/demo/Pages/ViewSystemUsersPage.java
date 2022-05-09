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

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectRecord_55']")
    WebElement searchResultCheckbox;

    @FindBy(xpath = "//input[@id='btnDelete']")
    WebElement deleteButton;
    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordFound;

    public String getNoRecordFound() {
        Reporter.log("getting search reasult  " + noRecordFound.toString());
        return getTextFromElement(noRecordFound);
    }

    @FindBy(xpath = "//input[@id='resetBtn']")
    WebElement resetButton;
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addButton;

    @FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
    WebElement conFirmMessage;

    public String getSearchResult() {
        Reporter.log("getting search reasult  " + searchResult.toString());
        return getTextFromElement(searchResult);
    }


    public void setUserName(String text) {
        Reporter.log("Setting User Name " + userName.toString());
        sendTextToElement(userName, text);
    }

    public void setUserRoleDropDown(String text) {
        Reporter.log("Setting user role  " + userRoleDropDown.toString());
        selectByVisibleTextFromDropDown(userRoleDropDown, text);
    }

    public void setEmployeeName(String text) {
        Reporter.log("Setting Employee Name " + employeeName.toString());
        sendTextToElement(employeeName, text);
    }

    public void setStatus(String text) {
        Reporter.log("Setting user status  " + status.toString());
        selectByVisibleTextFromDropDown(status, text);
    }

    public void setSearchButton() {
        Reporter.log("Clicking on Search Button  " + searchButton.toString());
        clickOnElement(searchButton);
    }

    public void setSearchResultCheckbox() {
        Reporter.log("Clicking on Search username checkbox  " + searchResultCheckbox.toString());
        clickOnElement(searchResultCheckbox);
    }

    public void setDeleteButton() {
        Reporter.log("Clicking on delete button  " + deleteButton.toString());
        clickOnElement(deleteButton);
    }

    public String getDeletionConfirmation() {
        Reporter.log("Getting on delete confirm  " + conFirmMessage.toString());
        return getTextFromElement(conFirmMessage);
    }


}
