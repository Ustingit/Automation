package tests;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.Config.Constant;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
            homePage = this.loginPage.login("qa");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to login into the application !");
        }
    }


    @Test(priority=1 , groups = {"patientdetails"})

    public void createPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "Admission.xlsx","CreatePatient");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }

    }

    @Test(priority=2,groups = {"patientdetails"})

    public void createAdmissionForNewPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
             eu.execute(this.driver, "Admission.xlsx","Inprocessing01");
        }catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create admission for new patient.");
        }

    }


    @Test(priority=3 , groups = {"patientdetails"})

    public void Approval01() {
        try {
            ExcelUtils eu = new ExcelUtils();         
            eu.execute(this.driver, "Admission.xlsx", "InApproval01");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }

    }


    @Test(priority=4,groups = {"patientdetails"})

    public void InProcessing02() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","InProcessing02");
        }catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create admission for new patient.");

        }

    }

    @Test(priority=5 , groups = {"patientdetails"})

    public void AdmissionInApproval2() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","InApproval02");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }

    }



    @Test(priority=6 , groups = {"patientdetails"})

    public void createPatient2() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","CreatePatient2");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
            Assert.fail(e.toString());
        }

    }


    @Test(priority=7,groups = {"patientdetails"})

    public void createAdmission2() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","CreateAdmission2");
        }catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for new patient.");
            Assert.fail(e.toString());
        }

    }

    @Test(priority=8,groups = {"patientdetails"})

    public void NonAdmit() {
        try {
            ExcelUtils eu = new ExcelUtils();
             eu.execute(this.driver, "Admission.xlsx","Non-Admit");
        }catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for new patient.");
            Assert.fail(e.toString());
        }

    }


    @Test(priority=9 ,groups = "patientdetails" )

    public void CreatePatient3() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","CreatePatient3");
        }catch (Exception e){
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for old patient.");
            Assert.fail(e.toString());
        }

    }

    @Test(priority=10 ,groups = "patientdetails" )

    public void CreateAdmission3() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","CreateAdmission3");
        }catch (Exception e){
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for old patient.");
            Assert.fail(e.toString());
        }

    }

    @Test(priority=11 ,groups = "patientdetails" )

    public void Checklist() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","Checklist");
        }catch (Exception e){
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for old patient.");
            Assert.fail(e.toString());
        }

    }

    @Test(priority=12 ,groups = "patientdetails" )

    public void Suspend() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","Suspend");
        }catch (Exception e){
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for old patient.");
            Assert.fail(e.toString());
        }

    }

   // @Test(priority=13 ,groups = "patientdetails" )

    public void Validate() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Admission.xlsx","Validate");
        }catch (Exception e){
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create admission for old patient.");
            Assert.fail(e.toString());
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
            Assert.fail(e.toString());
        }
    }
}
