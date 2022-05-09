package com.orangehrmlive.demo.Pages;
/* 
 Created by Kalpesh Patel
 */

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]")
    WebElement logo;
    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminMenu;
    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    WebElement pimMenu;
    @FindBy(xpath = "//b[contains(text(),'Leave')]")
    WebElement leaveMenu;
    @FindBy(xpath = "//b[contains(text(),'Dashboard')]")
    WebElement dashboardMenu;
    @FindBy(xpath = "//a[@id='welcome']")
    WebElement welcomeMessage;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logOutButton;

    public void setUserProfileLogoHoverAndClick() {
        Reporter.log("Clicking on User LOgo link " + welcomeMessage.toString());
        mouseHoverToElement(welcomeMessage);
        clickOnElement(welcomeMessage);
    }

    public void setLogOutButton() {
        Reporter.log("Clicking on User logOut Button " + logOutButton.toString());
        clickOnElement(logOutButton);
    }


    public void setAdminMenu() {
        Reporter.log("Clicking on Admin link " + adminMenu.toString());
        clickOnElement(adminMenu);
    }

    public boolean getLogoDisplayed() {
        Reporter.log("Checking  Logo " + logo.toString());
        return verifyThatElementIsDisplayed(logo);
    }

    public void setPimMenu() {
        Reporter.log("Clicking on PIM link " + pimMenu.toString());
        clickOnElement(pimMenu);
    }

    public void setLeaveMenu() {
        Reporter.log("Clicking on Leave link " + leaveMenu.toString());
        clickOnElement(leaveMenu);
    }


    public String getWelcomeMessage() {
        Reporter.log("Clicking on Welcome link " + welcomeMessage.toString());
        return getTextFromElement(welcomeMessage).substring(0, 7);
    }

    public void setDashboardMenu() {
        Reporter.log("Clicking on Deshboard link " + dashboardMenu.toString());
        clickOnElement(dashboardMenu);
    }


}
