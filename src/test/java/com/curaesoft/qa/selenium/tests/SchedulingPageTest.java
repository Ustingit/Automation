package com.curaesoft.qa.selenium.tests;

import com.curaesoft.qa.selenium.Config.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;

/**
 * Created by SE on 3/2/2017.
 * priority 101-199
 */
public class SchedulingPageTest extends BaseWebDriver {

    HomePage homePage;
    Boolean result;

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
    @Test (priority=101)
    public void SetPatientToActive() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","SetActive");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }
    @Test (priority=102)
    public void SetAllergen() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","Allergen");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }
    @Test (priority=102)
    public void CheckPreauthVisit() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","CheckPreAuth");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }
    @Test (priority=103)
    public void CreateNotes() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","Notes");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }
    @Test (priority=104)
    public void AddandDeleteSchedule() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","AddSched");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }

    @Test (priority=105)
    public void SetPatientSchedule() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","Scheduling");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }

    @Test (priority=106)
    public void SetFrequencyVisit() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","VisitFrequency");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }


    @Test (priority=107)
    public void CommNotes() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","CommNotes");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }
    //@Test (priority=107)
    public void SortVisit() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx","SortViisit");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
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
