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
    @Test (priority=31)

    public void VerifyClinicianAccountforPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","VerifyClinician");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to View Office Notes.");
        }
    }

    @Test (priority=32)

    public void ViewOfficeNotes() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","OfficeNotes");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to View Office Notes.");
        }
    }
    @Test (priority=33)

    public void CreateMyPlan() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","Myplan");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to View Office Notes.");
        }
    }

    @Test (priority=34)
    public void SigninClinician() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","Clinician");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }
    @Test (priority=35)

    public void OasisAdministrative() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","oasis");
            eu.execute(this.driver, "Clinician.xlsx","Administrative");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }
    @Test (priority=35)

    public void OasisGeneral() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","oasis");
            eu.execute(this.driver, "Clinician.xlsx","General");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }
   // @Test (priority=35)

//    public void OasisPlanOfCare() {
//        try {
//            ExcelUtils eu = new ExcelUtils();
//            eu.execute(this.driver, "Clinician.xlsx","oasis");
//            eu.execute(this.driver, "Clinician.xlsx","PlanofCare");
//        } catch (Exception e) {
//            success = false;
//            e.printStackTrace();
//            System.out.println("Failed to create patient.");
//        }
//    }

    @Test (priority=36)

    public void CreateComm() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","Comm");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to Create Comm.");
        }
    }
    @Test (priority=37)

    public void CreateOrder() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","Order");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to Create Comm.");
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
