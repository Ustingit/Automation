package com.curaesoft.qa.selenium.tests;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.Config.Constant;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;
import org.testng.Assert;
import org
        .testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by SE on 3/15/2017.
 */
public class AuditTestPage  extends BaseWebDriver {
    HomePage homePage;
    Boolean result;
    Boolean success = true;

    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("Auditor");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    //@Test

    public void NoteApproval() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "NoteAudit.xlsx");
        } catch (Exception e) {
            success = true;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }
    @Test(priority=6)
    public void OrderNotes() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "OrderAudit.xlsx");
        } catch (Exception e) {
            success = true;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }

    @AfterMethod
    public void logout() {
        try {
            if(Constant.Debugging == true ){
                if(success){
                    result = this.loginPage.logout();
                    Assert.assertTrue(result);
                }
            }
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to login into the application");
        }
    }
}
