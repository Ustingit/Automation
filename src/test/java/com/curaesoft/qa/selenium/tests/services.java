package tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


import io.github.bonigarcia.wdm.ChromeDriverManager;



public class services {
	protected WebDriver driver;
	String url = "https://curaesoft.com/#/login";
	int timeout = 10;
	
	@BeforeClass
	public void setUp() {

		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
    public void login() {
        try {
        	input("//*[@id=\"email\"]","kavya.mothukuri@cvhcare.com");
        	input("//*[@id=\"password\"]","QaTeam04!");
        	click("//*[@id=\"ui-login\"]/div/div/md-card/md-content/form/button");
        } catch (Exception e) {
            System.out.println("Failed to login into the application !");
        }
    }
	
	
	 @AfterMethod
    public void logout() {
			driver.navigate().to(url);
    }

	@AfterClass
	public void tearDown() {
			driver.close();
			
	}
	
	@Test(priority = 1)
    public void Profile() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Profile']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Profile')]");
        } catch (Exception e) {
        	Assert.fail("Profile Service Test Fail //n"+e);
     
        }
    }
	
	@Test(priority = 2)
    public void CSmail() {
        try {
        	click("//div[@layout='column']/button[@aria-label='CSmail']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Inbox')]");
        } catch (Exception e) {
        	Assert.fail("CSmail Service Test Fail //n"+e);
        }
    }
	
	@Test(priority = 3)
    public void Physician_List() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Physician List']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Physician')]");
        } catch (Exception e) {
        	Assert.fail("Physician_List Service Test Fail //n"+e);
        }
    }
	
	@Test(priority = 4)
    public void Insurance_List() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Insurance List']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Insurance')]");
        } catch (Exception e) {
        	Assert.fail("Insurance_List Service Test Fail //n"+e);
        }
    }
	
	@Test(priority = 5)
    public void Patient_List() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Patient List']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Patient')]");
        } catch (Exception e) {
        	Assert.fail("Patient List Service Test Fail //n"+e);
        }
    }
	
	@Test(priority = 6)
    public void Emergency() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Compliance & Quality']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Home')]");
        	Thread.sleep(1000);
        	click("//div[@layout='column']/button[@aria-label='Emergency']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Emergency')]");
        } catch (Exception e) {
        	Assert.fail("Emergency Service Test Fail //n"+e);
        }
    }
	@Test(priority = 7)
    public void Follow_Ups() {
        try { 
        	click("//div[@layout='column']/button[@aria-label='Compliance & Quality']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Home')]");
        	Thread.sleep(1000);
        	click("//div[@layout='column']/button[@aria-label='Follow Ups']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Follow Ups')]");
        } catch (Exception e) {
        	Assert.fail("Follow Ups Service Test Fail //n"+e);
        }
    }
	@Test(priority = 8)
    public void Billing() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Finance']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Welcome')]");
        	Thread.sleep(1000);
        	click("//div[@layout='column']/button[@aria-label='Billing']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Billing')]");
        } catch (Exception e) {
        	Assert.fail("Billing Service Test Fail //n"+e);
        }
    }
	@Test(priority = 9)
    public void Billing_Package() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Finance']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Welcome')]");
        	Thread.sleep(1000);
        	click("//div[@layout='column']/button[@aria-label='Billing Package']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Billing Package')]");
        } catch (Exception e) {
        	Assert.fail("Billing Package Service Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Admissions() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Admission']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Admissions')]");
        } catch (Exception e) {
        	Assert.fail("Admissions Service Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Admission_Analyzer() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Admission Analyzer']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        } catch (Exception e) {
        	Assert.fail("Admission Analyzer Service Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Episode_Activity() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Episode Activity']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        } catch (Exception e) {
        	Assert.fail("Episode Activity Service Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Scheduling() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Scheduling']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Episodes')]");
        } catch (Exception e) {
        	Assert.fail("Episode Activity Service Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Oasis() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Filing']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	
        } catch (Exception e) {
        	Assert.fail("Oasis Service Test Fail //n"+e);
        }
    }
	//@Test(priority = 10)
    public void Signing() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Oasis']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Signing']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	
        } catch (Exception e) {
        	Assert.fail("Signing Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Checklist() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Auditing']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Checklist']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	
        } catch (Exception e) {
        	Assert.fail("Checklist Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Note_Audit() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Auditing']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Note Audit']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Note Audits')]");
        	
        } catch (Exception e) {
        	Assert.fail("Note Audit Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Order_Audit() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Auditing']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Order Audit']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Order Audits')]");
        	
        } catch (Exception e) {
        	Assert.fail("Order Audit Test Fail //n"+e);
        }
    }
	
	@Test(priority = 10)
    public void Authorization() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Authorization']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	
        } catch (Exception e) {
        	Assert.fail("Authorization Audit Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Orders() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Orders']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Orders')]");
        	
        } catch (Exception e) {
        	Assert.fail("Orders Audit Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Account_List() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Referral']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Referral')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Account']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Account List')]");
        } catch (Exception e) {
        	Assert.fail("Account List Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Contact_List() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Referral']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Referral')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Contact']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Contact List')]");
        } catch (Exception e) {
        	Assert.fail("Contact List Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
    public void Scheduling_Analyzer() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Operations']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Scheduling Analyzer']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Operation')]");
        } catch (Exception e) {
        	Assert.fail("Scheduling Analyzer Test Fail //n"+e);
        }
    }
	
	@Test(priority = 10)
	public void Clinician_Audti() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Clinician Portal']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Clinician')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Audit']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Note Audits')]");
        } catch (Exception e) {
        	Assert.fail("Clinician_Audti Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
	public void Clinician_Past_Visit() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Clinician Portal']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Clinician')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='Past Visit']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Past')]");
        } catch (Exception e) {
        	Assert.fail("Past Visit Test Fail //n"+e);
        }
    }
	@Test(priority = 10)
	public void Clinician_To_Do() {
        try {
        	click("//div[@layout='column']/button[@aria-label='Clinician Portal']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'Clinician')]");
        	Thread.sleep(2000);
        	click("//div[@layout='column']/button[@aria-label='To-Do Visit']");
        	visible("//span/span[@class='ng-scope ng-binding' and contains(text(),'To-do')]");
        } catch (Exception e) {
        	Assert.fail("To-Do Visit Test Fail //n"+e);
        }
    }
	public void input(String xpath, String value) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element.clear();
		element.sendKeys(value);
		
	}
	public void click(String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element.click();
	}
	
	public void visible(String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		element.isDisplayed();
	}

}
