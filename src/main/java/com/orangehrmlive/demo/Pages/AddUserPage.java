package com.orangehrmlive.demo.Pages;
/* 
 Created by Kalpesh Patel
 */

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AddUserPage extends Utility {
    public AddUserPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='systemUser_userType']")
    WebElement userRoleDropDown;
    @FindBy(xpath = "//input[@id='systemUser_employeeName_empName']")
    WebElement employeeName;
    @FindBy(xpath = "//input[@id='systemUser_userName']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='systemUser_password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='systemUser_confirmPassword']")
    WebElement confirmPassword;
    @FindBy(xpath = "//select[@id='systemUser_status']")
    WebElement statusDropDown;
    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement saveButton;
    @FindBy(xpath = "//input[@id='btnCancel']")
    WebElement cancelButton;
    @FindBy(xpath = "//h1[@id='UserHeading']")
    WebElement addUserHeader;
    @FindBy(xpath = "//*[contains(text(),'Successfully Saved')]")
    WebElement conFirmMessage;

    public String getPageHeader() {
        Reporter.log("Getting Page Header " + addUserHeader.toString());
        return getTextFromElement(addUserHeader);
    }

    public void setUserRoleDropDown(String text) {
        Reporter.log("Setting User Role " + userRoleDropDown.toString());
        selectByVisibleTextFromDropDown(userRoleDropDown, text);
    }

    public void setEmployeeName(String text) {
        Reporter.log("Setting Employee Name " + employeeName.toString());
        sendTextToElement(employeeName, text);
    }

    public void setUserName(String text) {
        Reporter.log("Setting User Name " + userName.toString());
        sendTextToElement(userName, text+(int)(Math.random()*10000));
    }

    public void setStatusDropDown(String text) {
        Reporter.log("Setting Status  " + statusDropDown.toString());
        selectByVisibleTextFromDropDown(statusDropDown, text);
    }

    public void setPassword(String text) {
        Reporter.log("Setting Password " + password.toString());
        sendTextToElement(password, text);
    }

    public void setConfirmPassword(String text) {
        Reporter.log("Setting Confirm Password " + confirmPassword.toString());
        sendTextToElement(confirmPassword, text);
    }

    public void setSaveButton() {
        Reporter.log("Clicking on Save Button " + saveButton.toString());
        clickOnElement(saveButton);
    }

    public void setCancelButton() {
        Reporter.log("Clicking on Cancel Button " + cancelButton.toString());
        sendTextToElement(cancelButton);
    }

    public String getConfirmMessage(){
        Reporter.log("Getting Confirm Message " + conFirmMessage.toString());
        return getTextFromElement(confirmPassword);
    }


}
