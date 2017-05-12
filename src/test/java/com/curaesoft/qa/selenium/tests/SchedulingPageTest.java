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
 * Created by SE on 3/2/2017.
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

    @Test (priority=4)
    public void SetPatientSchedule() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "scheduling.xlsx");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }
    @Test (priority=5)
    public void SetFrequencyVisit() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Scheduling - Visit Frequency.xlsx");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }
    @Test (priority=6)
    public void SetVisitType() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Scheduling - Sort by Visit Type.xlsx");
        } catch (Exception e) {
            Constant.Success  = false;
            e.printStackTrace();
            System.out.println("Failed to set patient schedule.");
        }
    }
    @AfterMethod
    public void logout() {
        System.out.println(Constant.Debugging);
        System.out.println(Constant.Success );
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
