package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;

/**
 * Created by SE on 2/22/2017.
 */
public class ProfilePageTest extends BaseWebDriver {
    HomePage homePage;
    Boolean result;

    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("intake");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    @Test (priority=6)
    public void UpdateSettings() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "profile.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }


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
