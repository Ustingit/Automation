package com.curaesoft.qa.selenium.tests;


import java.util.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.awt.datatransfer.StringSelection;
import com.curaesoft.qa.selenium.Config.Constant;
import org.apache.poi.sl.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.awt.Toolkit;
import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;


/**
 * Created by SE on 5/5/2017.
 * priority 201-299
 */
public class AuthzPageTest extends BaseWebDriver {
    HomePage homePage;
    Boolean result;
    Boolean success = true;

    @BeforeMethod
    public void login() {
        try {
            homePage = this.loginPage.login("qa");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }

    @Test (priority = 201)

    public void AssignTo () {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Authorization.xlsx","AuthorizationASSIGNTO");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create AssignTo");
        }
    }

    @Test (priority = 202)

        public void DeAssign () {
            try {
                ExcelUtils eu = new ExcelUtils();
                eu.execute(this.driver, "Authorization.xlsx","AuthorizationDEASSIGN");
            } catch (Exception e) {
                success = false;
                e.printStackTrace();
                Assert.fail(e.toString());
                System.out.println("Failed to create DeAssign");
            }
        }

    @Test(priority = 203)

    public void SendAuthz() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Authorization.xlsx","AuthorizationSendAuths");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create SendAuthz");
        }
    }


    @Test(priority = 204)

    public void AddCorrections() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Authorization.xlsx","AuthorizationAddCorrection");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to login into the application !");
        }


    }

    @Test(priority = 205)

    public void AddCorrectionDecrease() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Authorization.xlsx","AuthorizationAddCorrDecrease");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to login into the application !");
        }

    }


    @Test(priority = 206)

    public void AddComment() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Authorization.xlsx","AuthorizationAddComment");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to login into the application !");
        }


    }


    @Test(priority = 207)

    public void WaitResAuthz() {
        try {
            ExcelUtils ev = new ExcelUtils();
            ev.account();
            ev.execute(this.driver, "Authorization.xlsx","AuthorizationResponseAuthz1");

            List<WebElement> downloadContainer = driver.findElements(By.xpath("//*[@id=\"ui-admin-email\"]/md-content/md-card/md-card-content/md-list-item/div[1]/md-card/md-card-content/div/div[1]/md-content[1]/div[7]/md-table-container/table/tbody"));
            int dlCount = downloadContainer.size();
            //click comment
            //this.driver.findElement(By.xpath("//*[@id=\"ui-admin-email\"]/md-content/md-card/md-card-content/md-list-item/div[1]/md-card/md-card-content/div/div[2]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span[2]")).click();

            //assign visit
            assignVisit(dlCount, 1, "1");
            assignVisit(dlCount, 2, "1");
           assignVisit(dlCount, 3, "1");
           assignVisit(dlCount, 4, "1");
           assignVisit(dlCount, 5, "1");
           assignVisit(dlCount, 6, "1");
           assignVisit(dlCount, 7, "1");

            //upload file
            driver.findElement(By.xpath("(//a[@ngf-select=\"vm.upload($files, exchange)\"])[1]")).click();
            Robot r = new Robot();
            sendKeys(r, "D:\\SE\\Documents\\Desktop\\test.png");

            ev.execute(this.driver, "Authorization.xlsx","AuthorizationResponseAuthz2");

        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create WaitResAuths");
        }
    }



    @Test(priority = 208)

    public void SendAuthz2() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Authorization.xlsx","AuthorizationSendAuths2");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create SendAuthz");
        }
    }


    @Test(priority = 209)

    public void MaximizedVisits() {
        try {

            ExcelUtils ev = new ExcelUtils();
            ev.account();
            ev.execute(this.driver, "Authorization.xlsx","authz3");

            List<WebElement> downloadContainer2 = driver.findElements(By.xpath("//*[@id=\"ui-admin-email\"]/md-content/md-card/md-card-content/md-list-item/div[1]/md-card/md-card-content/div/div[1]/md-content[1]/div[7]/md-table-container/table/tbody"));
            int dlCount2 = downloadContainer2.size();
            //click comment
            // this.driver.findElement(By.xpath("//*[@id=\"ui-admin-email\"]/md-content/md-card/md-card-content/md-list-item/div[1]/md-card/md-card-content/div/div[2]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span[2]")).click();
            //assign visit with approved
            assignVisit(dlCount2, 1, "18");
           assignVisit(dlCount2, 2, "18");
           assignVisit(dlCount2, 3, "18");
          assignVisit(dlCount2, 4, "18");
         assignVisit(dlCount2, 5, "18");
          assignVisit(dlCount2, 6, "18");
          assignVisit(dlCount2, 7, "18");

            ev.execute(this.driver, "Authorization.xlsx","authz4");


        } catch (Exception e) {
            //System.out.println(e);
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create patient.");
        }


    }



    @Test (priority = 210)

    public void ApprovedTab (){
        try {
            ExcelUtils ev = new ExcelUtils();
            ev.account();
            ev.execute(this.driver, "Authorization.xlsx","AuthorizationApproved");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            Assert.fail(e.toString());
            System.out.println("Failed to create SendAuthz");
        }
    }







    public void assignVisit(int tbody , int column, String value) {
        try {

            this.driver.findElement(By.xpath("//*[@id=\"ui-admin-email\"]/md-content/md-card/md-card-content/md-list-item/div[1]/md-card/md-card-content/div/div[1]/md-content[1]/div[7]/md-table-container/table/tbody["+tbody+"]/tr["+column+"]/td[5]/span")).click();

            this.driver.findElement(By.xpath("//md-edit-dialog//md-input-container/input")).sendKeys(value);

            this.driver.findElement(By.xpath("/html/body/md-edit-dialog/div[2]/button[2]")).click();

        }catch (Exception e) {
            Assert.fail(e.toString());

            }


    }
    public void sendKeys( Robot robot  ,String keys) {
        StringSelection ss = new StringSelection(keys);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

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
