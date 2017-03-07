package tests;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by SE on 3/4/2017.
 */
public class ClinicianPageTest extends BaseWebDriver {

    HomePage homePage;
    Boolean result;

    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("Clinician");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    @Test
    public void CreateMyPlan() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "clinicianToDoVisit.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }
    }


    //@AfterMethod
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
