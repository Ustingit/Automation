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
 * //Priority 701-799
 */
public class RenamePageTest  extends BaseWebDriver {
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


    @Test(priority=701 , groups = {"patientdetails"})

    public void EditPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "EditName.xlsx","EditPatient");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }

    }
    @Test(priority=702 , groups = {"patientdetails"})

    public void Scheduling() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "EditName.xlsx","Scheduler");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }

    }
    @Test(priority=703 , groups = {"patientdetails"})

    public void AuditingNote() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "EditName.xlsx","AuditingNote");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }

    }

    @Test(priority=704 , groups = {"patientdetails"})

    public void AuditingOrder() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "EditName.xlsx","AuditingOrder");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }

    }


    @Test(priority=705 , groups = {"patientdetails"})

    public void Authorization() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "EditName.xlsx","Authorization");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }

    }


    @Test(priority=706 , groups = {"patientdetails"})

    public void CQ() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "EditName.xlsx","CQ");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
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
            Assert.fail(e.toString());
        }
    }
}
