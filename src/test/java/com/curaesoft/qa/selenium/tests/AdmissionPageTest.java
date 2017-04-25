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
 * Created by SE on 2/17/2017.
 */
public class AdmissionPageTest  extends BaseWebDriver {
    HomePage homePage;
    Boolean result;
    Boolean success = true;
    @BeforeMethod
    public void login() {
        try {
            homePage = this.loginPage.login("Intake");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }


    @Test(priority=1 , groups = {"patientdetails"})

    public void createPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "admissionCreatePatient.xlsx");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }

    }


    @Test(priority=2,groups = {"patientdetails"})

    public void createAdmissionForNewPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
             eu.execute(this.driver, "admissionForNewPatient.xlsx");
        }catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for new patient.");
        }

    }

    // this is not applicable on the new bisuness flow since it wont accept 2 scheduling
    //@Test(priority=3 ,dependsOnGroups = "patientdetails" )

    public void createAdmissionForOldPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "admissionForOldPatient.xlsx");
        }catch (Exception e){
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for old patient.");
        }

    }

    @AfterMethod
    public void logout() {
        try {
            if(Constant.Debugging == false ){
                if(success){
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
