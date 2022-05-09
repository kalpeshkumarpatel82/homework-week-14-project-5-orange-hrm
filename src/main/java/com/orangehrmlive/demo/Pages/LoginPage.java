package com.orangehrmlive.demo.Pages;
/* 
 Created by Kalpesh Patel
 */

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement loginPageHeader;



    public void setUserName(String text){
        Reporter.log("Sending text to login field " + userName.toString());
        sendTextToElement(userName,text);
    }

    public void setPassword(String text){
        Reporter.log("Sending text to password field " + password.toString());
        sendTextToElement(password,text);
    }

    public void setLoginButton(){
        Reporter.log("Clicking on Login button " + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getLoginHeader(){
        Reporter.log("Getting on Login Page Header " + loginPageHeader.toString());
        return getTextFromElement(loginPageHeader);
    }

}
