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
 * Created by SE on 2/22/2017.
 * //Priority 601-699
 */
public class ProfilePageTest extends BaseWebDriver {
    HomePage homePage;
    Boolean result;
    Boolean success = true;

    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("changepass");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    @Test (priority=601)
    public void UpdateSettings() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "profile.xlsx","profile");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }


    }
    @Test (priority=602)
    public void UpdatePassword() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "profile.xlsx","password");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }


    }
    //@Test (priority=73)
    public void UpdateNotification() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "profile.xlsx","notification");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
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
