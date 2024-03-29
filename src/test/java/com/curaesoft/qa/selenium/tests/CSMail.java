package com.curaesoft.qa.selenium.tests;
import com.curaesoft.qa.selenium.Config.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;

public class CSMail extends BaseWebDriver{

    HomePage homePage;
    Boolean result;
    Boolean success = true;
    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("Scheduler");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    @Test (priority=100)
    public void SentMail() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "CSMail.xlsx","Inbox");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }


    }
    @AfterMethod
    public void logout() {

        try {
            if(Constant.Debugging == false){
                result = this.loginPage.logout();
                Assert.assertTrue(result);
            }else{
                if(Constant.Success){
                    result = this.loginPage.logout();
                    Assert.assertTrue(result);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application");
        }
    }
}
