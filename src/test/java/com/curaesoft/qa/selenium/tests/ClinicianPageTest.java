package com.curaesoft.qa.selenium.tests;

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
 * priority 301-399
 */
public class ClinicianPageTest extends BaseWebDriver {

	HomePage homePage;
	Boolean result;
	Boolean success = true;

	@BeforeMethod
	public void login() {

		try {
			homePage = this.loginPage.login("pt");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to login into the application !");
		}
	}

	@Test(priority = 301)
	public void VerifyClinicianAccountforPatient() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "VerifyClinician");
		} catch (Exception e) {
			Constant.Success = false;
			e.printStackTrace();
			System.out.println("Failed to View Office Notes.");
		}
	}

	@Test(priority = 302)

	public void ViewOfficeNotes() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "OfficeNotes");
		} catch (Exception e) {
			Constant.Success = false;
			e.printStackTrace();
			System.out.println("Failed to View Office Notes.");
		}
	}

	@Test(priority = 303)

	public void CreateMyPlan() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "Myplan");
		} catch (Exception e) {
			Constant.Success = false;
			e.printStackTrace();
			System.out.println("Failed to View Office Notes.");
		}
	}

	@Test(priority = 304)
	public void SigninClinician() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "Clinician");
		} catch (Exception e) {
			Constant.Success = false;
			e.printStackTrace();
			System.out.println("Failed to Sign in Clinician.");
		}
	}

	@Test(priority = 305)

	public void OasisAdministrative() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Administrative");
		} catch (Exception e) {
			Constant.Success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Administrative notes.");
		}
	}

	@Test(priority = 306)

	public void OasisGeneral() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "General");
		} catch (Exception e) {
			Constant.Success = false;
			e.printStackTrace();
			System.out.println("Fail to complete General notes.");
		}
	}

	@Test(priority = 307)

	public void OasisPlanOfCare() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "PlanofCare");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete PlanOfCare notes.");
		}
	}

	@Test(priority = 308)

	public void OasisRiskPrognosis() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "RiskPrognosis");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete RiskPrognosis notes.");
		}
	}

	@Test(priority = 309)

	public void OasisHistoryDiagnoses() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "HistoryDiagnoses");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete HistoryDiagnoses notes.");
		}
	}

	@Test(priority = 310)

	public void OasisCardiac() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Cardiac");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Cardiac notes.");
		}
	}

	@Test(priority = 311)

	public void OasisSensory() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Sensory");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Sensory notes.");
		}
	}

	@Test(priority = 312)

	public void OasisRespiratory() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Respiratory");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Respiratory notes.");
		}
	}

	@Test(priority = 313)

	public void OasisGastrointestinal() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Gastrointestinal");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Gastrointestinal notes.");
		}
	}


	@Test(priority = 314)

	public void OasisNeurological() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Neurological");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Neurological notes.");
		}
	}

	@Test(priority = 315)

	public void OasisIntegumentary() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Integumentary");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Integumentary notes.");
		}
	}

	@Test(priority = 316)

	public void OasisMusculoskeletal() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Musculoskeletal");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Musculoskeletal notes.");
		}
	}

	@Test(priority = 317)

	public void OasisGenitourinary() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Genitourinary");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Genitourinary notes.");
		}
	}
	@Test(priority = 318)

	public void OasisSupportive() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Supportive");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Supportive notes.");
		}
	}

	@Test(priority = 319)

	public void OasisSubjective() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Subjective");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Subjective notes.");
		}
	}


	@Test(priority = 320)

	public void OasisObjective() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "Objective");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Objective notes.");
		}
	}


	@Test(priority = 321)

	public void OasisAssessmentSummary() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "AssessmentSummary");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Assessment Summary notes.");
		}
	}
	@Test(priority = 322)

	public void OasisICD10() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "ICD10");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete ICD10 notes.");
		}
	}

	@Test(priority = 323)

	public void OasisTreatmentPlanning() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "TreatmentPlanning");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete ICD10 notes.");
		}
	}
	@Test(priority = 324)

	public void OasisSubmitNotes() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "NoteSubmit");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to Submit Notes.");
		}
	}
	@Test(priority = 325)

	public void OasisVerifyNotes() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "oasis");
			eu.execute(this.driver, "Clinician.xlsx", "VerifyNotes");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to Verify  Notes.");
		}
	}
	//@Test(priority = 47)

	public void SignOut() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "Signout");
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
			System.out.println("Fail to complete Genitourinary notes.");
		}
	}
	@Test(priority = 326)

	public void CreateComm() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "Comm");
		} catch (Exception e) {
			Constant.Success = false;
			e.printStackTrace();
			System.out.println("Failed to Create Comm.");
		}
	}

	@Test(priority = 327)

	public void CreateOrder() {
		try {
			ExcelUtils eu = new ExcelUtils();
			eu.execute(this.driver, "Clinician.xlsx", "Order");
		} catch (Exception e) {
			Constant.Success = false;
			e.printStackTrace();
			System.out.println("Failed to Create Comm.");
		}
	}

	@AfterMethod
	public void logout() {

		try {
			if (Constant.Debugging == false) {
				result = this.loginPage.logout();
				Assert.assertTrue(result);
			} else {
				if (Constant.Success) {
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
