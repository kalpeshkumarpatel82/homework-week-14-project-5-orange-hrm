package com.orangehrmlive.demo.Pages;
/* 
 Created by Kalpesh Patel
 */

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class DashboardPage extends Utility {
    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Dashboard')]")
    WebElement dashboardMenu;

    public String getPageHeader() {
        Reporter.log("Getting Page Header : " + dashboardMenu.toString());
        return getTextFromElement(dashboardMenu);
    }
}
