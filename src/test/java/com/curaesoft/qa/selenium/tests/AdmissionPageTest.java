package com.curaesoft.qa.selenium.tests;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;
import com.curaesoft.qa.selenium.CommonPages.AdmissionPage;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by SE on 2/17/2017.
 */
public class AdmissionPageTest  extends BaseWebDriver {
    HomePage homePage;
    Boolean result;

    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("Intake");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    @Test
    public void createPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "resources/admissionCreatePatient.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }

    @Test(priority=2)
    public void createAdmissionForNewPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "resources/admissionForNewPatient.xlsx");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create admission for new patient.");
        }
    }

    @Test(priority=3)
    public void createAdmissionForOldPatient() {
        ExcelUtils eu = new ExcelUtils();
        eu.execute(this.driver, "resources/admissionForOldPatient.xlsx");
    }

    @AfterMethod
    public void logout() {
        try {
            result = this.loginPage.logout();
            Assert.assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application");
        }
    }
}
