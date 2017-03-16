package tests;

import com.curaesoft.qa.selenium.Config.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;


public class AccountCreation extends BaseWebDriver{
    HomePage homePage;
    Boolean result;
    Boolean success = true;

    @BeforeMethod
    public void login() {
        try {
            homePage = this.loginPage.login("admin");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }


    @Test

    public void createAccount() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "AccountCreation.xlsx");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create accounts.");
        }

    }
    @Test

    public void createClinicainAccount() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "AccountCreation.xlsx");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create accounts.");
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
            success = false;
            e.printStackTrace();
            System.out.println("Failed to login into the application");
        }
    }
}
