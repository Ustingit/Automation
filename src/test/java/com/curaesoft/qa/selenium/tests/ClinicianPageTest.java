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
 * Created by SE on 3/4/2017.
 */
public class ClinicianPageTest extends BaseWebDriver {

    HomePage homePage;
    Boolean result;
    Boolean success = true;
    @BeforeMethod
    public void login() {

        try {
            homePage = this.loginPage.login("rn");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to login into the application !");
        }
    }
    @Test (priority=41)

    public void VerifyClinicianAccountforPatient() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","VerifyClinician");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to View Office Notes.");
        }
    }

    @Test (priority=42)

    public void ViewOfficeNotes() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","OfficeNotes");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to View Office Notes.");
        }
    }
    @Test (priority=43)

    public void CreateMyPlan() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","Myplan");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to View Office Notes.");
        }
    }

    @Test (priority=44)
    public void SigninClinician() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","Clinician");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to Sign in Clinician.");
        }
    }
    @Test (priority=45)

    public void OasisAdministrative() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","oasis");
            eu.execute(this.driver, "Clinician.xlsx","Administrative");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Fail to complete Administrative notes.");
        }
    }
    @Test (priority=45)

    public void OasisGeneral() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","oasis");
            eu.execute(this.driver, "Clinician.xlsx","General");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Fail to complete General notes.");
        }
    }
   @Test (priority=45)

    public void OasisPlanOfCare() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","oasis");
            eu.execute(this.driver, "Clinician.xlsx","PlanofCare");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Fail to complete PlanOfCare notes.");
        }
    }
   @Test (priority=45)

    public void OasisRiskPrognosis() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","oasis");
            eu.execute(this.driver, "Clinician.xlsx","RiskPrognosis");
        } catch (Exception e) {
            success = false;
            e.printStackTrace();
            System.out.println("Fail to complete RiskPrognosis notes.");
        }
    }
	 @Test (priority=45)
	
	 public void OasisHistoryDiagnoses() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","HistoryDiagnoses");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete HistoryDiagnoses notes.");
	     }
	 }
	 @Test (priority=45)
		
	 public void OasisCardiac() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","Cardiac");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete Cardiac notes.");
	     }
	 }
	 @Test (priority=45)
		
	 public void OasisSensory() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","Sensory");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete Sensory notes.");
	     }
	 }
	 @Test (priority=45)
		
	 public void OasisRespiratory() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","Respiratory");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete Respiratory notes.");
	     }
	 }
	 @Test (priority=45)
		
	 public void OasisGastrointestinal() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","Respiratory");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete Gastrointestinal notes.");
	     }
	 }
	 @Test (priority=45)
		
	 public void OasisNeurological() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","Neurological");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete Neurological notes.");
	     }
	 }
	 @Test (priority=45)
		
	 public void OasisGastrointestinal() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","Gastrointestinal");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete Gastrointestinal notes.");
	     }
	 }
	 @Test (priority=45)
		
	 public void Integumentary() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","Integumentary");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete Integumentary notes.");
	     }
	 }
	 @Test (priority=45)
		
	 public void Musculoskeletal() {
	     try {
	         ExcelUtils eu = new ExcelUtils();
	         eu.execute(this.driver, "Clinician.xlsx","oasis");
	         eu.execute(this.driver, "Clinician.xlsx","Musculoskeletal");
	     } catch (Exception e) {
	         success = false;
	         e.printStackTrace();
	         System.out.println("Fail to complete Musculoskeletal notes.");
	     }
	 }
    @Test (priority=46)

    public void CreateComm() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","Comm");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to Create Comm.");
        }
    }
    @Test (priority=47)

    public void CreateOrder() {
        try {
            ExcelUtils eu = new ExcelUtils();
            eu.execute(this.driver, "Clinician.xlsx","Order");
        } catch (Exception e) {
            Constant.Success = false;
            e.printStackTrace();
            System.out.println("Failed to Create Comm.");
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
