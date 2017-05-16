package tests;

import com.curaesoft.qa.selenium.Config.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;

/**
 * Created by SE on 3/4/2017.
 */
public class ClinicianPageTest extends BaseWebDriver {

    HomePage homePage;
    Boolean result;
    Boolean success = true;
    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("PT");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }
    @Test (priority=5)

    public void ViewOfficeNotes() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician Office Notes.xlsx");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to View Office Notes.");
        }
    }
    @Test (priority=5)

    public void CreateMyPlan() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician Task.xlsx");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to View Office Notes.");
        }
    }

    @Test (priority=5)
    public void SigninClinician() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "clinicianToDoVisit.xlsx");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }
    @Test (priority=6)

    public void OASIS_Administrative() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician - OASIS.xlsx");
            eu.execute(this.driver, "Clinician - Administrative.xlsx");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }
    @Test (priority=6)

    public void PlanOfCare() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician - Plan of care.xlsx");
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
