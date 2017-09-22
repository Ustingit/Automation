package tests;

import com.curaesoft.qa.selenium.Config.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;

public class CQTestPage  extends BaseWebDriver {

    HomePage homePage;
    Boolean result;
    Boolean success = true;
    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("Cq");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }


    @Test (priority=501)
    public void complain() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "CQ.xlsx","complain");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to test CQ.");
        }
    }

    @Test (priority=502)
    public void kudo() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "CQ.xlsx","kudo");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to test CQ.");
        }
    }

    @Test (priority=503)
    public void CareCoordination() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "CQ.xlsx","CareCoordination");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to test CQ.");
        }
    }
    
    @Test (priority=504)
    public void delete() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "CQ.xlsx","delete");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Failed to test CQ.");
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
