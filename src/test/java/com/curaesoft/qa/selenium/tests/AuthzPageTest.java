package tests;


import java.util.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.Character;
import java.awt.datatransfer.StringSelection;

import com.curaesoft.qa.selenium.Config.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import java.awt.Toolkit;
import com.curaesoft.qa.selenium.CommonPages.HomePage;
import com.curaesoft.qa.selenium.base.BaseWebDriver;
import com.curaesoft.qa.selenium.utilities.ExcelUtils;


/**
 * Created by SE on 5/5/2017.
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


    @Test

    public void createPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.account();
            eu.execute(this.driver, "Authz.xlsx");

            List<WebElement> downloadContainer = driver.findElements(By.xpath("//*[@id=\"ui-admin-email\"]/md-content/md-card/md-card-content/md-list-item/div[1]/md-card/md-card-content/div/div[1]/md-content[1]/div[7]/md-table-container/table/tbody"));
            int dlCount = downloadContainer.size();
            //click comment
            this.driver.findElement(By.xpath("//*[@id=\"ui-admin-email\"]/md-content/md-card/md-card-content/md-list-item/div[1]/md-card/md-card-content/div/div[2]/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span[2]")).click();

            //assind visit
            assignVisit(dlCount,1,"0");
            assignVisit(dlCount,2,"0");
            assignVisit(dlCount,3,"0");
            assignVisit(dlCount,4,"0");
            assignVisit(dlCount,5,"0");
            assignVisit(dlCount,6,"0");
            assignVisit(dlCount,7,"0");


            driver.findElement(By.xpath("(//a[@ngf-select=\"vm.upload($files, exchange)\"])[1]")).click();
            Robot r = new Robot();
            sendKeys(r,"D:\\SE/Documents/test.png");
            eu.execute(this.driver, "authz2.xlsx");
        } catch (Exception e) {
            System.out.println(e);
            success = false;
            e.printStackTrace();
            System.out.println("Failed to create patient.");
        }

    }
    public void assignVisit(int tbody , int column, String value){
        this.driver.findElement(By.xpath("//*[@id=\"ui-admin-email\"]/md-content/md-card/md-card-content/md-list-item/div[1]/md-card/md-card-content/div/div[1]/md-content[1]/div[7]/md-table-container/table/tbody["+tbody+"]/tr["+column+"]/td[5]/span")).click();
        this.driver.findElement(By.xpath("//md-edit-dialog//md-input-container/input")).sendKeys(value);
        this.driver.findElement(By.xpath("/html/body/md-edit-dialog/div[2]/button[2]")).click();
    }
    public void sendKeys( Robot robot  ,String keys) {
        StringSelection ss = new StringSelection("D:/Test/Test1.docx");
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
